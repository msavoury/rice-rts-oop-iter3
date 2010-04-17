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
import rice.util.Position;


/**
 *
 * @author Marcos
 */
public abstract class Controllable extends Locatable implements Viewable {
  private int id;
  private Player owner;
  private double health = 10;
  private int armor = 10;
  private int visibilityRadius = 2;
  private List abilities;
  private int offensiveDamage = 2;
  private int defensiveDamage = 1;
  private HashMap upkeep;
  private String status = "I'm Chillin";
  private boolean powered = true;
  private CommandQueue commands;
  
  public Controllable(String typeName, int id, Player owner)
  {
	  super(typeName);
	  this.id=id;
	  this.owner=owner;
	  this.commands = new CommandQueue();
	  initAbilities();
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
  
  public double getHealth() {
    return this.health;
  }
  
  public int getArmor() {
	  return this.armor;
  }
  
  public int getAttack() {
      return this.offensiveDamage;
  }

  public int getDefense() {
      return this.defensiveDamage;
  }
  
  public void tick(){
	  System.out.println("Controllable ticking here!");
  }
  
  public void destroy() {
	  
  }
  
  public void performSelectedAbility(String ability) {
	  
  }
  
  public void nextAbility() {
	  
  }
  
  public void previousAbility() {
	  
  }
  
  private void initAbilities(){
    
  }
  
  public String getSelectedAbility() {
	throw new UnsupportedOperationException();  	  
  }
  
  public boolean getPowerStatus() {
	  return powered;
  }
  
  public String getStatus() {
		return this.status;  	  
  }
  
  /**
   * Set whether the Controllable is powered up or powered down 
   */
  public void setPowerStatus(boolean powerStatus) {
	  this.powered = powerStatus;
  }
 
  /**
   * Return an array of strings that represents the current state of the commands in the 
   * queue
   * @return
   */
  public String[] getCommandQueue() {
    return commands.getCommandStrings();
  }
  
  public void addCommand(Command c){
    commands.addCommand(c);
  }
  
  public void resetActionTiles() {
	  
  }
  
  public void addActionTile(Position p){
	  
  }
}
