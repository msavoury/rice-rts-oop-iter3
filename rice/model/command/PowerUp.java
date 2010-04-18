package rice.model.command;

import rice.model.Controllable;

public class PowerUp extends Command{

	public PowerUp(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute() {
		
		target.setPowerStatus(true);
		return FINISHED;
	}

}
