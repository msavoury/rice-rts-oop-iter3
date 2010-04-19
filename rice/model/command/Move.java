package rice.model.command;

import java.util.List;

import rice.model.Controllable;
import rice.model.unit.Unit;
import rice.util.Position;

public class Move extends Command {

	List<Position> positions;
	List<Double> doubles;
	int counter;
	int speed;
	
	public Move(Controllable c, List<Position> pos) {
		super(c);
		positions = pos;
		speed = ((Unit)c).getSpeed(); 
		counter = 0;
	}
	
	public Move(Controllable c, List<Position> pos, List<Double> doubles) {
		super(c);
		positions = pos;
		this.doubles = doubles;
		speed = ((Unit)c).getSpeed(); 
		counter = 0;
	}

	@Override
	public int execute() {
		counter++;
		target.setStatus("Moving");
		Unit u = (Unit)target;
		u.setTempSpeed(u.getSpeed());
		u.setTempDirection(doubles.get(0).doubleValue());
		if(u.willMove()){
		// counter = 0;
		 doubles.remove(0);
		 }
		 if(doubles.size() > 0){
			 //u.resetActionTiles();
		   return CONTINUOUS;
		  
		 }
		 else{
			 //u.resetActionTiles();
		   u.setStatus("Idle");
		   return FINISHED;
		 }
		}
	//}

}
