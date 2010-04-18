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
		double dmg=c.getAttack();
		if((dmg>0) && (c.getLocation()!=null))
		{
			Position targetPosition = AreaMap.getInstance().getAdjecentPosition(c.getLocation(), direction);
			if(AreaMap.getInstance().verifyLocation(targetPosition))
			{
				double defDmg=dealDamage(c, targetPosition, dmg);
				c.takeDamage(defDmg);
			}
		}
	}
	
	public static void Defend(Controllable c, double direction)
	{		
		double dmg=c.getDefense();
		if((dmg>0) && (c.getLocation()!=null))
		{
			Position targetPosition = AreaMap.getInstance().getAdjecentPosition(c.getLocation(), direction);
			if(AreaMap.getInstance().verifyLocation(targetPosition))
			{
				double defDmg=dealDamage(c, targetPosition, dmg);
				c.takeDamage(defDmg);
			}
		}
	}
	
	private static double dealDamage(Controllable c, Position targetPosition, double dmg)
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
				return defDmg;
			}
		}
		return 0;
	}
	
	public static void areaAttack(Controllable c, int radius)
	{
		for(int i=1; i<=radius;i++)
		{
			double dmg=c.getAttack()*(radius/(radius+i-1));
			if((dmg>0) && (c.getLocation()!=null))
			{			
				List<Position> targetPositions = AreaMap.getInstance().getPositionRing(c.getLocation(), i);
				Iterator<Position> iter = targetPositions.iterator();
				while(iter.hasNext())
				{
					Position targetPosition = iter.next();
					double defDmg=dealDamage(c, targetPosition, dmg);
					if(i==0)
					{
						c.takeDamage(defDmg);		
					}
				}			
			}
		}
	}
	
	
}
