/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import java.awt.event.KeyListener;

/**
 *
 * @author spock
 */
public interface ControllableView {
    public abstract void switchMode(String type);
    public abstract void toggleMainScreenMode();
    public abstract void refresh();
    public abstract void addKeyListener(KeyListener k);
    public abstract void removeKeyListener(KeyListener k);
}
