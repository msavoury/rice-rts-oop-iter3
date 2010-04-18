/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import util.Position;

/**
 *
 * @author spock
 */
public interface ViewableLocatable extends Viewable{
    public abstract Position getLocation();
}
