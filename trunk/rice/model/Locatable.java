/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.model;
import rice.model.map.AreaTile;

/**
 *
 * @author Marcos
 */
public abstract class Locatable {
    private AreaTile areaTile;
    private String typeName;

    public Locatable(String typeName)
    {
    	this.typeName=typeName;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public AreaTile getTile()
    {
    	return this.areaTile;
    }
    
    public void setTile(AreaTile areaTile)
    {
    	this.areaTile=areaTile;
    }
 
}
