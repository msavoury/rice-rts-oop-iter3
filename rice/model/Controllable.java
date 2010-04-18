/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import rice.model.ability.Ability;
import rice.model.ability.PowerDownAbility;
import rice.model.ability.PowerUpAbility;
import rice.model.command.Command;
import rice.model.player.Player;
import rice.util.Position;
import rice.view.Viewable;


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
  private List<Ability> abilities;
  private int offensiveDamage = 2;
  private int defensiveDamage = 1;
  private HashMap upkeep;
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
	  //TODO: stuff with temp direction and speed and what not here
	  if(powered){
		  if(!commands.isEmpty()){
			  if(commands.executeCommand() == Command.FINISHED){
				  commands.pop();
			  }
		  }
		  else {
			  System.out.println(toString() + "Empty Command Queue");
		  }
	  }
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
  }
  
  /**
   * Initialize the abilities that the controllable is born with
   */
  private void initAbilities(){
	abilities = new ArrayList<Ability>();
    abilities.add(new PowerUpAbility(this));
    abilities.add(new PowerDownAbility(this));
    
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
  
  public void addCommand(Command c){
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
