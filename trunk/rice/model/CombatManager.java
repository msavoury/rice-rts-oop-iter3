package rice.model;

import java.util.Iterator;
import java.util.List;

import rice.model.map.AreaMap;
import rice.model.structures.Fort;
import rice.util.Position;

public class CombatManager
{

	public static void Attack(Controllable c, double direction)
	{		
		dealDamage(c, direction, c.getAttack());
	}
	
	public static void Defend(Controllable c, double direction)
	{		
		dealDamage(c, direction, c.getDefense());
	}
	
	private static void dealDamage(Controllable c, double direction, double dmg)
	{		
		if(dmg>0)
		{
			Position targetPosition = AreaMap.getInstance().getAdjecentPosition(c.getLocation(), direction);
			if(AreaMap.getInstance().verifyLocation(targetPosition))
			{
				List<Controllable> targets = AreaMap.getInstance().getControllableList(targetPosition);
				Iterator<Controllable> iter = targets.iterator();
				while(iter.hasNext())
				{
					Controllable target = iter.next();
					if(!c.getOwner().equals(target.getOwner()))
					{
						int defDmg = target.getDefense();
						target.takeDamage(dmg);
						c.takeDamage(defDmg);						
						break;
					}
				}
			}
		}
	}
	
	public static void areaAttack(Controllable c, int radius)
	{
		for(int i=1; i<=radius;i++)
		{
			double offDmg=c.getAttack()*(radius/(radius+i-1));
			List<Position> targetPositions = AreaMap.getInstance().getPositionRing(c.getLocation(), i);
			Iterator<Position> iter = targetPositions.iterator();
			while(iter.hasNext())
			{
				Position targetPosition = iter.next();
				
				List<Controllable> targets = AreaMap.getInstance().getControllableList(targetPosition);
				Iterator<Controllable> iter2 = targets.iterator();
				while(iter2.hasNext())
				{
					Controllable target = iter2.next();
					if(!c.getOwner().equals(target.getOwner()))
					{
						int defDmg = target.getDefense();
						target.takeDamage(offDmg);
						if(i==1)
						{
							c.takeDamage(defDmg);						
						}
						break;
					}
				}				
			}			
		}
	}
	
	
}
