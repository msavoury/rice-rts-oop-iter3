package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.FoundCapital;
import rice.model.unit.Colonist;

public class FoundCapitalAbility extends Ability{

	public FoundCapitalAbility(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptInput(String input) {
		if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
			  target.addCommand(new FoundCapital((Colonist)target));
		  }
		
	}
	public String getDefaultName() {
		return "Found Capital";
	}

	
}
