package rice.model.ability;

import rice.model.Controllable;
import rice.model.command.PowerDown;

public class PowerDownAbility extends Ability{
	
	
	public PowerDownAbility(Controllable c) {
		super(c);
		//setName("Power Down");
	}


  
  public void acceptInput(String s){
	  if(s.equals("CONFIRM_SELECTION_NO_ARGS")){
	    target.addCommand(new PowerDown(target));
	  }
  }
  
  public String getDefaultName() {
		return "Power Down";
	}
}
