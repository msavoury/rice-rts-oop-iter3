package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.PowerDown;
import rice.model.command.PowerUp;

public class PowerUpAbility extends Ability{
  public PowerUpAbility(Controllable c) {
		super(c);
		setName("Power Up");
	}

  public void acceptInput(String s){
	  if(s.equals("CONFIRM_SELECTION_NO_ARGS")){
	    target.addCommand(new PowerUp(target));
	  }
  }
}
