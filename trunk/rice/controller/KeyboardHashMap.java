/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.util.HashMap;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author Chris
 */
class KeyboardHashMap
{
// variable declarations
// -----------------------------------------------------------------------------
    HashMap< Integer, String > keyboardHashMap;
    ConfigFileProcessor configFileProcessor;

// initialization functions
// -----------------------------------------------------------------------------
    
    // constructor
    KeyboardHashMap()
    {
	keyboardHashMap = new HashMap< Integer, String >();
	configFileProcessor = new ConfigFileProcessor();
    }

// accessors and mutators
// -----------------------------------------------------------------------------

    // puts keyboard key information inside of keyboardHashMap
    void putKeyInfo( int keyboardKeyValue, String commandName )
    {
	keyboardHashMap.put( new Integer( keyboardKeyValue ), commandName );
    }

    // gets the value from the corresponding key from keyboardHash
    //  into keyboardKeyValueMap
    String getKeyInfo( int keyboardKeyValue )
    {
	String commandName = keyboardHashMap.get(
		      new Integer( keyboardKeyValue ) );
	return commandName;
    }

// control information (keyboardHashMap data) loading functions
// -----------------------------------------------------------------------------

    // loads the default control configuration
    void loadDefaultConfig()
    {
	List < KeyboardHashMapPair > keyboardKeysInfo;
	DefaultKeyConfiguration defaultKeyConfig = new
				DefaultKeyConfiguration();

	keyboardKeysInfo = defaultKeyConfig.getDefaultConfig();

	for( int i = 0; i < keyboardKeysInfo.size(); ++i )
	{
	    putKeyInfo( keyboardKeysInfo.get( i ).getKey(),
			  keyboardKeysInfo.get( i ).getValue() );
	}

	/*
	List< KeyboardHashMapPair > keyboardKeysInfo =
		configFileProcessor.loadDefaultConfigFile();

	if( keyboardKeysInfo != null )
	{
	    for( int i = 0; i < keyboardKeysInfo.size(); ++i )
	    {
		putKeyInfo( keyboardKeysInfo.get( i ).getKey(),
			    keyboardKeysInfo.get( i ).getValue() );
	    }
	*/

/*
	    // NOTE: TESTING BEGINS
	    String tempKey = keyboardKeysInfo.get( 0 ).getKey();
	    int tempValue = keyboardKeysInfo.get( 0 ).getValue();
	    System.out.println( getKeyInfo( "DOWN_KEY" ) );

	    

	    putKeyInfo( keyboardKeysInfo.get(0).getKey(),
		    keyboardKeysInfo.get(0).getValue());
	    putKeyInfo( "garunkleAndSpunkle!", 55 );
	    System.out.println("TEST: " + getKeyInfo("garunkleAndSpunkle!"));
	    System.out.println("TEST: " + getKeyInfo("DOWN_KEY"));
	    //keyboardKeysInfo = configFileProcessor.loadConfigFile();

		//System.out.println( getKeyInfo( "WHOA" ) );
		this.saveControlConfig();
	// NOTE: TESTING ENDS
*/
    }

    // loads a control configuration from a file by requesting the
    //  configFileProcessor to load a control configuration file
    //  that the user will choose while inside of configFileProcessor.
    //  The configFileProcessor returns the loaded keyboardKeysInfo
    //  it creates from the control configuration file it loaded
    //  and this KeyboardHashMap puts that information ino its HashMap,
    //  and thus setting a new control configuration
    void loadControlConfig()
    {
	List< KeyboardHashMapPair > keyboardKeysInfo =
		    configFileProcessor.loadConfigFile();
	
	if( keyboardKeysInfo != null )
	{
	    
	}
	else
	{
	    System.out.println("Error Loading File: " +
		    "unusable file specified for loading.");
	}
    }

    List< KeyboardHashMapPair > getUpdatedKeyConfig()
    {
	return packCurKeyConfig();
    }

    List< KeyboardHashMapPair > packCurKeyConfig()
    {
	List< KeyboardHashMapPair > keyboardKeysInfo = new ArrayList();

	Set< Integer > keysToCopy = keyboardHashMap.keySet();
	Iterator< Integer > iter = keysToCopy.iterator();

	while( iter.hasNext() )
	{
	    Integer curKey = iter.next();
	    String curValue = this.getKeyInfo( curKey.intValue() );
	    keyboardKeysInfo.add( new KeyboardHashMapPair( curKey, curValue ) );

	}
	return keyboardKeysInfo;
    }

    void assignNewKeyConfig( int keyValue, String commandName )
    {
	List< KeyboardHashMapPair > curKeyConfig = packCurKeyConfig();

	// if keyboardHashMap.get( keyValue ) != null, then that key is stored
	//  in the map with a command and must be addressed
	if( keyboardHashMap.get( keyValue ) != null && !keyboardHashMap.get( keyValue ).equals(commandName) )
	{
	    // if: checking to see if keyboardHashMap is currently using the passed in keyValue
	    if( keyboardHashMap.get( keyValue ) != null )
	    {
		String tempCommandName = keyboardHashMap.get( keyValue );

		for( int i = 0; i < curKeyConfig.size(); ++i )
		{
		    if( curKeyConfig.get( i ).getValue().equals( "commandName" ) )
		    {
			keyboardHashMap.put( curKeyConfig.get( i ).getKey(), tempCommandName );
			break;
		    }
		}

		keyboardHashMap.put( keyValue, commandName );
	    }
	    else // keyboardHashMap is not using keyValue anywhere
	    {
		for( int i = 0; i < curKeyConfig.size(); ++i )
		{
		    if( curKeyConfig.get( i ).getValue().equals( "commandName") )
		    {
			keyboardHashMap.remove( curKeyConfig.get( i ).getKey() );
			keyboardHashMap.put( keyValue, commandName);
			break;
		    }
		}
	    }
	}

	// I want to assign this keyValue to this commandName
	//  if the hashmap returns a command by passing in keyValue
	//  that means a command is already assigned to it.
	//  get that command, give it the keyvalue that the passed
	//  in commandname is currently assigned to inside of keyboardHashMap, then give the keyvalue passed in
	//  to the passed in commandname.
	// if that keyValue has not been used,
	//  add in the current command name with the passed in keyValue

	// remove the pair from the map then add in the current
	// command name
	//  be careful of the case where the user enters the same key
	//  as is already assigned to the commandName3


    }

// control information saving functions
// -----------------------------------------------------------------------------

    // saves the current control configuration to a file
    void saveControlConfig()
    {
	List< KeyboardHashMapPair > keyboardKeysInfo = new ArrayList< KeyboardHashMapPair >();

	keyboardKeysInfo = packCurKeyConfig();

	configFileProcessor.saveConfigFile( keyboardKeysInfo );
    }
}

/**
 *
 * @author Chris
 */

// DefaultKeyConfiguration defines the default control scheme for
//  mapping commands to specific keyboard key values.
class DefaultKeyConfiguration
{
// variable declarations
// -----------------------------------------------------------------------------
    private List< KeyboardHashMapPair > defaultConfig = new ArrayList();

    List< KeyboardHashMapPair > getDefaultConfig()
    {
	// creating the default control configurations
	// - NOTE: Using a hack-around proecdure where CTRL key adds 10000 to
	//         key values. This way, when decoding values, if CTRL is pressed,
	//         10000 is added to a KeyEvent.KEYNAME value. The same goes for
	//         the alt key (20000 is added), and shift (30000 is added).

	// CTRL key must be pressed for the following commands to work
	//  (i.e. 10000 must be added in addition to the keyboard key value)
	defaultConfig.add( new KeyboardHashMapPair( 
		KeyEvent.VK_UP + 10000, "CYCLE_MODES_UP" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_DOWN + 10000, "CYCLE_MODES_DOWN" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_LEFT + 10000, "CYCLE_TYPES_LEFT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_RIGHT + 10000, "CYCLE_TYPES_RIGHT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_EQUALS + 10000, "INCREASE_CLOCK_RATE" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_MINUS + 10000, "DECREASE_CLOCK_RATE" ) );

	// ALT key must be pressed for the following commands to work
	//  (i.e. 20000 must be added in addition to the keyboard key value)
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_Q + 20000, "QUIT" ) );

	// no key is required to be pressed for the following commands to work
	// (i.e. nothing needs to be added to the keybaord key value )
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_LEFT, "CYCLE_INSTANCES_LEFT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_RIGHT, "CYCLE_INSTANCES_RIGHT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_UP, "CYCLE_COMMANDS_UP" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_DOWN, "CYCLE_COMMANDS_DOWN" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_ENTER, "CONFIRM_SELECTION_NO_ARGS" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD5, "CONFIRM_SELECTION" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD7, "NORTHWEST" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD8, "NORTH" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD9, "NORTHEAST" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD1, "SOUTHWEST" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD2, "SOUTH" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD3, "SOUTHEAST" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_PAUSE, "PAUSE" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_EQUALS, "ZOOM_IN" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_MINUS, "ZOOM_OUT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_PAGE_UP, "SWITCH_SCREEN_LEFT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_PAGE_DOWN, "SWITCH_SCREEN_RIGHT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_R, "CREATE_RALLY_POINT" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_1, "HOTKEY_1" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_2, "HOTKEY_2" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_3, "HOTKEY_3" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_4, "HOTKEY_4" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_5, "HOTKEY_5" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_6, "HOTKEY_6" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_7, "HOTKEY_7" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_8, "HOTKEY_8" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_9, "HOTKEY_9" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_0, "HOTKEY_0" ) );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD4, "WEST") );
	defaultConfig.add( new KeyboardHashMapPair(
		KeyEvent.VK_NUMPAD6, "EAST") );

	return defaultConfig;
    }
}
