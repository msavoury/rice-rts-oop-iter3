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
	
	public Defend(Unit c, double direction) {
		super(c);
		this.defendDirection = direction;
		
	}

	@Override
	public int execute() {
		CombatManager.Defend(target, defendDirection);
		return CONTINUOUS;
	}

}
