/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;
import rice.util.Position;


/**
 *
 * @author spock
 */
public interface ViewableControllable extends Viewable{
    public abstract Position getLocation();
    public abstract String getCommand();
    public abstract String getStatus();
}
