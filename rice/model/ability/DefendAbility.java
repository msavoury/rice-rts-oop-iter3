package rice.model.ability;

import rice.model.command.Defend;
import rice.model.map.MapPositionTranslator;
import rice.model.unit.Unit;

public class DefendAbility extends Ability {

	public DefendAbility(Unit c) {
		super(c);
		
	}

	@Override
	public void acceptInput(String input) {
	  switch (state){
		case START: 
		  if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
			  state = CAPTURING;
			  setName("Enter Direction");
		  }
		  break;
		case CAPTURING:
		  if(isDirection(input)){
			  target.addCommand(new Defend((Unit)target, MapPositionTranslator.convertDirection(input)));
			  reset();
		  }
		break;
	  }
		
	}

}
