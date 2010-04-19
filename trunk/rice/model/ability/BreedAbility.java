package rice.model.ability;

import java.util.Scanner;
import rice.model.command.Breed;
import rice.model.structures.Capital;

public class BreedAbility extends Ability
{
        Capital c;
	public BreedAbility(Capital c) {
		super(c);
                this.c = c;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void acceptInput(String input) {
		// TODO Auto-generated method stub
		switch (state){
			case START:
			  if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
				  state = CAPTURING;
				  setName("Enter Amount");
			  }
			  break;
			case CAPTURING:
			  
                              System.out.println(input);
                              if(input.equals("HOTKEY_2")){
                                  int nw = 2;
                                  c.addCommand(new Breed(c, nw));
                              }
                              reset();
			  
			break;
		  }
	}

	@Override
	public String getDefaultName() {
		return "Breed";
	}

}
