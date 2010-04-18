package rice.model.command;

import rice.model.Controllable;

/**
 * Commands are the actual things that are performed by controllables.  Commands
 * are closely tied to Abilities.  Commands return a value from their execute method,
 * FINISHED, IN_PROGRESS, or CONTINUOUS
 * @author Marcos
 *
 */
public abstract class Command {

	private String name = "Default Command";
	
	/**
	 * Command is done
	 */
	public static final int FINISHED = 0;
	/**
	 *  Command is still in progress
	 */
	public static final int IN_PROGRESS = 1;
	
	/**
	 * Command is a type that will continue as long as there is not another command in the queue 
	 */
	public static final int CONTINUOUS = 2;
	
	Controllable target;
	
	public Command(Controllable c){
	  this.target = c;	
	}
	
	public void setName(String s){
      this.name = s;
	}
	
	public abstract int execute();
	
	public String toString() {
		return this.name;
	}
}
