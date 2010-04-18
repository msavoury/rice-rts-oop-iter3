package rice.model.command;

import rice.model.Controllable;

public abstract class Command {

	private String name = "Default Command";
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
	
	public void setName(String s){
      this.name = s;
	}
	
	public abstract int execute();
	
	public String toString() {
		return this.name;
	}
}
