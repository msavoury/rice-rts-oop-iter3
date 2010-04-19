/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rice.model.Controllable;
import rice.model.accessories.Accessory;
import rice.util.Position;

/**
 *
 * @author Marcos
 */
public class AreaTile extends Tile implements ATVisitorAcceptor, ResourceVisitorAcceptor, MVAcceptor {
	private int terrain;
	private int passabilityLevel;
	private ArrayList<Controllable> controllables = new ArrayList<Controllable>();
	private ArrayList<Accessory> accessories = new ArrayList<Accessory>();
	
   AreaTile(Position p, int terrainType){
       super(p);
       this.terrain=terrainType;
       this.passabilityLevel=terrainType;
       //todo: set terraintype
   }
   
   //returns the terrain type
   public int getTerrainType()
   {
	   return this.terrain;
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

   public List<Controllable> getControllables()
   {
	   return this.controllables;
   }
   
   public void putControllable(Controllable c)
   {
	   if(!this.controllables.contains(c))
	   {
		   this.controllables.add(c);
		   c.setTile(this);
	   }
   }
   
   public void removeControllable(Controllable c)
   {
	   this.controllables.remove(c);
   }

   public List<Accessory> getAccessories()
   {
	   return this.accessories;
   }
   
   public void putAccessory(Accessory a)
   {
	   if(!this.accessories.contains(a))
	   {
		   this.accessories.add(a);
	   }
   }
   
   public void removeAccessory(Accessory a)
   {
	   this.accessories.remove(a);
   }


	public void accept(AreaTileVisitor v)
	{
		v.visit(this);	
		Iterator<Controllable> cIter = this.controllables.iterator();
		while(cIter.hasNext())
		{
			cIter.next().accept(v);
		}
		
		Iterator<Accessory> aIter = this.accessories.iterator();
		while(aIter.hasNext())
		{
			aIter.next().accept(v);
		}
	}

	public void accept(ResourceVisitor v)
	{
		Iterator<Accessory> aIter = this.accessories.iterator();
		while(aIter.hasNext())
		{
			aIter.next().accept(v);
		}		
	}

	public void accept(ModifierVisitor v)
	{
		Iterator<Accessory> aIter = this.accessories.iterator();
		while(aIter.hasNext())
		{
			aIter.next().accept(v);
		}	
	}
}
