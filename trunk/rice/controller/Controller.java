/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import rice.model.Model;
import rice.view.View;

// START: Controller testing - packages
import javax.swing.JFrame;
// END: Controller testing - packages
/**
 *
 * @author Chris
 */
public class Controller extends KeyAdapter implements ActionListener
{
// variable declarations
// -----------------------------------------------------------------------------
       Timer t;
       Model model;
       ArrayList<View> views = new ArrayList<View>();

       InputDecoder inputDecoder;
       SplashScreenState splashScreenState;
       MainScreenState mainScreenState;
       OverviewState overviewState;
       TechnologyState technologyState;
       KeyBindingState keyBindingState;

       int tickCounter = 0;

       // START: Controller testing - variables
       JFrame frame;
       // END: Controller testing - variables

// initialization functions
// -----------------------------------------------------------------------------
       public Controller()
       {
           t = new Timer(1000, this);

	   inputDecoder = new InputDecoder();
	   splashScreenState = new SplashScreenState();
	   mainScreenState = new MainScreenState();
	   overviewState = new OverviewState();
	   technologyState = new TechnologyState();
	   keyBindingState = new KeyBindingState();

	   // when Controller is created, have it tell InputDecoder
	   //  to initialize the HashMap, and InputDecoder will
	   //  tell the HashMap to initialize itself, and it will
	   //  then tell the FileLoader to load the default file

	   // START: Controller testing - registering listenrs with jframe
	   frame = new JFrame( "Controller Test" );
	   frame.addKeyListener(this);
	   frame.setSize(800, 800);
	   frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   //frame.setVisible(true);
	   // END: Controller testing - registering listeners with jframe
       }

       public void start()
       {
           t.start();
       }

       public void registerModel(Model model)
       {
           this.model = model;
       }

       public void registerView(View view)
       {
           views.add(view);
       }

// global commands input processing
// -----------------------------------------------------------------------------
       @Override
       public void keyReleased( KeyEvent e )
       {
	   if( e.getKeyCode() == KeyEvent.VK_DOWN)
	   {
	       System.out.println("You pressed down!");
	   }
       }

// accessor functions
// -----------------------------------------------------------------------------
       int getTickNum()
       {
	   return tickCounter;
       }
// command processing via ControllerState delegation
// -----------------------------------------------------------------------------
       
// action event handling
// -----------------------------------------------------------------------------
       public void actionPerformed(ActionEvent e)
       {
	   ++tickCounter;
           model.tick();
           for(View v: views)
	   {
               v.refresh();
           }
           System.out.println("Tick " + tickCounter);
       }
}
