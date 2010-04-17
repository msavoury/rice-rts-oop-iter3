/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

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
    private String key;
    private int value;

// initialization functions
// -----------------------------------------------------------------------------

    // constructor
    KeyboardHashMapPair( String key, Integer value )
    {
	this.key = key;
	this.value = value;
    }

// accessors and mutators
// -----------------------------------------------------------------------------

    // returns a String that will serve as a key to the KeyboardHashMap
    String getKey()
    {
	return key;
    }

    // returns an Integer that will serve as the value to the KeyboardHashMap
    Integer getValue()
    {
	return value;
    }
}
