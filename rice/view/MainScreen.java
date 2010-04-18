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

import rice.util.Position;
/**
 *
 * @author spock
 */
class MainScreen extends GameGraphic{
    ViewableModel model;
    MainScreenVisitor msv;
    boolean resourceMode;

    MainScreen(ViewableModel model){
        this.model = model;
        msv = new MainScreenVisitor(25, 25, this.model);
        resourceMode = true;
        msv.preDraw();
        
    }


    void render(GL gl, GLAutoDrawable drawable, TextRenderer render){
        msv.render(gl, drawable, render);
    }

    void auxillaryCommand(String command){
        if(command.equals("Toggle"))
            resourceMode = !resourceMode;
    }

    private class MainScreenVisitor implements MSVisitor{
        ViewableModel model;
        double sideLength = .1;
        ViewableTile[][] map;
        ArrayList<SelfDrawingObject> thingsToDraw;
        int centerx;
        int centery;
        double screenRatio = 1280.0/800.0;
        String hudInfoMode;

        ViewableStructure structure;
        ViewableRallyPoint rallyPoint;
        ViewableUnit unit;


        MainScreenVisitor(int x, int y, ViewableModel model){
            this.model = model;
            thingsToDraw = new ArrayList<SelfDrawingObject>();
            map = new ViewableTile[y][x];
            centerx = -4;
            centery = -2;

        }

        public void visit(ViewableStructure s){
            this.structure = s;
        }
        public void visit(ViewableTile t){
            this.map[t.getLocation().getY()][t.getLocation().getX()] = t;
        }
        public void visit(ViewableRallyPoint p){
            this.rallyPoint = p;
        }
        public void visit(ViewableUnit u){
            this.unit = u;
        }

        void preDraw(){
            if(!resourceMode){
                for(int i = 0; i < map.length; ++i){
                    for(int j = 0; j < map[0].length; ++j){
                        double tileCenterx = (j-centerx)*sideLength*1.5;
                        double tileCentery = (i-centery)*sideLength*Math.sqrt(3)*screenRatio;
                        if(j%2 == 1){
                            tileCentery +=  sideLength*Math.sqrt(3)*screenRatio*.5;
                        }
                        thingsToDraw.add(new SelfDrawingImageHex("iceTest" /*map[i][j].getTerrainType()*/, tileCenterx, tileCentery, screenRatio)); //fixHere
                        if(/*map[i][j].getRallyPoints()!=null*/true){ //fixHere
                            //List<ViewableRallyPoint> rp = map[i][j].getRallyPoints(); //fixHere
                            for(int rpInc = 0; rpInc < /*rp.size()*/10; ++rpInc){
                                //rp.get(rpInc).getStatus();  //fixHere
                                //rp.get(rpInc).getDirection(); //fixHere
                                thingsToDraw.add(new SelfDrawingImage(  "arrowGreenNW", //fixHere
                                                                        tileCenterx + polarX(Math.PI/5*(rpInc), .07) - .016,
                                                                        tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .07)*screenRatio- .016,
                                                                        tileCenterx + polarX(Math.PI/5*(rpInc), .07) + .033- .016,
                                                                        tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .07)*screenRatio+ .033- .016));
                                thingsToDraw.add(new SelfDrawingImage(  "arrowRedS",  //fixHere
                                                                        tileCenterx + polarX(Math.PI/5*(rpInc), .05) - .012,
                                                                        tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .05)*screenRatio- .012,
                                                                        tileCenterx + polarX(Math.PI/5*(rpInc), .05) + .02- .012,
                                                                        tileCentery + (-1)*polarY(Math.PI/5*(rpInc), .05)*screenRatio+ .02- .012));
                            }
                        }
                        if(/*map[i][j].getStructure()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueN", //fixHere
                                                                    tileCenterx - .013,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .013,
                                                                    tileCentery + .013));
                        }
                        if(/*map[i][j].getDecal()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNW", //fixHere
                                                                    tileCenterx - .041,
                                                                    tileCentery - .013,
                                                                    tileCenterx - .015,
                                                                    tileCentery + .013));
                        }
                        if(/*map[i][j].getItem()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNE", //fixHere
                                                                    tileCenterx + .015,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .041,
                                                                    tileCentery + .013));
                        }
                    }
                }
            }
            else{
                for(int i = 0; i < map.length; ++i){
                    for(int j = 0; j < map[0].length; ++j){
                        double tileCenterx = (j-centerx)*sideLength*1.5;
                        double tileCentery = (i-centery)*sideLength*Math.sqrt(3)*screenRatio;
                        if(j%2 == 1){
                            tileCentery +=  sideLength*Math.sqrt(3)*screenRatio*.5;
                        }
                        thingsToDraw.add(new SelfDrawingImageHex("iceTest" /*map[i][j].getTerrainType()*/, tileCenterx, tileCentery, screenRatio)); //fixHere

                   
                        
                        if(/*map[i][j].FOOD()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNW", //fixHere
                                                                    tileCenterx - .055,
                                                                    tileCentery - .102,
                                                                    tileCenterx - .030,
                                                                    tileCentery - .076));
                        }
                        
                        if(/*map[i][j].getItem()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNE", //fixHere
                                                                    tileCenterx + .030,
                                                                    tileCentery - .102,
                                                                    tileCenterx + .055,
                                                                    tileCentery - .076));
                        }
                        
                        if(/*map[i][j].ORE()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueN", //fixHere
                                                                    tileCenterx - .013,
                                                                    tileCentery - .102,
                                                                    tileCenterx + .013,
                                                                    tileCentery - .076));
                        }

                        if(/*map[i][j].getStructure()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueN", //fixHere
                                                                    tileCenterx - .013,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .013,
                                                                    tileCentery + .013));
                        }
                        if(/*map[i][j].getDecal()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNW", //fixHere
                                                                    tileCenterx - .041,
                                                                    tileCentery - .013,
                                                                    tileCenterx - .015,
                                                                    tileCentery + .013));
                        }
                        if(/*map[i][j].getItem()!=null*/true){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNE", //fixHere
                                                                    tileCenterx + .015,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .041,
                                                                    tileCentery + .013));
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
