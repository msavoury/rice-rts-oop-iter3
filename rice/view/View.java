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
    MSVisitorAcceptor msa;
    boolean first = false;

    private ScreenManager screenManager;

    public View(boolean fs, ViewableModel model, MSVisitorAcceptor msa){
        this.model = model;
        this.msa = msa;
        screenManager = new ScreenManager(fs, this.model, this.msa);
        screenManager.requestFocusInWindow();
    }

    public void refresh(){
        if(!first){
           screenManager.start();
           first = true;
        }
        //long time = System.currentTimeMillis();
        screenManager.refresh();
        //
    }

    public void switchMode(String type){
        screenManager.setMode(type);
    }

    public void toggleMainScreenMode(){
        screenManager.toggleMainScreenMode();
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
