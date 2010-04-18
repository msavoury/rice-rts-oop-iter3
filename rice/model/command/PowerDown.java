package rice.model.command;

import rice.model.Controllable;

public class PowerDown extends Command {

	public PowerDown(Controllable c) {
		super(c);
		setName("Power Down");
	}

	@Override
	public int execute() {
		target.setPowerStatus(false);
		return FINISHED;
		
	}
  
}
