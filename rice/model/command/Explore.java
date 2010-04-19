package rice.model.command;

import rice.model.Controllable;

public class Explore extends Command {

	public Explore(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
		setName("Explore");
	}

	@Override
	public int execute() {
		/*
		 * get resource
		 * give it to player
		 */
		target.setStatus("Exploring");
		return CONTINUOUS;
	}

}
