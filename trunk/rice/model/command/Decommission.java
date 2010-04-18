package rice.model.command;

import rice.model.Controllable;

public class Decommission extends Command {

	public Decommission(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute() {
		target.destroy();
		return FINISHED;
	}

}
