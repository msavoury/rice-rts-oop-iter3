/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
/**
 *
 * @author Chris
 */
class InputDecoder extends KeyAdapter implements MouseListener
{
// variable declarations
// -----------------------------------------------------------------------------
    private Controller controller;
    private KeyboardHashMap keyboardHashMap;

    private boolean inAssignmentMode = false;
    private String commandToBeReassigned = "";

// initialization functions
// -----------------------------------------------------------------------------
    InputDecoder( Controller controller )
    {
	this.controller = controller;
	keyboardHashMap = new KeyboardHashMap();
	keyboardHashMap.loadDefaultConfig();
    }

// loading control configuration files
// -----------------------------------------------------------------------------
    void loadDefaultConfig()
    {
	keyboardHashMap.loadDefaultConfig();
    }

    void loadCustomFile()
    {
	keyboardHashMap.loadControlConfig();
    }

// saving control configuration files
// -----------------------------------------------------------------------------
    void saveCustomFile()
    {
	keyboardHashMap.saveControlConfig();
    }

// modifying the current configuration file
// -----------------------------------------------------------------------------
    /*
    acceptInput( int hashMapKey, int modifier )
    {
       
    }
    */

// key assignment mode functions
// -----------------------------------------------------------------------------
    void switchToAssignMode( String command )
    {
	inAssignmentMode = true;
	commandToBeReassigned = command;
    }

    void assignNewKeyToCommand( int keyValue )
    {
	//check to see if any other command has the key that was pressed
	// if it does, then you switch that key to this and this key to that
	// if that key is not used by anyone, you just overwrite the key
	// associated with that command
System.out.println(commandToBeReassigned);
	if( !commandToBeReassigned.equals( "" ) )
	{
	    System.out.println("ABOUT TO REASSIGN KEY: " + keyValue + ", TO COMMAND: " + commandToBeReassigned );
	    keyboardHashMap.assignNewKeyConfig( keyValue, commandToBeReassigned );
	}

	controller.updateKeyBindingState();
	inAssignmentMode = false;
	commandToBeReassigned = "";
    }

// retrieve current key configuration
// -----------------------------------------------------------------------------
    List< KeyboardHashMapPair > getUpdatedKeyConfig()
    {
	return keyboardHashMap.getUpdatedKeyConfig();
    }

// keyboard input event handlers
// -----------------------------------------------------------------------------
   @Override
   public void keyPressed( KeyEvent e )
   {
       // keyPressedModifier indicates whether or not a modifier key
       //  (Ctrl, Alt, or Shift) has been pressed. If one of the
       //  modifier keys is pressed, keyPressedModifier receives
       //  a value to indicate what key has been pressed. This allows,
       //  for example, a VK_UP key to be stored twice in keyboardHashMap
       //  where a CTRL + UP key combination would be entered into
       //  keyboardHashMap as VK_UP + 10000 and just the UP key being stored
       //  as VK_UP.
       int keyPressedModifier = 0;

       if( e.isControlDown() )
	   keyPressedModifier += 10000;
       else if( e.isAltDown() )
	   keyPressedModifier += 20000;
       else if( e.isShiftDown() )
	   keyPressedModifier += 30000;

       String command = keyboardHashMap.getKeyInfo( e.getKeyCode() +
						   keyPressedModifier );
       if( !inAssignmentMode )
       {
	   if( command != null )
	   {
	       controller.processCommand( command );
	   }
       }
       else if( inAssignmentMode )
       {
	   assignNewKeyToCommand( e.getKeyCode() + keyPressedModifier );
       }
   }

// mouse input event handlers
// -----------------------------------------------------------------------------
    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {

    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }
}
