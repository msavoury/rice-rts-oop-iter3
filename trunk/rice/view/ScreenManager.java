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
import javax.media.opengl.GLContext;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.DisplayMode;
import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.ImageUtil;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import com.sun.opengl.util.j2d.TextRenderer;

import java.util.ArrayList;


import javax.swing.JFrame;

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

    ScreenManager(boolean fullScreen){

        screens = new ArrayList<GameGraphic>();

        screens.add(new TitleScreen());
        screens.add(new MainScreen());
        screens.add(new UnitOverviewScreen());
        screens.add(new StructureOverviewScreen());
        screens.add(new TechOverviewScreen());
        screens.add(new KeyBindingScreen());

        //currentScreen

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
        fpsanim = new FPSAnimator(canvas, 60);
        setVisible(true);
        this.validate();
    }

    class GListener implements GLEventListener {

        public void display(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
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

            }
            catch (GLException e) {
                e.printStackTrace();
	    }
        }
    }

}
