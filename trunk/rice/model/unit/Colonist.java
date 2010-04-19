/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.unit;

import java.util.HashMap;

import rice.model.ability.FoundCapitalAbility;
import rice.model.player.Player;
import rice.model.player.RiceSelector;
import rice.view.MSVisitor;
import rice.view.UOVisitor;

/**
 *
 * @author Marcos
 */
public class Colonist extends Unit {

    public Colonist(int id, Player owner) {
		super("Colonist", id, owner);
		//default initializations
		  this.setMaxHealth(20.00);
		  this.setHealth(20.00);
		  this.setArmor(5);
		  this.setOffensiveDamage(1);
		  this.setDefensiveDamage(2);
		  this.setVisibilityRadius(1);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 0);
		  newUpkeep.put("Food", 10);
		  newUpkeep.put("Energy", 0);
		  this.setUpkeep(newUpkeep);
		  this.setSize(30);
		  this.setSpeed(1);
		  this.setPassability(1);
		
	}
    
    public boolean isSoldier() {
		return false;
	}
    
    public void initAbilities() {
    	super.initAbilities();
    	addAbility(new FoundCapitalAbility(this));
    }
    
	public void accept(UOVisitor u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void accept(MSVisitor m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
	public void accept(RiceSelector s)
	{
		s.addColonist(this);
	}

}
