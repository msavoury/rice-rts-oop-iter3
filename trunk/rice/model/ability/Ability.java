package rice.model.ability;

import rice.model.Controllable;

public abstract class Ability {
  String name = "default Ability";
  Controllable target;
  
  public Ability(Controllable c){
	  target = c;
  }
  
  void setName(String s){
	this.name = s;  
  }
  public String toString() {
	  return this.name;
  }
  
  public abstract void acceptInput(String input);
	  
  //}
    
}
