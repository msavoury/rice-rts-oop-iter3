package rice.model.ability;

import rice.model.Controllable;

public abstract class Ability {
  String name;
  Controllable target;
  
  public Ability(Controllable c){
	  target = c;
  }
  
  public String toString() {
	  return this.name;
  }
  
  public void acceptInput(String input){
	  
  }
    
}
