package rice.model.map;


import java.util.ArrayList;
import java.util.HashMap;

import rice.model.Controllable;
import rice.model.accessories.Accessory;
import rice.model.accessories.AreaBonus;
import rice.model.accessories.Flow;

public class ModifierVisitor
{
	private Controllable controllable;
	
	private double flowDirection;
	private double flowRate;
	private HashMap<String,Integer> bonuses = new HashMap<String,Integer>();
	
	public ModifierVisitor(Controllable controllable)
	{
		this.controllable=controllable;
	}
	
	public int getBonus(String type)
	{
		if(this.bonuses.containsKey(type))
		{
			return this.bonuses.get(type);
		}
		else
		{
			return 0;
		}		
	}
	
	public double getFlowDirection()
	{
		return this.flowDirection;
	}
	
	public double getFlowRate()
	{
		return this.flowRate;
	}
	
	public void visit(Accessory a)
	{
		
	}
	
	public void visit(AreaBonus a)
	{
		String bonusType=a.getType();
		int bonus = a.getBonus(this.controllable);
		
		if(bonus!=0)
		{
			if(this.bonuses.containsKey(bonusType))
			{
				int oldBonus=this.bonuses.get(bonusType);
				int newBonus=oldBonus+bonus;
				this.bonuses.put(bonusType, newBonus);
			}
			else
			{
				this.bonuses.put(bonusType, bonus);
			}
		}		
	}
	
	public void visit(Flow f)
	{
		this.flowRate=f.getFlowRate();
		this.flowDirection=f.getDirection();
	}
}
