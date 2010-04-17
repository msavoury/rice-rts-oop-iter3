package rice.model.accessories;

import rice.model.Controllable;

public interface BonusGiver
{
	public int getBonus(String bonus, int radius, Controllable c);
}
