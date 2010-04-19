package rice.model.command;

import rice.model.CombatManager;
import rice.model.Controllable;
import rice.model.unit.Unit;

public class Attack extends Command {


	double attackDirection;
	String directionString;
	
	public Attack(Unit c, double direction, String sdirection) {
		super(c);
		this.attackDirection = direction;
		directionString = sdirection;
		setName("Attack");
	}

	@Override
	public int execute() {
		CombatManager.Attack(target, attackDirection);
		target.setStatus("Attacking: " + directionString);
		return CONTINUOUS;
	}

}
