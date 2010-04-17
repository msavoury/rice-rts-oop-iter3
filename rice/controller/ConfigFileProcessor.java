/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.BufferedWriter;

// START: Testing
import javax.swing.JFrame;
// END: Testing
/**
 *
 * @author Chris
 */
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
    ConfigFileProcessor()
    {
	defaultConfigFilePath = "ConfigFiles/default.txt";

	chooser = new JFileChooser();
	chooser.setCurrentDirectory( new File("./ConfigFiles") );

	//START: testing
	frame = new JFrame( "File Chooser Test" );
	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	//frame.setVisible( true );
	//END: testing
    }

// file loading functions
// -----------------------------------------------------------------------------
    List< KeyboardHashMapPair > loadDefaultConfigFile()
    {
	//call loadConfigFile with the default file name/path as the argument
	File file = new File( defaultConfigFilePath );

	return loadFile( file );
    }

    List< KeyboardHashMapPair > loadConfigFile()
    {
	File file = getFile();
	if( file != null )
	{
	    return loadFile( file );
	}

	return null;
    }

    private File getFile()
    {
	File file = null;

	if( chooser.showOpenDialog( frame ) == JFileChooser.APPROVE_OPTION )
	{
	    file = chooser.getSelectedFile();
	}
	return file;
    }

    private List< KeyboardHashMapPair > loadFile( File file )
    {
	List< KeyboardHashMapPair > keyboardKeysInfo = new ArrayList();

	try
	{
	    scn = new Scanner( file );

	    while( scn.hasNextLine() )
	    {
		String tempString = scn.next();
		Integer tempInteger = new Integer(
			Integer.parseInt( scn.next() ) );

		keyboardKeysInfo.add( new KeyboardHashMapPair( tempString, 
			tempInteger ) );
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
    void saveConfigFile( List< KeyboardHashMapPair > keyboardKeysInfo )
    { //NOTE: A lot of saveConfigFile is currently under testing
	/*File testFile = new File("./ConfigFiles/test.txt");

	try
	{
final FileWriter outputFile = new FileWriter(testFile);
        final BufferedWriter outputBuffer = new BufferedWriter(outputFile);
        final PrintWriter pwriter = new PrintWriter(outputBuffer);
	    //FileWriter txtConfig = new FileWriter( testFile );
	    //pWrite = new PrintWriter( txtConfig );
	    //PrintWriter pwriter = new PrintWriter( testFile );
	    pwriter.print(15);
	    pwriter.write(17);
	}
	catch( Exception e )
	{
	    System.out.println("Exception: failure during " +
		    "config writing process: " + e);
	}*/


    }
}

//figure out how to "exit" a JFrame