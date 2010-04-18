package rice.model.command;

import rice.model.Controllable;

public class PowerDown extends Command {

	public PowerDown(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute() {
		target.setPowerStatus(false);
		return FINISHED;
		
	}
  
}
