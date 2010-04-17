/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.map;

import rice.model.Controllable;
import rice.model.accessories.Accessory;
import rice.util.Position;

/**
 *
 * @author Marcos
 */
public class AreaTile extends Tile {
	private int terrain;
	private int passabilityLevel;
	
   AreaTile(Position p, int terrainType){
       super(p);
       this.terrain=terrainType;
       this.passabilityLevel=terrainType;
       //todo: set terraintype
   }
   
   //return passability level
   public int getPassabilityLevel()
   {
	   return this.passabilityLevel;
   }
   
   //change passability level
   public void changePassabilityLevel(int value)
   {
	   this.passabilityLevel+=value;
   }

   public void putControllable(Controllable c){

   }

   public void putAccessory(Accessory a){

   }
}
