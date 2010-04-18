package rice.model.command;

import rice.model.Controllable;

public class PowerUp extends Command{

	public PowerUp(Controllable c) {
		super(c);
		setName("Power Up");
	}

	@Override
	public int execute() {
		
		target.setPowerStatus(true);
		return FINISHED;
	}

}
