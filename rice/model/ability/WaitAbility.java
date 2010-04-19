package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.Wait;

public class WaitAbility extends Ability {

	public WaitAbility(Controllable c) {
		super(c);
		//setName("Wait");
	}

	@Override
	public void acceptInput(String input) {
		if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
		    target.addCommand(new Wait(target));
		 }
	}
	
	public String getDefaultName() {
		return "Wait";
	}

}
