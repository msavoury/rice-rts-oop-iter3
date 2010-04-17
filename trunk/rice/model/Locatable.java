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

    public String getTypeName() {
        return typeName;
    }
}
