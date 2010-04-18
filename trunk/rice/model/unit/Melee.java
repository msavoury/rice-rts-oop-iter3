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
public class Melee extends Unit {
  public Melee(int id, Player owner) {
		super("Melee", id, owner);
		//default initializations
		  this.setMaxHealth(50.00);
		  this.setHealth(50.00);
		  this.setArmor(5);
		  this.setOffensiveDamage(20);
		  this.setDefensiveDamage(10);
		  this.setVisibilityRadius(1);
		  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
		  newUpkeep.put("Ore", 0);
		  newUpkeep.put("Food", 20);
		  newUpkeep.put("Energy", 0);
		  this.setUpkeep(newUpkeep);
		  this.setSize(10);
		  this.setSpeed(1);
	}
public void accept(MSVisitor v){

    }
  public void accept(UOVisitor u) {
  //      throw new UnsupportedOperationException("Not supported yet.");
  }
  public boolean isSoldier() {
		return true;
	}
  
	public void accept(RiceSelector s)
	{
		s.addMelee(this);
	}
}
