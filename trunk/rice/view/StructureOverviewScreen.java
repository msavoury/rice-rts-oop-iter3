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
class StructureOverviewScreen extends GameGraphic{
    ViewableModel model;
    StructureOverviewVisitor sov;
    List<ViewableStructure> structureList;

    StructureOverviewScreen(ViewableModel model){
        this.model = model;
        sov = new StructureOverviewVisitor(this.model);
    }

    void refresh(){
        structureList = model.getAllStructures();
        sov.preDraw();

    }

    void render(GL gl, GLAutoDrawable drawable, TextRenderer render){

        sov.render(gl, drawable, render);

    }

    private class StructureOverviewVisitor implements SOVisitor{

        ViewableModel model;
        int selectedIndex;
        ArrayList<SelfDrawingObject> thingsToDraw;




        StructureOverviewVisitor(ViewableModel model){

            this.model = model;
            thingsToDraw = new ArrayList<SelfDrawingObject>();
            selectedIndex = 1;

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
                thingsToDraw.add(new SelfDrawingText("HP",
                                                     0.20,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Arm",
                                                     0.27,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Atk",
                                                     0.33,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Def",
                                                     0.40,
                                                     .036 + 26 *.035));
                thingsToDraw.add(new SelfDrawingText("Status",
                                                     0.50,
                                                     .036 + 26 *.035));



            int g = 0;
            if(structureList!=null){
                g = structureList.size();
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
                thingsToDraw.add(new SelfDrawingText(structureList.get(i).getType(),
                                                     0.06,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(structureList.get(i).getID()+"",
                                                     0.15,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText((int)(structureList.get(i).getHealth()*100)+"",
                                                     0.20,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(structureList.get(i).getArmor() + "",
                                                     0.27,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(structureList.get(i).getAttack() + "",
                                                     0.33,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(structureList.get(i).getDefense() + "",
                                                     0.40,
                                                     .036 + (24-i) *.035));

                thingsToDraw.add(new SelfDrawingText(structureList.get(i).getStatus(),
                                                     0.50,
                                                     .036 + (24-i) *.035));

            }



        }

        void render(GL gl, GLAutoDrawable drawable, TextRenderer render){
            for(SelfDrawingObject sdo: thingsToDraw){
                sdo.draw(gl, drawable, render);
            }
        }

        public void visit(ViewableStructure u){
            //not used, sadface.jpeg
        }

    }

}
