/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import rice.model.Controllable;
import rice.model.ability.DefendAbility;
import rice.model.map.AreaTileVisitor;
import rice.model.player.Player;
import rice.view.ViewableUnit;

/**
 *
 * @author Marcos
 */
public abstract class Unit extends Controllable implements ViewableUnit {
     private int speed;
     private int size;
     private int passabilityLevel;
	
     public Unit(String typeName, int id, Player owner)
     {
		super(typeName, id, owner);
		
		//default unit stat initialization
		this.setSize(10);
		this.setSpeed(2);
		this.setPassability(1);
		
	 }

    public abstract boolean isSoldier();
    
    public void initAbilities(){
    	super.initAbilities();
    	addAbility(new DefendAbility(this));
    	//attack
    	//
    }
    
    public int getSpeed()
    {
        return this.speed+this.getOwner().getTechBonus(this.getTypeName(),"Movement Speed");
    }
    
    protected void setSpeed(int speed)
    {
    	this.speed=(speed>0 ? speed : 1);
    }

    public int getSize()
    {
        return this.size;
    }
    
    protected void setSize(int size)
    {
    	this.size=(size>0 ? size : 1);
    }   
    
    public int getPassability()
    {
        return this.passabilityLevel;
    }
    
    protected void setPassability(int passabilityLevel)
    {
    	this.passabilityLevel=(passabilityLevel>0 ? passabilityLevel : 1);
    }   

  	public void accept(AreaTileVisitor v)
	{
		v.visit(this);
	}
	
	public String getViewableUnitOwner(){
		return getOwner().toString();
	}
	
}
