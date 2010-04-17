/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.util.HashMap;
import java.io.File;
import java.util.List;

/**
 *
 * @author Chris
 */
class KeyboardHashMap
{
// variable declarations
// -----------------------------------------------------------------------------
    HashMap< String, Integer > keyboardHashMap;
    ConfigFileProcessor configFileProcessor;

// initialization functions
// -----------------------------------------------------------------------------
    
    // constructor
    KeyboardHashMap()
    {
	keyboardHashMap = new HashMap< String, Integer >();
	configFileProcessor = new ConfigFileProcessor();
    }

// accessors and mutators
// -----------------------------------------------------------------------------

    // puts keyboard key information inside of keyboardHashMap
    void putKeyInfo( String commandName, int keyboardKeyValue )
    {
	keyboardHashMap.put( commandName, new Integer( keyboardKeyValue ) );
    }

    // gets the value from the corresponding key from keyboardHashMap
    int getKeyInfo( String commandName )
    {
	int keyboardKeyValue = keyboardHashMap.get( commandName ).intValue();
	return keyboardKeyValue;
    }

    // loads the default control configuration
    void loadDefaultConfig()
    {
	List< KeyboardHashMapPair > keyboardKeysInfo =
		configFileProcessor.loadDefaultConfigFile();

	if( keyboardKeysInfo != null )
	{
	    for( int i = 0; i < keyboardKeysInfo.size(); ++i )
	    {
		putKeyInfo( keyboardKeysInfo.get( i ).getKey(),
			    keyboardKeysInfo.get( i ).getValue() );
	    }


	    // NOTE: TESTING BEGINS
	   /* System.out.println( getKeyInfo( "DOWN_KEY" ) );

	    keyboardKeysInfo = configFileProcessor.loadConfigFile();

	    putKeyInfo( keyboardKeysInfo.get(0).getKey(),
		    keyboardKeysInfo.get(0).getValue());
		System.out.println( getKeyInfo( "WHOA" ) );
		configFileProcessor.saveConfigFile( keyboardKeysInfo);*/
	// NOTE: TESTING ENDS

	}
    }

    // loads a control configuration from a file
    void loadControlConfig( File file )
    {
	// pass this to File Handler; have it call puts on
	// have the file handler return a list of all
	// variables and then HashMap can concern itself with how to arrange
	// them
    }

    // saves the current control configuration to a file
    void saveControlConfig( File file )
    {
	// put all of the contents of this hashmap in a pair<String, Integer>
	// and ship them to the File Handler to save all the info
    }
}
