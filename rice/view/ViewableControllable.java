/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

/**
 *
 * @author spock
 */
public interface ViewableControllable extends ViewableLocatable{
    
    public abstract String getCommand();
    public abstract String getAbility();
    public abstract String getStatus();
    public abstract int getID();
}
