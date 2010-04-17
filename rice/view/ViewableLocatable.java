/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import java.awt.Dimension;

/**
 *
 * @author spock
 */
public interface ViewableLocatable extends Viewable{
    public abstract Dimension getLocatiom();
}
