package rice.model.ability;

import java.util.ArrayList;
import java.util.List;

import rice.model.Controllable;
import rice.model.command.Move;
import rice.model.map.AreaMap;
import rice.model.map.AreaTile;
import rice.model.map.MapPositionTranslator;
import rice.util.Position;

public class MoveAbility extends Ability {
	List<Position> directionList;
	AreaTile lastTile;
	Position lastPosition;

	public MoveAbility(Controllable c) {
		super(c);
		directionList = new ArrayList<Position>();
		lastTile = c.getTile();
		lastPosition = c.getTile().getPosition();
	}

	@Override
	public void acceptInput(String input) {
		 switch (state){
			case START: 
			  if(input.equals("CONFIRM_SELECTION_NO_ARGS")){
				  state = CAPTURING;
				  setName("Enter Directions");
			  }
			  break;
			case CAPTURING:
			  if(isDirection(input)){
				 // int direction = AreaMap.getInstance().convertToDirection(input);
				  Position p = AreaMap.getInstance().getAdjecentPosition(lastPosition, MapPositionTranslator.convertDirection(input));
				  directionList.add(p);
				  target.addActionTile(p);
				  lastPosition = p;
				  
				  System.out.println("adding position" + lastPosition.getX() + "," + lastPosition.getY());
				  
				  
			  }
			  else if (input.equals("CONFIRM_SELECTION_NO_ARGS")){
				  target.addCommand(new Move(target, directionList));
				  reset();
			  }
			  else {
				  target.resetActionTiles();
				  this.directionList = new ArrayList<Position>();
				  reset();
			  }
			break;
		  }
			
		
	}
	
	public String getDefaultName() {
		return "Move";
	}

}
