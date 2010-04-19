/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.DisplayMode;
import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Font;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.swing.JFrame;
import rice.util.Position;

/**
 *
 * @author spock
 */
class ScreenManager extends JFrame{

    private GListener listener;
    private GLCanvas canvas;
    private FPSAnimator fpsanim;
    private ArrayList<GameGraphic> screens;
    private GameGraphic currentScreen;
    private GraphicsTable graphics;
    private ViewableModel model;
    private MSVisitorAcceptor msa;
    private HashMap<String, GameGraphic> screenSelector;

    ScreenManager(boolean fullScreen, ViewableModel model, MSVisitorAcceptor msa){
        
        this.model = model;
        this.msa = msa;


        if(fullScreen){
            GraphicsEnvironment ge = GraphicsEnvironment
                                .getLocalGraphicsEnvironment();
            final GraphicsDevice gs = ge.getDefaultScreenDevice();
            this.setUndecorated(true);
            this.setResizable(false);
            DisplayMode dm = gs.getDisplayMode();
            setSize(dm.getWidth(), dm.getHeight());
            if (gs.isFullScreenSupported()) {
                    gs.setFullScreenWindow(this);
            }
        }
        else{
            setSize(1280, 800);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        listener = new GListener();
        canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);

        getContentPane().getComponents()[0].setFocusable(false);
        fpsanim = new FPSAnimator(canvas, 60);
        setVisible(true);
        this.validate();
    }

    void start(){
        fpsanim.start();
        this.validate();
    }

    void refresh(){
        currentScreen.refresh();
    }

    void setMode(String mode){
        currentScreen = screenSelector.get(mode);
    }

    void toggleMainScreenMode(){
        currentScreen.auxillaryCommand("Toggle");
    }

    class GListener implements GLEventListener {

        TextRenderer renderer;

        public void display(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
            //long time = System.currentTimeMillis();
            currentScreen.render(gl, drawable, renderer);
            //System.err.println("display " + (System.currentTimeMillis() - time));
        }

        public void displayChanged(GLAutoDrawable drawable, boolean arg1, boolean arg2) {
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
            GL gl = drawable.getGL();
            gl.glViewport(0, 0, w, h);
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrtho(0.0, 1.0, 1.0, 0.0, -1.0, 1.0);
            gl.glMatrixMode(GL.GL_MODELVIEW);
            gl.glLoadIdentity();
        }

        public void init(GLAutoDrawable drawable) {

            try {
                GL gl = drawable.getGL();
                gl.glEnable(GL.GL_TEXTURE_2D);								//enable 2D textures
                gl.glEnable(GL.GL_BLEND);
                gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
                graphics = GraphicsTable.getInstance();

                renderer = new TextRenderer(new Font("Serif", Font.BOLD, 22));

                screens = new ArrayList<GameGraphic>();

                screens.add(new TitleScreen());
                screens.add(new MainScreen(msa, model, model.getMapSize()));
                screens.add(new UnitOverviewScreen(model));
                screens.add(new StructureOverviewScreen(model));
                screens.add(new TechOverviewScreen());
                screens.add(new KeyBindingScreen(model));

                screenSelector = new HashMap<String, GameGraphic>();

                screenSelector.put("SplashScreenState", screens.get(0));
                screenSelector.put("MainScreenState", screens.get(1));
                screenSelector.put("UnitOverviewState", screens.get(2));
                screenSelector.put("StructureOverviewState", screens.get(3));
                screenSelector.put("TechOverviewState", screens.get(4));
                screenSelector.put("KeyBindingState", screens.get(5));

                currentScreen = screens.get(0);
                
            }
            catch (GLException e) {
                e.printStackTrace();
	    }
        }
    }

}
