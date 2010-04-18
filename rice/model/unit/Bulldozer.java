/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import java.util.HashMap;
import java.util.List;

import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.view.MSVisitor;
import rice.view.UOVisitor;

/**
 *
 * @author Marcos
 */
public class Bulldozer extends COV {

    public Bulldozer(int id, Player owner) {
		super("Bulldozer", id, owner);
		//default initializations
		  this.setMaxHealth(150.00);
		  this.setHealth(150.00);
		  this.setArmor(15);
		  this.setOffensiveDamage(1);
		  this.setDefensiveDamage(1);
		  this.setVisibilityRadius(1);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 15);
		  newUpkeep.put("Food", 0);
		  newUpkeep.put("Energy", 15);
		  this.setUpkeep(newUpkeep);
		  this.setSize(100);
		  this.setCapacity(20);
		  this.setSpeed(1);
		  this.setPassability(2);
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
		s.addBulldozer(this);
	}

}
