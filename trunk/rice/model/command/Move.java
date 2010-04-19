package rice.model.command;

import java.util.List;

import rice.model.Controllable;
import rice.util.Position;

public class Move extends Command {

	List<Position> positions;
	
	public Move(Controllable c, List<Position> pos) {
		super(c);
		positions = pos;
		
	}

	@Override
	public int execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}
