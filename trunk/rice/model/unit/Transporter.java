/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import java.util.HashMap;
import java.util.List;

import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.util.Position;
import rice.view.MSVisitor;
import rice.view.UOVisitor;

/**
 *
 * @author Marcos
 */
public class Transporter extends Vehicle {

    public Transporter(int id, Player owner) {
		super("Transporter", id, owner);
		//default initializations
		  this.setMaxHealth(100.00);
		  this.setHealth(100.00);
		  this.setArmor(10);
		  this.setOffensiveDamage(1);
		  this.setDefensiveDamage(1);
		  this.setVisibilityRadius(1);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 10);
		  newUpkeep.put("Food", 0);
		  newUpkeep.put("Energy", 10);
		  this.setUpkeep(newUpkeep);
		  this.setSize(100);
		  this.setCapacity(80);
		  this.setSpeed(3);
	}

	public void accept(UOVisitor u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void accept(MSVisitor m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCapacity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addUnit(Unit u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeUnit(Unit u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Unit> getAllUnits() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
	public void accept(RiceSelector s)
	{
		s.addTransporter(this);
	}

}
