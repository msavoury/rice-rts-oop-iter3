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
                            /*thingsToDraw.add(new SelfDrawingImage(  "testArrow",
                                                                    tileCenterx ,
                                                                    tileCentery ,
                                                                    tileCenterx + .03,
                                                                    tileCentery + .03));*/
                            thingsToDraw.add(new SelfDrawingImage(  "testArrow",
                                                                    tileCenterx + .015*polarX(Math.PI/5*(rpInc), .1),
                                                                    tileCentery + (-1)*.015*polarY(Math.PI/5*(rpInc), .1),
                                                                    tileCenterx + .015*polarX(Math.PI/5*(rpInc), .1) + .033,
                                                                    tileCentery + (-1)*.015*polarY(Math.PI/5*(rpInc), .1)+ .033));
                            System.out.println(tileCenterx + .015*polarX(Math.PI/5*(rpInc), .1));
                            System.out.println(tileCentery + (-1)*.015*polarY(Math.PI/5*(rpInc), .1));

                            /*
                             * graphix.drawImage(graphicsT.getGraphic(imageArrow), centerX + (int)polarX(Math.PI/5*(i), 65.0)-spacing,
                                  centerY + (-1)*(int)polarY(Math.PI/5*(i), 70.0)-spacing, null);
                                graphix.setColor(Color.WHITE);
                                graphix.drawString(""+rallyPoints.get(i).rallyPoint(), centerX + (int)polarX(Math.PI/5*(i), 50.0),
                                  centerY + (-1)*(int)polarY(Math.PI/5*(i), 50.0));
                             */

                        }
                    }

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
