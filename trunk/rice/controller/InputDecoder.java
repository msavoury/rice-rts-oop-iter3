/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
/**
 *
 * @author Chris
 */
class InputDecoder extends KeyAdapter implements MouseListener
{
// variable declarations
// -----------------------------------------------------------------------------
    KeyboardHashMap keyboardHashMap;

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
