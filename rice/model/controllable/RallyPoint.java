package rice.model.controllable;

import java.util.List;

import rice.model.Controllable;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.ViewableRallyPoint;
import rice.view.ViewableUnit;

public class RallyPoint extends Controllable implements ViewableRallyPoint {

	public RallyPoint(String typeName, int id, Player owner) {
		super(typeName, id, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(MSVisitor m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ViewableUnit> getAllUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ViewableUnit> getBattleGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ViewableUnit> getSupportGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(RiceSelector s)
	{
		s.addRallyPoint(this);		
	}

	@Override
	public String getCommand() {
		
		return "default Rally Command";
	}

}
