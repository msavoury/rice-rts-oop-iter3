/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import rice.model.Controllable;
import rice.model.ability.AttackAbility;
import rice.model.ability.DefendAbility;
import rice.model.ability.MoveAbility;
import rice.model.command.Command;
import rice.model.map.AreaMap;
import rice.model.map.AreaTileVisitor;
import rice.model.player.Player;
import rice.util.Position;
import rice.view.ViewableUnit;

/**
 *
 * @author Marcos
 */
public abstract class Unit extends Controllable implements ViewableUnit {
     private int speed;
     private int size;
     private int passabilityLevel;

     private int tempSpeed;
     private double tempDirection;
     
     //private Position destination;
     
     private int moveCounter;

     private UnitOwner unitOwner;

	
     public Unit(String typeName, int id, Player owner)
     {
		super(typeName, id, owner);
		
		//default unit stat initialization
		this.setSize(10);
		this.setSpeed(2);
		this.setPassability(1);
		
	 }
     
     public UnitOwner getUnitOwner()
     {
    	 return this.unitOwner;
     }
     
     public void setUnitOwner(UnitOwner unitOwner)
     {
    	 if (this.unitOwner!=null)
    	 {
    		 this.unitOwner.removeUnit(this);
    	 }
    	 this.unitOwner=unitOwner;
     }

    public abstract boolean isSoldier();
    
    public void initAbilities(){
    	super.initAbilities();
    	addAbility(new DefendAbility(this));
    	addAbility(new MoveAbility(this));
    	addAbility(new AttackAbility(this));
    	//attack
    	//
    }
    
    public int getSpeed()
    {
        return this.speed+this.getOwner().getTechBonus(this.getTypeName(),"Movement Speed");
    }
    
    public void tick() {
      	this.refreshModifiers();
      	getOwner().updateTiles(getLocation(), this.getVisibilityRadius());

      	tempSpeed = (int)this.getModifiers().getFlowRate();
      	//System.out.println("flow rate is " + tempSpeed);
      	tempDirection = this.getModifiers().getFlowDirection();
      	
    	if(!queueIsEmpty()){
    	   int result = executeCommand();
    	 //  System.err.println("right after command, My temp direction is "+ tempDirection);
    	  if( result == Command.FINISHED ||(result == Command.CONTINUOUS && getCommandSize() > 1)){
    	      popCommand();
    	      System.out.println("Command popped");
    	  }
    	}
    	else {
    			  
    	}
    	//System.err.println("right before move, My temp direction is "+ tempDirection);
  	  
    	doMove();
    //	System.err.println("right after move, My temp direction is "+ tempDirection);
  	  
     }
    
    public void doMove() {
      /*if(tempSpeed > 0){
        moveCounter++;
      }*/
   // System.err.println("Start Move. Location: " + getLocation() + " Direction: " + tempDirection + " Speed: " + tempSpeed + " Counter: " + moveCounter);	
      
      if(tempSpeed > 0){
        if(moveCounter > tempSpeed){
    	  moveCounter = 0;
    	  //tempSpeed = 0;
    	  System.err.println("current position is " + getLocation() + "direction is " + tempDirection);
    	  Position destination = AreaMap.getInstance().getAdjecentPosition(getLocation(),tempDirection);
    	  System.err.println("new position is " + destination.toString());
    	  AreaMap.getInstance().putControllable(this, destination);
    	  resetActionTiles();	
        }
      }
      moveCounter++;
      tempSpeed = 0;
    }
    
    public boolean willMove(){
    	//setDestination(Position p)
    	return (moveCounter > tempSpeed);
    }
    
    protected void setSpeed(int speed)
    {
    	this.speed=(speed>0 ? speed : 1);
    }
    
    public void setTempDirection(double d){
    	System.out.println("Setting temp direction of " + d);
    	this.tempDirection = d;
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
	
	public double getHealthPercentage()
	{
		return this.getHealth()/this.getMaxHealth();
	}
  	
	public String getViewableUnitOwner()
	{
		if(this.getUnitOwner()==null)
		{
			return "";
		}
		{
			return this.getUnitOwner().toString();
		}
	}
	
	public void setTempSpeed(int speed){
		System.out.println("Setting temp speed to " + speed);
		this.tempSpeed = speed;
	}
}
