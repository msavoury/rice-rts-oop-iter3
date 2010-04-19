package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.Explore;

public class ExploreAbility extends Ability{

	public ExploreAbility(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptInput(String input) {
		if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
			  //state = CAPTURING;
			 // setName("Enter Direction");
            target.addCommand(new Explore(target));
		  }
		
	}

	public String getDefaultName() {
		return "Explore";
	}
}
