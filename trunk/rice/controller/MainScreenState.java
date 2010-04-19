/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

/**
 *
 * @author Chris
 */
class MainScreenState extends ControllerState
{
// variable declarations
// -----------------------------------------------------------------------------
    final private String activeID = "MainScreenState";
    private boolean isActive;

    private Controller controller;
    private ControllableModel model;

// initialization functions
// -----------------------------------------------------------------------------
    MainScreenState( Controller controller )
    {
	this.controller = controller;
	isActive = false;
    }

// command processing functions
// -----------------------------------------------------------------------------
    void processCommand( String command )
    {
	//System.out.println("Woohoo! " + activeID);

	if( command.equals( "SWITCH_SCREEN_LEFT" ) )
	   controller.switchScreenLeft();
	else if( command.equals( "SWITCH_SCREEN_RIGHT" ) )
	    controller.switchScreenRight();
	else if( command.equals( "CONFIRM_SELECTION_NO_ARGS" ) )
	{
	    model.processCommand( command );
	}
	else if( command.equals( "CYCLE_MODES_UP" ) )
	{
	    model.nextMode();
	}
	else if( command.equals( "CYCLE_MODES_DOWN" ) )
	{
	    model.previousMode();
	}
	else if( command.equals( "CYCLE_TYPES_LEFT" ) )
	{
	    model.previousSubmode();
	}
	else if( command.equals( "CYCLE_TYPES_RIGHT" ) )
	{
	    model.nextSubmode();
	}
	else if( command.equals( "CYCLE_INSTANCES_LEFT" ) )
	{
	    model.previousInstance();
	}
	else if( command.equals( "CYCLE_INSTANCES_RIGHT" ) )
	{
	    model.nextInstance();
	}
	else if( command.equals( "CYCLE_COMMANDS_UP" ) )
	{
	    model.nextAbility();
	}
	else if( command.equals( "CYCLE_COMMANDS_DOWN" ) )
	{
	    model.previousAbility();
	}
	else if( command.equals( "CREATE_RALLY_POINT" ) )
	{
	    model.createRallyPoint();
	}
	else // all other keys end up here: model will be concerned with hotkeys and numpad movement keys (speaking from the default key configuration)
	{
	    model.processCommand( command );
	}
    }

// accessor and mutator functions
// -----------------------------------------------------------------------------
    void setModel( ControllableModel model )
    {
	this.model = model;
    }

    String getActiveID()
    {
	return activeID;
    }

// class state status functions
// -----------------------------------------------------------------------------
    boolean activated( String activeID )
    {
	if( this.activeID.equals( activeID ) )
	    return true;
	else
	    return false;
    }
}


//for move: have it take in CONFIRM_SELECTION
// which will activate boolean moveMode or something
// which can be checked before ANY OTHER commands are
// pressed. Then for the only movements you're concerned
// with, have them in a separate "MoveMovements" command
// that will keep shipping movement information
// to the model until enter is pressed.