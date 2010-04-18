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
       boolean pauseToggle = false;

// initialization functions
// -----------------------------------------------------------------------------
       public Controller()
       {
           t = new Timer(1000, this);
	   inputDecoder = new InputDecoder( this );
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
       void processGlobalCommand( String command )
       {
	   if( command.equals( "PAUSE" ) )
	   {
	       if( !pauseToggle )
	       {
		   t.stop();
		   pauseToggle = true;
	       }
	       else
	       {
		   t.start();
		   pauseToggle = false;
	       }
	   }
	   else if( command.equals( "QUIT") )
	   {
	       System.exit(0);
	   }
	   else if( command.equals( "INCREASE_CLOCK_RATE" ) )
	   {
	       int clockIncrease = 500;
	       setClockRate( clockIncrease );
	   }
	   else if( command.equals( "DECREASE_CLOCK_RATE" ) )
	   {
	       int clockDecrease = -500;
	       setClockRate( clockDecrease );
	   }
       }
       
// command processing via ControllerState delegation
// -----------------------------------------------------------------------------
       void processCommand( String command )
       {
	   processGlobalCommand( command );

       }
// accessor functions
// -----------------------------------------------------------------------------
       private int getTickNum()
       {
	   return tickCounter;
       }

       private void setClockRate( int delayModifier )
       {
	   int curDelay = t.getDelay();
	   if( curDelay + delayModifier >= 1000 &&
		   curDelay + delayModifier <= 5000)
	   {
	       t.setDelay( curDelay + delayModifier);
	   }
       }

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
