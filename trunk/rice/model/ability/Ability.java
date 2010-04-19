package rice.model.ability;

import rice.model.Controllable;

/**
 * This class represents the actions that a Controllable object is capable of performing.
 * Abilities are closely tied with commands but not all abilities have a corresponding
 * command. (i.e. the Clear Queue command)
 * 
 * @private Several commands implement a mini-state machine in order to interpret input correctly
 * @author Marcos
 *
 */
public abstract class Ability {
  String name = "Ability";
  Controllable target;
  /**
   * Ready for commands
   */
  public static final int START = 0;
  /**
   * Currently capturing commands
   */
  public static final int CAPTURING = 1;
  
  int state;
  
  /**
   * Returns whether or not a given string is direction
   * @param direction
   * @return
   */
  static boolean isDirection(String direction) {
	  boolean result = false;
	  if(direction.equals("NORTH")
		||direction.equals("NORTHWEST")
		||direction.equals("NORTHEAST")
		||direction.equals("SOUTHWEST")
		||direction.equals("SOUTHEAST")
		||direction.equals("SOUTH")
		
	  ){
		  result = true;
	  }
	  
	  System.out.println(direction + " direction? " + result);
	  return result;
  }
  
  public abstract String getDefaultName();
	  
  
  public Ability(Controllable c){
	  target = c;
	  this.state = START;
	  this.name = getDefaultName();
  }
  
  void setName(String s){
	this.name = s;  
  }
  public String toString() {
	  return this.name;
  }
  
  public void reset() {
	  this.state = START;
	  this.name = getDefaultName();
  }
  
  public abstract void acceptInput(String input);
	  
  //}
    
}
