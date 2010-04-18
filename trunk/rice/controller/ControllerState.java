/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

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
}
