/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.map;

import rice.model.Accessory;
import rice.model.Controllable;
import util.Position;

/**
 *
 * @author Marcos
 */
public class AreaTile extends Tile {
   // AreaTile(int x, int y,) {
    //AreaTile(int x, int y){
      //super(x,y);
   // }
   AreaTile (Position p){
       super(p);
   }

   AreaTile(Position p, int terrainType){
       super(p);
       //todo: set terraintype
   }

   public void putControllable(Controllable c){

   }

   public void putAccessory(Accessory a){

   }
}
