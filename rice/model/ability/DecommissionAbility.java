package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.Decommission;


public class DecommissionAbility extends Ability {

	
	public DecommissionAbility(Controllable c) {
		super(c);
		setName("Decommission");
	}

	@Override
	public void acceptInput(String input) {
	  if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
		    target.addCommand(new Decommission(target));
	  }
	}

}
