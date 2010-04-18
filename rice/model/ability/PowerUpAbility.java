package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.PowerDown;
import rice.model.command.PowerUp;

public class PowerUpAbility extends Ability{
  public PowerUpAbility(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

String name = "Power Up";
  
  public void acceptInput(String s){
	  if(s.equals("enter")){
	    target.addCommand(new PowerUp(target));
	  }
  }
}
