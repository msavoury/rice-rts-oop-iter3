package rice.model.command;

import rice.model.Controllable;

public class Wait extends Command {

	private int counter = 5;
	
	public Wait(Controllable c) {
		super(c);
		setName("Wait");
	}

	@Override
	public int execute() {
		counter--;
		if(counter != 0)
			return IN_PROGRESS;
		else
		 	return FINISHED;
	}

}
