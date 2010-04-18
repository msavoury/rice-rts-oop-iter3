package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.Decommission;

public class ClearQueueAbility extends Ability{

	
	public ClearQueueAbility(Controllable c) {
		super(c);
		setName("Clear Queue");
	}

	@Override
	public void acceptInput(String input) {
		if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
		    target.clearQueue();
	  }
	}

}
