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
    private KeyboardHashMap keyboardHashMap;

// initialization functions
// -----------------------------------------------------------------------------
    InputDecoder()
    {
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
	   if( e.isControlDown() )
	   {
	       if( e.getKeyCode() == KeyEvent.VK_UP )
	       {
		   String command = keyboardHashMap.getKeyInfo( e.getKeyCode() );
		   //String command = keyboardHashMap.getKeyInfo( e.getKeyCode() );
		   //TEST TO SEE WHAT HAPPENS WHEN YOU PASS OSMETHING INTO THE HASHMAP THAT DOESN'T EXIST THERE (like pass in keycode -3535 or something)
		   System.out.println( "You just cycled modes up and got this command blarh blarghs: " + command );
	       }
	       if( e.getKeyCode() == KeyEvent.VK_DOWN )
	       {
		   String command = keyboardHashMap.getKeyInfo( e.getKeyCode() );
		   //String command = keyboardHashMap.getKeyInfo( e.getKeyCode() );
		   //TEST TO SEE WHAT HAPPENS WHEN YOU PASS OSMETHING INTO THE HASHMAP THAT DOESN'T EXIST THERE (like pass in keycode -3535 or something)
		   System.out.println( "You just cycled modes up and got this command: " + command );
	       }
	   }
	   else if( e.isAltDown() )
	   {

	   }
	   else if( e.isShiftDown() )
	   {

	   }
	   else
	   {

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
