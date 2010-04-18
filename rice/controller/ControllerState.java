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
abstract class ControllerState
{
// variable declarations
// -----------------------------------------------------------------------------
    
// command processing functions
// -----------------------------------------------------------------------------
    abstract void processCommand( String command );

// class state status functions
// -----------------------------------------------------------------------------
    abstract boolean activated( String activeID );

// accessor and mutator functions
// -----------------------------------------------------------------------------
    abstract void setModel( ControllableModel model );
}
