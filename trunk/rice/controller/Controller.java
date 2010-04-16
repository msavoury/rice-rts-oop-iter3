/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.ArrayList;

import rice.model.Model;
import rice.view.View;
/**
 *
 * @author spock
 */
public class Controller implements ActionListener{

       Timer t;
       Model model;
       ArrayList<View> views = new ArrayList<View>();


       public Controller(){
           t = new Timer(1000, this);
       }

       public void start(){
           t.start();
       }

       public void registerModel(Model model){
           this.model = model;
       }

       public void registerView(View view){
           views.add(view);
       }

       public void actionPerformed(ActionEvent e){
           model.tick();
           for(View v: views){
               v.refresh();
           }
           System.out.println("Tick");
       }

}
