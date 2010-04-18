/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import java.util.HashMap;

import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.view.MSVisitor;
import rice.view.UOVisitor;

/**
 *
 * @author Marcos
 */
public class Explorer extends Unit{

    public Explorer(int id, Player owner) {
		super("Explorer", id, owner);
		//default initializations
		  this.setMaxHealth(15.00);
		  this.setHealth(15.00);
		  this.setArmor(3);
		  this.setOffensiveDamage(1);
		  this.setDefensiveDamage(2);
		  this.setVisibilityRadius(2);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 0);
		  newUpkeep.put("Food", 15);
		  newUpkeep.put("Energy", 0);
		  this.setUpkeep(newUpkeep);
		  this.setSize(10);
		  this.setSpeed(2);
	}

	public void accept(UOVisitor u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void accept(MSVisitor m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean isSoldier() {
		return false;
	}
    
	public void accept(RiceSelector s)
	{
		s.addExplorer(this);
	}

}
