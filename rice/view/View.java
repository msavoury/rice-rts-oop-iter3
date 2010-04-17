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
public class View implements ControllableView{

    ViewableModel model;
    private ScreenManager screenManager;

    public View(boolean fs, ViewableModel model){
        this.model = model;
        screenManager = new ScreenManager(fs, this.model);
        screenManager.requestFocusInWindow();
    }

    public void refresh(){
    }

    public void switchMode(String type){
        screenManager.setMode(type);
    }

    public void setModel(ViewableModel model){
        this.model = model;
    }

    public void addKeyListener(KeyListener k){
        screenManager.addKeyListener(k);
    }


    public void removeKeyListener(KeyListener k){
        screenManager.removeKeyListener(k);
    }

}
