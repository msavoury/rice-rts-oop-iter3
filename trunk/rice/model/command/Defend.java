package rice.model.command;

import rice.model.CombatManager;
import rice.model.unit.Unit;

/**
 * Defend a certain position.  Defend only should be placed in unit types
 * @author Marcos
 *
 */
public class Defend extends Command {

	double defendDirection;
	String directionString;
	
	public Defend(Unit c, double direction, String sdirection) {
		super(c);
		this.defendDirection = direction;
		this.directionString = sdirection;
		//setName("Defend");
		
	}

	@Override
	public int execute() {
		CombatManager.Defend(target, defendDirection);
		target.setStatus("Defending: " + directionString);
		return CONTINUOUS;
	}

}
