package rice.model.ability;

import rice.model.Controllable;

public class UnexploreAbility extends Ability {

	public UnexploreAbility(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptInput(String input) {
		// TODO Auto-generated method stub
		
	}
	
	public String getDefaultName() {
		return "Unexplore";
	}

}
