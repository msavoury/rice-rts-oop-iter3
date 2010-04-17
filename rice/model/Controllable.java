/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import java.util.HashMap;
import java.util.List;

import rice.model.command.Command;
import rice.model.player.Player;
import rice.view.Viewable;
import util.Position;


/**
 *
 * @author Marcos
 */
public abstract class Controllable extends Locatable implements Viewable {
  private int id;
  private Player owner;
  private double health;
  private int armor;
  private int visibilityRadius;
  private List abilities;
  private int offensiveDamage;
  private int defensiveDamage;
  private HashMap upkeep;
  
  public Controllable(String typeName, int id, Player owner)
  {
	  super(typeName);
	  this.id=id;
	  this.owner=owner;
  }

  public String getType() {
      return this.getTypeName();
  }
  
  //return the controllables id
  public int getId()
  {
	  return this.id;
  }
  
  //return the controllables owner
  public Player getOwner()
  {
	  return this.owner;
  }
  
  public void tick(){
	  
  }
  
  public void destroy() {
	  
  }
  
  public void performSelectedAbility(String ability) {
	  
  }
  
  public void nextAbility() {
	  
  }
  
  public void previousAbility() {
	  
  }
  
  public String getSelectedAbility() {
	throw new UnsupportedOperationException();  	  
  }
  
  public boolean getPowerStatus() {
	  return false;
  }
  
  public String getStatus() {
		throw new UnsupportedOperationException();  	  

  }
  
  /**
   * Set whether the Controllable is powered up or powered down 
   */
  public void setPowerStatus(boolean powerStatus) {
	  
  }
   
  public String[] getCommandQueue() {
		throw new UnsupportedOperationException();  	  

  }
  
  public void addCommand(Command c){
		throw new UnsupportedOperationException();  	  

  }
  
  public void resetActionTiles() {
	  
  }
  
  public void addActionTile(Position p){
	  
  }
}
