/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import rice.model.ability.Ability;
import rice.model.ability.ClearQueueAbility;
import rice.model.ability.DecommissionAbility;
import rice.model.ability.PowerDownAbility;
import rice.model.ability.PowerUpAbility;
import rice.model.ability.WaitAbility;
import rice.model.command.Command;
import rice.model.map.AreaTile;
import rice.model.player.Player;
import rice.model.player.SelectorAcceptor;
import rice.util.Position;
import rice.view.Viewable;


/**
 * The controllable class represents all things that can be controlled by a Player
 * @author Marcos
 */
public abstract class Controllable extends Locatable implements Viewable, SelectorAcceptor {
  private int id;
  private Player owner;
  private double health = 10;
  private double maxHealth = 10;
  private int armor = 10;
  private int visibilityRadius = 2;
  private List<Ability> abilities;
  private int offensiveDamage = 2;
  private int defensiveDamage = 1;
  private HashMap<String,Integer> upkeep;
  private String status = "I'm Chillin";
  private boolean powered = true;
  private CommandQueue commands;
  
  private int abilityPointer = 0; 
  
  public Controllable(String typeName, int id, Player owner)
  {
	  super(typeName);
	  this.id=id;
	  this.owner=owner;
	  this.commands = new CommandQueue();
	  initAbilities();
  }
  
  public void removeFromTile()
  {
	if(this.getTile()!=null)
	{
		this.getTile().removeControllable(this);
	}
  }
  
  public void setTile(AreaTile areaTile)
  {
  	this.removeFromTile();
  	areaTile.putControllable(this);
	super.setTile(areaTile);
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
  
  public double getHealth()
  {
    return this.health;
  }
  
  public double getMaxHealth()
  {
    return this.maxHealth+this.owner.getTechBonus(this.getTypeName(),"Health");
  }
  
  protected void setHealth(double health)
  {
	  this.health=Math.min(health, this.getMaxHealth());
	  if(this.health<=0)
	  {
		  this.health=0;
		  this.destroy();
	  }
  }
  
  protected void setMaxHealth(double health)
  {
	  if(health>0)
	  {
		  this.maxHealth=health;
	  }
	  this.setHealth(this.getHealth());
  }
  
  public void changeHealth(double value)
  {
	  this.setHealth(this.getHealth()+value);
  }
  
  public void takeDamage(int value)
  {
	  if(value<0)
	  {
		  value=value*(-1);
	  }
	  this.changeHealth((double)this.getArmor()-value);
  }
  
  public int getArmor()
  {
	  return this.armor+this.owner.getTechBonus(this.getTypeName(),"Armor");
  }
  
  public int getAttack()
  {
      return this.offensiveDamage+this.owner.getTechBonus(this.getTypeName(),"Attack");
  }

  public int getDefense()
  {
      return this.defensiveDamage+this.owner.getTechBonus(this.getTypeName(),"Defense");
  }
  
  public int getVisibilityRadius()
  {
	  return this.visibilityRadius+this.owner.getTechBonus(this.getTypeName(),"Visibility Radius");
  }
  
  protected void setVisibilityRadius(int radius)
  {
	  this.visibilityRadius=radius;
  }
  
  public int getOffensiveDamage()
  {
	  return this.offensiveDamage+this.owner.getTechBonus(this.getTypeName(),"Attack");
  }
  
  protected void setOffensiveDamage(int attack)
  {
	  this.offensiveDamage=attack;
  }
  
  public int getDefensiveDamage()
  {
	  return this.defensiveDamage+this.owner.getTechBonus(this.getTypeName(),"Defense");
  }
  
  protected void setDefensiveDamage(int defense)
  {
	  this.defensiveDamage=defense;
  }
  
  public HashMap<String,Integer> getUpkeep()
  {
	  HashMap<String,Integer> newUpkeep = new HashMap<String,Integer>();
	  int efficiency=this.owner.getTechBonus(this.getTypeName(),"Efficiency");
	  Set<String> keys = this.upkeep.keySet();
	  Iterator<String> iter = keys.iterator();
	  while(iter.hasNext())
	  {
		  String key=iter.next();
		  int value=(int)(this.upkeep.get(key)*(this.powered ? 1 : 0.25)*(1/(efficiency+1)));
		  newUpkeep.put(key, value);
	  }
	  return newUpkeep;
  }
  
  protected void setUpkeep(HashMap<String,Integer> upkeep)
  {
	  this.upkeep=upkeep;
  }
  
  public void tick(){
	  // System.out.println("Controllable: " +this.getType() +" tick. Powered status: " + powered);
	  //TODO: stuff with temp direction and speed and what not here
	  //if(powered){
		  if(!commands.isEmpty()){
			  if(commands.executeCommand() == Command.FINISHED){
				  commands.pop();
			  }
		  }
		  else {
			  
		  }
		  System.out.println(toString() + "PowerStatus: " + powered + printQueue());
		  
	 // }
	  //TODO: stuff with applyables here
  }
  
  public void destroy() {
	  //remove reference in the selector
  }
  
  /**
   * Perform the currently selected ability
   * @param ability
   */
  public void performSelectedAbility(String ability) {
	System.out.println("perform selected ability");
    abilities.get(abilityPointer).acceptInput(ability);  
  }
  
  /**
   * Select the next ability in the ability list.  List is implemented in a fashion such 
   * that reaching the end of the list cycles back to the beginning
   */
  public void nextAbility() {
    abilityPointer++;
    if(abilityPointer >= abilities.size()){
    	abilityPointer = 0;
    }
	System.out.println("in controllable: "+getSelectedAbility());

  }
  
  /**
   * Select the previous ability in the ability list.  List is implemented in a fashion such 
   * that reaching the beginning of the list cycles back to the end
   */
  public void previousAbility() {
	abilityPointer--;
	if(abilityPointer < 0){
		abilityPointer = abilities.size() -1;
	}
	System.out.println("in controllable: "+getSelectedAbility());

	
  }
  
  /**
   * Initialize the abilities that the controllable is born with
   */
  private void initAbilities(){
	abilities = new ArrayList<Ability>();
	abilities.add(new PowerDownAbility(this));
    abilities.add(new PowerUpAbility(this));
    abilities.add(new DecommissionAbility(this));
    abilities.add(new ClearQueueAbility(this));
    abilities.add(new WaitAbility(this));
    
  }
  
  /**
   * Return selected ability
   * @return
   */
  public String getSelectedAbility() {
	//throw new UnsupportedOperationException();
	return abilities.get(abilityPointer).toString();
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
  
  /**
   * Clear current list of commands
   */
  public void clearQueue() {
	 commands.clear();
  }
  
  /**
   * Convenience method that return current queue as one string
   * @return
   */
  public String printQueue() {
	  StringBuffer buff = new StringBuffer();
	  for(String s: commands.getCommandStrings()){
		  buff.append(s+",");
	  }
	  return buff.toString();
  }
  
  public void addCommand(Command c){
	System.out.println(c.toString() +" added to " + getType());
    commands.addCommand(c);
  }
  
  public void resetActionTiles() {
	  
  }
  
  public void addActionTile(Position p){
	  
  }
  
  /**
   * This method returns an Array of positions that indicate the current focus of the Controllable.
   * For most cases, it will simply return it's current position.  For movement, it will return the
   * currently selected path to be traveled.  The array should be in order, such that the final
   * destination tile is the last tile in the array.
   */
  public void getActionTiles() {
	  
  }
}
