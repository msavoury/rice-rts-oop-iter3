package rice.model.command;

import rice.model.map.AreaMap;
import rice.model.structures.Capital;
import rice.model.unit.Colonist;
import rice.model.unit.Melee;

public class FoundCapital extends Command {

	public FoundCapital(Colonist c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute() {
		Capital c = new Capital(1, target.getOwner());
		AreaMap.getInstance().putControllable(c, target.getLocation());
		target.getOwner().addCapital(c);
		c.addWorkers(5);
		
		Melee m1 = new Melee(1, target.getOwner());
		AreaMap.getInstance().putControllable(m1, target.getLocation());
		target.getOwner().addMelee(m1);
		
		Melee m2 = new Melee(2, target.getOwner());
		AreaMap.getInstance().putControllable(m2, target.getLocation());
		target.getOwner().addMelee(m2);

		c.addUnit(m1);
		c.addUnit(m2);
		
		target.destroy();
		
		return FINISHED;
	}

}
