/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
/**
 *
 * @author Chris
 */
class KeyBindingState extends ControllerState
{
// variable declarations
// -----------------------------------------------------------------------------
    final private String activeID = "KeyBindingState";
    private boolean isActive;
    private List< KeyboardHashMapPair > curKeyConfig = new ArrayList< KeyboardHashMapPair >();
    private int curIndex;


    // everytime the controller map is modified, have it ship an updated
    //  copy of this information to a list in the form of KeyboardHashMapPair
    //  and send it to KeyBindingState
    // once inside of KeyBindingState, you have an index (since you can't
    //  remove commands from the hashmap, you can keep the same index as before)

    private Controller controller;
    private ControllableModel model;
    private InputDecoder inputDecoder;

// initialization functions
// -----------------------------------------------------------------------------
    KeyBindingState( Controller controller, InputDecoder inputDecoder )
    {
	isActive = false;
	this.controller = controller;
	this.inputDecoder = inputDecoder;
	setCurKeyConfig();
	curIndex = 0;
    }

// command processing functions
// -----------------------------------------------------------------------------
    void processCommand( String command )
    {
	//System.out.println("Woohoo! " + activeID);

	if( command.equals( "SWITCH_SCREEN_LEFT" ) )
	{
	   controller.switchScreenLeft();
	}
	else if( command.equals( "SWITCH_SCREEN_RIGHT" ) )
	{
	    controller.switchScreenRight();
	}
	else if( command.equals( "NORTH" ) )
	{
	    // increasing the index
	    if( curIndex == curKeyConfig.size() - 1 )
	    {
		curIndex = 0;
	    }
	    else
	    {
		++curIndex;
	    }

	    int curKey = curKeyConfig.get( curIndex ).getKey();
	    if( curKey - 10000 < 10000 && curKey - 10000 > 0 )  // checking for Ctrl ( if it is, subtract 10000 )
		System.out.println( "Current command: CTRL + " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey() - 10000 ) );
	    else if( curKey - 20000 < 10000 && curKey - 20000 > 0 )  // checking for Alt ( if it is, subtract 20000 )
		System.out.println( "Current command: ALT + " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey() - 20000 ) );
	    else if( curKey - 30000 < 10000 && curKey - 30000 > 0 )  // checking for Shift ( if it is, subtract 30000 )
		System.out.println( "Current command: SHIFT + " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey() - 30000 ) );
	    else
		System.out.println( "Current command: " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey()) );
	}
	else if( command.equals( "SOUTH" ) )
	{
	    // increasing the index
	    if( curIndex == 0 )
	    {
		curIndex = curKeyConfig.size() - 1;
	    }
	    else
	    {
		--curIndex;
	    }

	    int curKey = curKeyConfig.get( curIndex ).getKey();
	    if( curKey - 10000 < 10000 && curKey - 10000 > 0 )  // checking for Ctrl ( if it is, subtract 10000 )
		System.out.println( "Current command: CTRL + " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey() - 10000 ) );
	    else if( curKey - 20000 < 10000 && curKey - 20000 > 0 )  // checking for Alt ( if it is, subtract 20000 )
		System.out.println( "Current command: ALT + " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey() - 20000 ) );
	    else if( curKey - 30000 < 10000 && curKey - 30000 > 0 )  // checking for Shift ( if it is, subtract 30000 )
		System.out.println( "Current command: SHIFT + " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey() - 30000 ) );
	    else
		System.out.println( "Current command: " + curKeyConfig.get( curIndex ).getValue() +"; current key: " + KeyEvent.getKeyText( curKeyConfig.get( curIndex ).getKey()) );
	}
	else if( command.equals( "CONFIRM_SELECTION_NO_ARGS" ) ) //confirming that you want to reassign the currently selected key with another key
	{
	    System.out.println("BAHREACHED! ENTER has been selected. Current key is: " + curKeyConfig.get( curIndex ).getKey() + ", current value is: " + curKeyConfig.get( curIndex ).getValue() );
	    inputDecoder.switchToAssignMode( curKeyConfig.get( curIndex ).getValue() );
	}
	else if( command.equals( "RESET_CONTROL_CONFIG" ) )
	{
	    inputDecoder.loadDefaultConfig();
	    this.setCurKeyConfig();
	}
	else if( command.equals( "LOAD_CUSTOM_CONFIG" ) )
	{
	    inputDecoder.loadCustomFile();
	    this.setCurKeyConfig();
	}
	else if( command.equals( "SAVE_CUSTOM_CONFIG" ) )
	{
	    inputDecoder.saveCustomFile();
	    this.setCurKeyConfig();
	}
    }

    // press enter: confirm to change key. changes inKeyReassignmentMode to true, which also switches inputDecoder to the assignmentMode
    //  when a key is pressed, it is passed into inputDecoder: you should check to see if the current command you are wanting to reassign
    //  has that key used in any other command. If they are, have that command swap its key storage with this one. This way, keys are
    //  just reassigned

    
    // call setCurKeyConfig each time a reassignment is successful
    // have a way to reset controls to default configuration (just call the loadDefaultControlConfig inside of inputDecoder and have that call keyboardHashMap)
    //  just make it recognize another key for this...

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

    void setCurKeyConfig()
    {
	curKeyConfig = inputDecoder.getUpdatedKeyConfig();
    }
    
// class state status functions
// -----------------------------------------------------------------------------
    boolean activated( String activeID )
    {
	if( this.activeID.equals( activeID ) )
	{
	    setCurKeyConfig();
	    return true;
	}
	else
	{
	    return false;
	}
    }
}
