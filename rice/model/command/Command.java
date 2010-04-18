package rice.model.command;

import rice.model.Controllable;

public abstract class Command {

	/**
	 * Command is done
	 */
	public static int FINISHED = 0;
	/**
	 * Command is still in progress
	 */
	public static int IN_PROGRESS = 1;
	
	Controllable target;
	
	public Command(Controllable c){
	  this.target = c;	
	}
	
	public abstract int execute();
}
