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
	   view.addKeyListener( inputDecoder );
       }

// global commands input processing
// -----------------------------------------------------------------------------


// accessor functions
// -----------------------------------------------------------------------------
       private int getTickNum()
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
           model.tick( getTickNum() );
           for(View v: views)
	   {
               v.refresh();
           }
           System.out.println("Tick " + tickCounter);
       }
}
