/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import rice.model.Model;
import rice.view.ControllableView;

/**
 *
 * @author Chris
 */
public class Controller extends KeyAdapter implements ActionListener
{
// variable declarations
// -----------------------------------------------------------------------------
       Timer t;
       ControllableModel model;
       ArrayList<ControllableView> views = new ArrayList<ControllableView>();

       InputDecoder inputDecoder;
       SplashScreenState splashScreenState;
       MainScreenState mainScreenState;
       UnitOverviewState unitOverviewState;
       StructureOverviewState structureOverviewState;
       TechnologyState technologyState;
       KeyBindingState keyBindingState;

       int tickCounter = 0;
       boolean pauseToggle = false;

       // indicates the current ControllerState that is considered active
       ControllerState curState;

       // stateIDs are the Strings associated with their respective
       //  controllerStates. When used, they are passed into the
       //  states ArrayList to activate whatever state matches
       //  the currently selected stateID. This is done so that
       //  only states that are to be "switched" between can be
       //  switched to, while all states can be stored inside of
       //  the ArrayList named "states"
       List< String > stateIDs;

       // states are used so that whenever the program is trying to switch
       //  states it passes the current stateID to all ControllerStates in this
       //  ArrayList named "states". Whichever state returns that it matches
       //  that stateID becomes the curState
       List< ControllerState > states;

       // statesIndex keeps track of the currently selected stateID inside of
       //  stateIDs.
       int statesIndex = 0;

// initialization functions
// -----------------------------------------------------------------------------
       public Controller()
       {
           t = new Timer(1000, this);
	   inputDecoder = new InputDecoder( this );
	   splashScreenState = new SplashScreenState( this );
	   mainScreenState = new MainScreenState( this );
	   unitOverviewState = new UnitOverviewState( this );
	   structureOverviewState = new StructureOverviewState( this );
	   technologyState = new TechnologyState( this );
	   keyBindingState = new KeyBindingState( this, inputDecoder );
	   curState = splashScreenState;

	   // adding all available states to the ArrayList named "states"
	   states = new ArrayList();
	   states.add( splashScreenState );
	   states.add( mainScreenState );
	   states.add( unitOverviewState );
	   states.add( structureOverviewState );
	   states.add( technologyState );
	   states.add( keyBindingState );

	   //adding all available stateIDs to the ArrayList named "stateIDs"
	   stateIDs = new ArrayList();
	   stateIDs.add( mainScreenState.getActiveID() );
	   stateIDs.add( unitOverviewState.getActiveID() );
	   stateIDs.add( structureOverviewState.getActiveID() );
	   stateIDs.add( technologyState.getActiveID() );
	   stateIDs.add( keyBindingState.getActiveID() );

	   // creating an index for the ArrayList named "stateIDs" to keep
	   // track of the currently selected stateID
	   statesIndex = 0;
       }

       public void start()
       {
	   t.start();
       }

       public void registerModel(Model model)
       {
           this.model = model;

	   for( int i = 0; i < states.size(); ++i )
	   {
	       states.get( i ).setModel( model );
	   }
       }

       public void registerView(ControllableView view)
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

	   curState.processCommand( command );

	   views.get(0).refresh();
       }

       void switchScreenLeft()
       {
	   if ( statesIndex == 0 )
	       statesIndex = stateIDs.size() - 1;
	   else
	       --statesIndex;

	   for( int i = 0; i < states.size(); ++i )
	   {
	       if( states.get( i ).activated(
		       stateIDs.get( statesIndex ) ) )
		   curState = states.get( i );
	   }

	   tellViewToSwitchScreen();
       }

       void switchScreenRight()
       {
	   if ( statesIndex == stateIDs.size() - 1 )
	       statesIndex = 0;
	   else
	       ++statesIndex;

	   for( int i = 0; i < states.size(); ++i )
	   {
	       if( states.get( i ).activated(
		       stateIDs.get( statesIndex ) ) )
		   curState = states.get( i );
	   }

	   tellViewToSwitchScreen();
       }

       void activateInitialGameplayState()
       {
	   curState = mainScreenState;
           tellViewToSwitchScreen();
       }

       private void tellViewToSwitchScreen()
       {
	   views.get(0).switchMode( stateIDs.get( statesIndex ) );
	   views.get(0).refresh();
       }
       
// accessor and mutator functions
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
           //long time = System.currentTimeMillis();
	   ++tickCounter;
           model.tick( getTickNum() );
           for(ControllableView v: views)
	   {
               v.refresh();
           }
           System.out.println("Tick " + tickCounter);
       }
}
