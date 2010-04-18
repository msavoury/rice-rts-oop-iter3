/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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
    void loadDefaultFile()
    {

    }

    void loadCustomFile()
    {
	// will need a JDialogueChooser
    }

// saving control configuration files
// -----------------------------------------------------------------------------
    void saveCustomFile()
    {

    }

// modifying the current configuration file
// -----------------------------------------------------------------------------
    /*
    acceptInput( int hashMapKey, int modifier )
    {
       
    }
    */

// toggling key assignment mode
// -----------------------------------------------------------------------------
    void switchToAssignMode( String command )
    {

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
	   System.out.println( keyPressedModifier );
	   String command = keyboardHashMap.getKeyInfo( e.getKeyCode() +
						       keyPressedModifier );
	   if( command != null )
	   {
	       controller.processCommand( command );
	   }
	   System.out.println( command );
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
