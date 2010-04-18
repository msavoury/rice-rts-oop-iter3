/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

/**
 *
 * @author Chris
 */
class SplashScreenState extends ControllerState
{
// variable declarations
// -----------------------------------------------------------------------------
    final private String activeID = "SplashScreenState";
    private boolean isActive;

    Controller controller;

// initialization functions
// -----------------------------------------------------------------------------
    SplashScreenState( Controller controller )
    {
	this.controller = controller;
	isActive = false;
    }

// command processing functions
// -----------------------------------------------------------------------------
    void processCommand( String command )
    {
	
     if( command.equals( "CONFIRM_SELECTION_NO_ARGS" ) )
	{
	    controller.activateDefaultScreenState();
	}
    }

// accessor and mutator functions
// -----------------------------------------------------------------------------
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
