/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

/**
 *
 * @author Chris
 */

// this class is used to help ease transportation of KeyboardHashMap data
//  by keeping them together
class KeyboardHashMapPair
{
// variable declarations
// -----------------------------------------------------------------------------
    private String value;
    private int key;

// initialization functions
// -----------------------------------------------------------------------------

    // constructor
    KeyboardHashMapPair( Integer key, String value )
    {
	this.key = key;
	this.value = value;
    }

// accessors and mutators
// -----------------------------------------------------------------------------

    // returns a String that will serve as a key to the KeyboardHashMap
    Integer getKey()
    {
	return key;
    }

    // returns an Integer that will serve as the value to the KeyboardHashMap
    String getValue()
    {
	return value;
    }
}
