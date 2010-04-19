/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author spock
 */
class UnitOverviewScreen extends GameGraphic{
    ViewableModel model;
    UnitOverviewVisitor uov;
    List<ViewableUnit> unitList;

    UnitOverviewScreen(ViewableModel model){
        this.model = model;
        uov = new UnitOverviewVisitor(this.model);
    }

    void refresh(){
        unitList = model.getAllUnits();
        uov.preDraw();

    }

    void render(GL gl, GLAutoDrawable drawable, TextRenderer render){

        uov.render(gl, drawable, render);

    }

    private class UnitOverviewVisitor implements UOVisitor{

        ViewableModel model;
        int selectedIndex;
        ArrayList<SelfDrawingObject> thingsToDraw;


        

        UnitOverviewVisitor(ViewableModel model){

            this.model = model;
            thingsToDraw = new ArrayList<SelfDrawingObject>();
            selectedIndex = 5;

        }

        void preDraw(){
            //thingsToDraw = new ArrayList<SelfDrawingObject>();
            thingsToDraw.clear();

            thingsToDraw.add(new SelfDrawingImage(  "marblecake",
                                                    0,
                                                    0,
                                                    1,
                                                    1));


                thingsToDraw.add(new SelfDrawingText("Type",
                                                     0.06,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("ID",
                                                     0.15,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Owner",
                                                     0.20,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("HP",
                                                     0.30,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Arm",
                                                     0.37,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Atk",
                                                     0.43,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Def",
                                                     0.50,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Size",
                                                     0.60,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Spd",
                                                     0.70,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Status",
                                                     0.80,
                                                     .036 + 26 *.035));



            int g = 0;
            if(unitList!=null){
                g = unitList.size();
            }

            for(int i = 0; i < g; ++i){
                thingsToDraw.add(new SelfDrawingBar(.05,
                                                    .10 + i * .035,
                                                    .95,
                                                    .135 + i * .035,
                                                    Color.BLUE,
                                                    Color.GREEN));
                
            }

            thingsToDraw.add(new SelfDrawingBar(.05,
                                                .10 + selectedIndex * .035,
                                                .95,
                                                .135 + selectedIndex * .035,
                                                new Color(0, 255, 255, 255),
                                                Color.GREEN));
            
            for(int i = 0; i < g; ++i){
                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getType(),
                                                     0.06,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getID()+"",
                                                     0.15,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getViewableUnitOwner(),
                                                     0.20,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText((int)(unitList.get(i).getHealth()*100)+"",
                                                     0.30,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getArmor() + "",
                                                     0.37,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getAttack() + "",
                                                     0.43,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getDefense() + "",
                                                     0.50,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getSize() + "",
                                                     0.60,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getSpeed() + "",
                                                     0.70,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(unitList.get(i).getStatus(),
                                                     0.80,
                                                     .036 + (24-i) *.035));

            }

            
            
        }

        void render(GL gl, GLAutoDrawable drawable, TextRenderer render){
            for(SelfDrawingObject sdo: thingsToDraw){
                sdo.draw(gl, drawable, render);
            }
        }

        public void visit(ViewableUnit u){
            //not used, sadface.jpeg
        }

    }

}
