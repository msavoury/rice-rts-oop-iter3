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

    UnitOverviewScreen(ViewableModel model){
        this.model = model;
        uov = new UnitOverviewVisitor(this.model);
    }

    void refresh(){

        uov.preDraw();

    }

    void render(GL gl, GLAutoDrawable drawable, TextRenderer render){

        uov.render(gl, drawable, render);

    }

    private class UnitOverviewVisitor implements UOVisitor{

        ViewableModel model;
        int selectedIndex;
        ArrayList<SelfDrawingObject> thingsToDraw;


        List<ViewableUnit> unitList;

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
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingBar(.05,
                                                    .10 + i * .035,
                                                    .95,
                                                    .135 + i * .035,
                                                    Color.BLUE,
                                                    Color.GREEN));
                
            }

            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("UnitName  ID  Owner  h10  ar10  at10  de99 si34  sp20  status",
                                                     0.06,
                                                     .036 + i *.035));

            }
            thingsToDraw.add(new SelfDrawingBar(.05,
                                                .10 + selectedIndex * .035,
                                                .95,
                                                .135 + selectedIndex * .035,
                                                new Color(255, 255, 0, 30),
                                                Color.GREEN));
            /*
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("UnitName",
                                                     0.06,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("ID",
                                                     0.15,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("Owner",
                                                     0.20,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("h10",
                                                     0.30,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("ar10",
                                                     0.37,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("at10",
                                                     0.43,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("de99",
                                                     0.50,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("si34",
                                                     0.60,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("sp20",
                                                     0.70,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
            for(int i = 0; i < 25; ++i){
                thingsToDraw.add(new SelfDrawingText("status",
                                                     0.80,
                                                     .036 + i *.035,
                                                     "Serif",
                                                     22));

            }
             * 
             */
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
