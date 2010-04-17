/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import com.sun.opengl.util.j2d.TextRenderer;
import java.util.ArrayList;
import java.util.List;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author spock
 */
class MainScreen extends GameGraphic{
    ViewableModel model;
    MainScreenVisitor msv;

    MainScreen(ViewableModel model){
        this.model = model;
        msv = new MainScreenVisitor(25, 25, this.model);
        msv.preDraw();
        
    }


    void render(GL gl, GLAutoDrawable drawable, TextRenderer render){
        msv.render(gl, drawable, render);
    }

    private class MainScreenVisitor implements MSVisitor{
        ViewableModel model;
        double sideLength = .1;
        ViewableTile[][] map;
        ArrayList<SelfDrawingObject> thingsToDraw;
        int centerx;
        int centery;
        double screenRatio = 1280.0/800.0;

        MainScreenVisitor(int x, int y, ViewableModel model){
            this.model = model;
            thingsToDraw = new ArrayList<SelfDrawingObject>();
            map = new ViewableTile[y][x];
            centerx = -4;
            centery = -2;

        }

        public void visit(ViewableStructure s){

        }
        public void visit(ViewableTile t){

        }
        public void visit(ViewableRallyPoint p){

        }
        public void visit(ViewableUnit u){

        }

        void preDraw(){

            for(int i = 0; i < map.length; ++i){
                for(int j = 0; j < map[0].length; ++j){
                    double tileCenterx = (j-centerx)*sideLength*1.5;
                    double tileCentery = (i-centery)*sideLength*Math.sqrt(3)*screenRatio;
                    if(j%2 == 1){
                        tileCentery +=  sideLength*Math.sqrt(3)*screenRatio*.5;
                    }
                    thingsToDraw.add(new SelfDrawingImageHex("iceTest" /*map[i][j].getTerrainType()*/, tileCenterx, tileCentery, screenRatio));
                    if(/*map[i][j].getRallyPoints()!=null*/true){
                        //List<ViewableRallyPoint> rp = map[i][j].getRallyPoints();
                        for(int rpInc = 0; rpInc < /*rp.size()*/10; ++rpInc){
                            //rp.get(rpInc).getStatus();
                            //rp.get(rpInc).getDirection();
                            thingsToDraw.add(new SelfDrawingImage(  "arrowGreenNW",
                                                                    tileCenterx + polarX(Math.PI/5*(rpInc), .07) - .016,
                                                                    tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .07)*screenRatio- .016,
                                                                    tileCenterx + polarX(Math.PI/5*(rpInc), .07) + .033- .016,
                                                                    tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .07)*screenRatio+ .033- .016));
                            thingsToDraw.add(new SelfDrawingImage(  "arrowRedS",
                                                                    tileCenterx + polarX(Math.PI/5*(rpInc), .05) - .012,
                                                                    tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .05)*screenRatio- .012,
                                                                    tileCenterx + polarX(Math.PI/5*(rpInc), .05) + .02- .012,
                                                                    tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .05)*screenRatio+ .02- .012));
                        }
                    }
                    /*if(map[i][j].getStructure()!=null){
                        //thingsToDraw.add();
                    }*/
                }
            }
        }

        private double polarX(double angle, double length){
            return length * Math.cos(angle);
        }
        private double polarY(double angle, double length){
            return length * Math.sin(angle);
        }

        void render(GL gl, GLAutoDrawable drawable, TextRenderer render){

            for(SelfDrawingObject sdo: thingsToDraw){
                sdo.draw(gl, drawable, render);
            }

        }

    }

}
