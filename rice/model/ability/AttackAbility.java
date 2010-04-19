package rice.model.ability;

import java.util.ArrayList;
import java.util.List;

import rice.model.Controllable;
import rice.model.command.Move;
import rice.util.Position;


public class AttackAbility extends Ability {

	
	
	public AttackAbility(Controllable c) {
		super(c);
		
	}

	@Override
	public void acceptInput(String input) {
		 
	}

	@Override
	public String getDefaultName() {
		return "Attack";
	}

}
