package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.PowerDown;

public class PowerDownAbility extends Ability{
	String name = "Power Down";
	
	public PowerDownAbility(Controllable c) {
		super(c);
		// TODO Auto-generated constructor stub
	}


  
  public void acceptInput(String s){
	  if(s.equals("enter")){
	    target.addCommand(new PowerDown(target));
	  }
  }
}
