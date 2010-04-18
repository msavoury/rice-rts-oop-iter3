/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import rice.model.player.Player;
import rice.view.ViewableVehicle;

/**
 *
 * @author Marcos
 */
public abstract class Vehicle extends Unit implements ViewableVehicle, UnitOwner {
	private int capacity;
	
	public Vehicle(String typeName, int id, Player owner)
	{
		super(typeName, id, owner);
		
		//default vehicle stat initialization
		this.setSize(50);
		this.setCapacity(40);
		
	}
	
	public int getCapacity()
    {
        return this.capacity;
    }
    
    protected void setCapacity(int capacity)
    {
    	this.capacity=capacity;
    }   

	public boolean isSoldier() {
		return false;
	}
}
