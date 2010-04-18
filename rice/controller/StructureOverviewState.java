/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import rice.model.Model;
/**
 *
 * @author Chris
 */
class StructureOverviewState extends ControllerState
{
// variable declarations
// -----------------------------------------------------------------------------
    final private String activeID = "StructureOverviewState";
    private boolean isActive;

    Controller controller;
    Model model;

// initialization functions
// -----------------------------------------------------------------------------
    StructureOverviewState( Controller controller )
    {
	this.controller = controller;
	isActive = false;
    }

// command processing functions
// -----------------------------------------------------------------------------
    void processCommand( String command )
    {
	System.out.println("Woohoo! " + activeID);

	if( command.equals( "SWITCH_SCREEN_LEFT" ) )
	   controller.switchScreenLeft();
	else if( command.equals( "SWITCH_SCREEN_RIGHT" ) )
	    controller.switchScreenRight();
    }

// accessor and mutator functions
// -----------------------------------------------------------------------------
    void setModel( Model model )
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
