/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris
 */
class ConfigFileProcessor
{
/* NOTE: I have created a duplicate of this class before I needed to make a
 * modification. The modification (the non-commented code) was made so that
 * we could eschew the need for pop-up dialogue boxes to save and load
 * from a config file since we wanted to have fullscreen support. We had
 * feasible ideas for how to handle this without dialogue boxes, but without
 * time for researching, implementation, and testing, we decided to go
 * with this approach. In uncommented code, we only have 1 custom config
 * file that the user can save to and load from. The saving and loading
 * still works the same, but only for one file now; the ability to save and
 * load to multiple files is in the commented code.
 */

// variable declarations
// -----------------------------------------------------------------------------
    private String defaultConfigFilePath;
    private JFileChooser chooser;

// initialization functions
// -----------------------------------------------------------------------------
    
    // constructor
    ConfigFileProcessor()
    {
	//chooser.setCurrentDirectory( new File("./rice/ConfigFiles") );
    }

// file loading functions
// -----------------------------------------------------------------------------

    // calls the getFile method so that the user can specify which config file
    //  he or she wants to load and passes the user selection into the loadFile
    //  method for loading
    List< KeyboardHashMapPair > loadConfigFile()
    {
	File file = getFile();
	if( file != null )
	{
	    return loadFile( file );
	}

	return null;
    }

    // loads a JFileChooser for the user to select the config file he or she
    //  wants the game to be using
    //  - getFile() invariant: loaded files must have a .txt
    //                          extension or be null.
    private File getFile()
    {
	File file = new File("." +
		"/rice/ConfigFiles/custom.txt");
	    
	    if( !file.getName().equals( "custom.txt") )
	    {
		file = null;
		System.out.println( "File Loading Error: did not load the correct configuration file" );
	    }
	    
	return file;
    }

    // loads the file passed via the method argument and stores
    //  its contents into a KeyboardHashMapPair list so that
    //  the KeyboardHashMap can store the control configuration
    //  information
    private List< KeyboardHashMapPair > loadFile( File file )
    {
	List< KeyboardHashMapPair > keyboardKeysInfo = new ArrayList();
	Scanner scn;
	
	try
	{
	    scn = new Scanner( file );

	    while( scn.hasNext() )
	    {
		    Integer tempInteger = new Integer(
			    Integer.parseInt( scn.next() ) );
		    String tempString = scn.next();

		    keyboardKeysInfo.add( new KeyboardHashMapPair( tempInteger,
			    tempString ) );
	    }

	    scn.close();
	}
	catch( FileNotFoundException e )
	{
	    System.out.println("Exception: config file loading failure: " + e);
	}

	return keyboardKeysInfo;
    }

// file saving functions
// -----------------------------------------------------------------------------

    // saves the current controller configuration to a text file at
    //  rice/ConfigFiles/fileName.txt .
    void saveConfigFile( List< KeyboardHashMapPair > keyboardKeysInfo )
    {
	File file = new File("rice/ConfigFiles/custom.txt");

	try
	{
	    PrintWriter pWriter = new PrintWriter( file );

	    for( int i = 0; i < keyboardKeysInfo.size(); ++i )
	    {
		pWriter.print( keyboardKeysInfo.get( i ).getKey() + " ");
		pWriter.println( keyboardKeysInfo.get( i ).getValue() );
	    }

	    pWriter.close();
	}
	catch( Exception e )
	{
	    System.out.println( "Exception: error while saving custom control configuration file - " + e );
	}
    }
}

// Old Code: See top of file in the Note for further information.
// -----------------------------------------------------------------------------
/*
package rice.controller;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

// START: Testing
import javax.swing.JFrame;
// END: Testing
/**
 *
 * @author Chris
 */
/*
class ConfigFileProcessor
{
// variable declarations
// -----------------------------------------------------------------------------
    private Scanner scn;
    private PrintWriter pWrite;

    private String defaultConfigFilePath;
    private JFileChooser chooser;

    //START: testing
    JFrame frame;
    //END: testing

// initialization functions
// -----------------------------------------------------------------------------

    // constructor
    ConfigFileProcessor()
    {
	chooser = new JFileChooser();
	chooser.setCurrentDirectory( new File("./rice/ConfigFiles") );

	//START: testing
	frame = new JFrame( "File Chooser Test" );
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	//frame.setVisible( true );
	//END: testing
    }

// file loading functions
// -----------------------------------------------------------------------------

    // calls the getFile method so that the user can specify which config file
    //  he or she wants to load and passes the user selection into the loadFile
    //  method for loading
    List< KeyboardHashMapPair > loadConfigFile()
    {
	File file = getFile();
	if( file != null )
	{
	    return loadFile( file );
	}

	return null;
    }

    // loads a JFileChooser for the user to select the config file he or she
    //  wants the game to be using
    //  - getFile() invariant: loaded files must have a .txt
    //                          extension or be null.
    private File getFile()
    {
	File file = null;

	if( chooser.showOpenDialog( frame ) == JFileChooser.APPROVE_OPTION )
	{
	    //making sure the file is a txt file
	    Scanner scn = new Scanner( file.getName() ).useDelimiter(".");
	    scn.next();
	    String extension = scn.next();

	    if( extension.equals( "txt") )
		file = chooser.getSelectedFile();
	    else
	    {
		file = null;
		System.out.println( "File Loading Error: tried " +
			"to load a file that is not a .txt file.");
	    }
	}
	return file;
    }

    // loads the file passed via the method argument and stores
    //  its contents into a KeyboardHashMapPair list so that
    //  the KeyboardHashMap can store the control configuration
    //  information
    private List< KeyboardHashMapPair > loadFile( File file )
    {
	List< KeyboardHashMapPair > keyboardKeysInfo = new ArrayList();

	try
	{
	    scn = new Scanner( file );

	    while( scn.hasNext() )
	    {
		    Integer tempInteger = new Integer(
			    Integer.parseInt( scn.next() ) );
		    String tempString = scn.next();

		    keyboardKeysInfo.add( new KeyboardHashMapPair( tempInteger,
			    tempString ) );
	    }

	    scn.close();
	}
	catch( FileNotFoundException e )
	{
	    System.out.println("Exception: config file loading failure: " + e);
	}

	return keyboardKeysInfo;
    }

// file saving functions
// -----------------------------------------------------------------------------

    // saves the current controller configuration to a text file at
    //  rice/ConfigFiles/fileName.txt .
    void saveConfigFile( List< KeyboardHashMapPair > keyboardKeysInfo )
    {
	// dialogue box that requests user to enter a title for their
	//  current control configuration
	String fileName = JOptionPane.showInputDialog("Enter a name for this " +
		"custom control configuration file:");

	File file = new File("rice/ConfigFiles/" + fileName + ".txt");

	try
	{
	    PrintWriter pWriter = new PrintWriter( file );

	    for( int i = 0; i < keyboardKeysInfo.size(); ++i )
	    {
		pWriter.print( keyboardKeysInfo.get( i ).getKey() + " ");
		pWriter.println( keyboardKeysInfo.get( i ).getValue() );
	    }

	    pWriter.close();
	}
	catch( Exception e ){}
    }
}
*/
