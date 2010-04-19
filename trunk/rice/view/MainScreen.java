/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import com.sun.opengl.util.j2d.TextRenderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import rice.util.Position;

/**
 *
 * @author spock
 */
class MainScreen extends GameGraphic{
    ViewableModel vm;
    MSVisitorAcceptor msa;
    MainScreenVisitor msv;
    boolean resourceMode;
    private List<Position> highlights;

    MainScreen(MSVisitorAcceptor model, ViewableModel vm, Position size){
        this.msa = model;
        this.vm = vm;
        msv = new MainScreenVisitor(size.getX(), size.getY(), vm);
        resourceMode = false;
        //msv.preDraw();
        
    }


    void render(GL gl, GLAutoDrawable drawable, TextRenderer render){
        msv.render(gl, drawable, render);
    }

    void refresh(){
        if(msa == null){
            System.out.println("msa not here");
        }
        if(msv == null){
            System.out.println("msv not here");
        }
        msa.accept(msv);
        highlights = vm.getActionTiles();
        msv.preDraw();
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
            centerx = 0;
            centery = 0;

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
            //thingsToDraw = new ArrayList<SelfDrawingObject>();
            thingsToDraw.clear();
            if(!resourceMode){
                for(int i = 0; i < map.length; ++i){
                    for(int j = 0; j < map[0].length; ++j){
                        double tileCenterx = (j-centerx)*sideLength*1.5;
                        double tileCentery = (i-centery)*sideLength*Math.sqrt(3)*screenRatio;
                        if(j%2 == 1){
                            tileCentery +=  sideLength*Math.sqrt(3)*screenRatio*.5;
                        }
                        if(map[i][j].getTerrainType()!= null){
                            thingsToDraw.add(new SelfDrawingImageHex(/*"iceTest"*/ map[i][j].getTerrainType(), tileCenterx, tileCentery, screenRatio));
                        }//fixHere
                        if(map[i][j].getRallyPoints()!=null/*true*/){ //fixHere
                            List<ViewableRallyPoint> rp = map[i][j].getRallyPoints(); //fixHere
                            for(int rpInc = 0; rpInc < rp.size()/*10*/; ++rpInc){
                                rp.get(rpInc).getStatus();  //fixHere
                                rp.get(rpInc).getDirection(); //fixHere
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
                        if(map[i][j].getStructure()!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueN", //fixHere
                                                                    tileCenterx - .013,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .013,
                                                                    tileCentery + .013));
                        }
                        if(map[i][j].getDecal()!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNW", //fixHere
                                                                    tileCenterx - .041,
                                                                    tileCentery - .013,
                                                                    tileCenterx - .015,
                                                                    tileCentery + .013));
                        }
                        if(map[i][j].getItem()!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNE", //fixHere
                                                                    tileCenterx + .015,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .041,
                                                                    tileCentery + .013));
                        }
                        if(map[i][j].getNumUnitsNotInRP()>0/*true*/){

                            Integer numUnits = /*5589*/map[i][j].getNumUnitsNotInRP();
                            String fo = numUnits.toString();
                            for(int b = 0; b < fo.length(); ++b){
                                thingsToDraw.add(new SelfDrawingImage(  fo.charAt(b) + "", //fixHere
                                                                    tileCenterx - .021 + b*.008,
                                                                    tileCentery - .055,
                                                                    tileCenterx - .011 + b*.008,
                                                                    tileCentery - .035));
                            }

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
                        thingsToDraw.add(new SelfDrawingImageHex(/*"iceTest"*/ map[i][j].getTerrainType(), tileCenterx, tileCentery, screenRatio)); //fixHere

                        HashMap<String, Integer> resc = map[i][j].getResourceValues(); //fixHere

                        if(resc.get("Food")!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNW", //fixHere
                                                                    tileCenterx - .055,
                                                                    tileCentery - .102,
                                                                    tileCenterx - .030,
                                                                    tileCentery - .076));
                            Integer food = /*1234*/resc.get("Food");
                            String fo = food.toString();
                            for(int b = 0; b < fo.length(); ++b){
                                thingsToDraw.add(new SelfDrawingImage(  fo.charAt(b) + "", //fixHere
                                                                    tileCenterx - .070 + b*.008,
                                                                    tileCentery - .070,
                                                                    tileCenterx - .060 + b*.008,
                                                                    tileCentery - .050));
                            }

                        }
                        
                        if(resc.get("Energy")!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueNE", //fixHere
                                                                    tileCenterx + .030,
                                                                    tileCentery - .102,
                                                                    tileCenterx + .055,
                                                                    tileCentery - .076));
                            Integer energy = /*6473*/resc.get("Energy");
                            String fo = energy.toString();
                            for(int b = 0; b < fo.length(); ++b){
                                thingsToDraw.add(new SelfDrawingImage(  fo.charAt(b) + "", //fixHere
                                                                    tileCenterx + .025 + b*.008,
                                                                    tileCentery - .070,
                                                                    tileCenterx + .035 + b*.008,
                                                                    tileCentery - .050));
                            }
                        }
                        
                        if(resc.get("Ore")!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueN", //fixHere
                                                                    tileCenterx - .013,
                                                                    tileCentery - .102,
                                                                    tileCenterx + .013,
                                                                    tileCentery - .076));
                            Integer ore = /*5589*/resc.get("Ore");
                            String fo = ore.toString();
                            for(int b = 0; b < fo.length(); ++b){
                                thingsToDraw.add(new SelfDrawingImage(  fo.charAt(b) + "", //fixHere
                                                                    tileCenterx - .021 + b*.008,
                                                                    tileCentery - .070,
                                                                    tileCenterx - .011 + b*.008,
                                                                    tileCentery - .050));
                            }
                        }

                        if(map[i][j].getHarvestingResource()!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueN", //fixHere
                                                                    tileCenterx - .013,
                                                                    tileCentery + .035,
                                                                    tileCenterx + .013,
                                                                    tileCentery + .061));
                            Integer workers = /*6457*/map[i][j].getHarvestingWorkers();
                            String fo = workers.toString();
                            for(int b = 0; b < fo.length(); ++b){
                                thingsToDraw.add(new SelfDrawingImage(  fo.charAt(b) + "", //fixHere
                                                                    tileCenterx - .021 + b*.008,
                                                                    tileCentery + .067,
                                                                    tileCenterx - .011 + b*.008,
                                                                    tileCentery + .087));
                            }
                        }

                        if(map[i][j].getStructure()!=null/*true*/){ //fixHere
                            thingsToDraw.add(new SelfDrawingImage(  "arrowBlueN", //fixHere
                                                                    tileCenterx - .013,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .013,
                                                                    tileCentery + .013));
                        }
                        if(map[i][j].getBreedingWorkers()>0/*true*/){ //fixHere
                            Integer breeding = /*6457*/map[i][j].getBreedingWorkers();
                            String fo = breeding.toString();
                            for(int b = 0; b < fo.length(); ++b){
                                thingsToDraw.add(new SelfDrawingImage(  fo.charAt(b) + "", //fixHere
                                                                    tileCenterx - .056 + b*.008,
                                                                    tileCentery - .013,
                                                                    tileCenterx - .046 + b*.008,
                                                                    tileCentery + .010));
                            }
                        }
                        if(map[i][j].getIdleWorkers()>0/*true*/){ //fixHere
                            Integer breeding = /*6457*/map[i][j].getBreedingWorkers();
                            String fo = breeding.toString();
                            for(int b = 0; b < fo.length(); ++b){
                                thingsToDraw.add(new SelfDrawingImage(  fo.charAt(b) + "", //fixHere
                                                                    tileCenterx + .030 + b*.008,
                                                                    tileCentery - .013,
                                                                    tileCenterx + .040 + b*.008,
                                                                    tileCentery + .010));
                            }
                        }
                    }
                }
            }


            //FIX HEERRRREEE
            for(int h = 0; h < highlights.size(); ++h){
                double tileCenterx = (highlights.get(h).getX()-centerx)*sideLength*1.5;
                double tileCentery = (highlights.get(h).getY()-centery)*sideLength*Math.sqrt(3)*screenRatio;
                thingsToDraw.add(new SelfDrawingHexHighlight(tileCenterx, tileCentery, screenRatio));

            }

            /*for(int v = 0; v< vm.getCurrentSelectorPathToInstance().size(); ++v){
                System.out.println(vm.getCurrentSelectorPathToInstance().get(v));
            }*/

            thingsToDraw.add(new SelfDrawingImage( "hud",
                                                   0,
                                                   .75,
                                                   1,
                                                   1));

            //MODE BOX
            thingsToDraw.add(new SelfDrawingImage(  "marblecake", //comm1
                                                    1-.15626,
                                                    0,
                                                    1,
                                                    .08125));
            if(vm.getCurrentSelectorPathToInstance().get(0)!=null){
                thingsToDraw.add(new SelfDrawingText(  /*"Mode"*/ vm.getCurrentSelectorPathToInstance().get(0), //comm1
                                                        1-.12,
                                                        1-.08125 + .035));
            }

            //TYPE BOX
            thingsToDraw.add(new SelfDrawingImage(  "marblecake", //comm2
                                                    1-.15626,
                                                    0+.08125*1,
                                                    1,
                                                    .08125*2));
            if(vm.getCurrentSelectorPathToInstance().size()>1){
                thingsToDraw.add(new SelfDrawingText(  /*"Type"*/vm.getCurrentSelectorPathToInstance().get(1), //comm2
                                                        1-.12,
                                                        1-.08125*2 + .035));
            }

            //INSTANCE BOX
            thingsToDraw.add(new SelfDrawingImage(  "marblecake", //comm3
                                                    1-.15626,
                                                    0+.08125*2,
                                                    1,
                                                    .08125*3));
            thingsToDraw.add(new SelfDrawingText(  /*"Colonist 1"*/vm.getCurrentlySelectedInstance().getType() + vm.getCurrentlySelectedInstance().getID(), //comm3
                                                    1-.12,
                                                    1-.08125*3 + .035));

            //ABILITY BOX
            thingsToDraw.add(new SelfDrawingImage(  "marblecake", //comm4
                                                    1-.15626,
                                                    0+.08125*3,
                                                    1,
                                                    .08125*4));
            thingsToDraw.add(new SelfDrawingText(  /*"Ability"*/ vm.getCurrentlySelectedInstance().getAbility(), //comm4
                                                    1-.12,
                                                    1-.08125*4 + .035));

            //STATUS BOX
            thingsToDraw.add(new SelfDrawingImage(  "marblecake", //comm5
                                                    1-.15626,
                                                    0+.08125*4,
                                                    1,
                                                    .08125*5));
            thingsToDraw.add(new SelfDrawingText(  /*"Status"*/ vm.getCurrentlySelectedInstance().getStatus(), //comm5
                                                    1-.12,
                                                    1-.08125*5 + .035));

            /*if()
            thingsToDraw.add(new SelfDrawingImage(  ));*/
            

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
