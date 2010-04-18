package rice.model.structures;

import rice.model.player.Player;
import rice.model.player.RiceSelector;

public class ObservatoryTower extends Structure {

	public ObservatoryTower(int id, Player owner)
	{
		super("Observatory", id, owner);
	}
	
	@Override
	public int addWorkers(int workers) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIdleWorkerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalWorkerCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeIdleWorkers(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeWorkers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAllocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlocation(double percentage) {
		// TODO Auto-generated method stub

	}
	
	public void accept(RiceSelector s)
	{
		s.addObservatoryTower(this);
	}

}