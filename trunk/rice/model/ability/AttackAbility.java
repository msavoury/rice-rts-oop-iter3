package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.Attack;
import rice.model.map.MapPositionTranslator;
import rice.model.unit.Unit;


public class AttackAbility extends Ability {

	
	
	public AttackAbility(Controllable c) {
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
				  target.addCommand(new Attack((Unit)target, MapPositionTranslator.convertDirection(input), input));
				  reset();
			  }
			break;
		  }
			
	}

	@Override
	public String getDefaultName() {
		return "Attack";
	}

}
