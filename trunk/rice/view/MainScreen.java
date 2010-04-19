/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rice.view;

import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
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
        if(vm.getActionTiles()!=null){
            highlights = vm.getActionTiles();
            if(highlights.size()>0 && highlights.get(highlights.size()-1)!=null)
                msv.setCenter(highlights.get(highlights.size()-1).getX(), highlights.get(highlights.size()-1).getY());
        }
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
        int acx;
        int acy;
        double screenRatio = 1280.0/800.0;
        String hudInfoMode;

        ViewableStructure structure;
        ViewableRallyPoint rallyPoint;
        ViewableUnit unit;


        MainScreenVisitor(int x, int y, ViewableModel model){
            this.model = model;
            thingsToDraw = new ArrayList<SelfDrawingObject>();
            map = new ViewableTile[y][x];

            acx = 0;
            acy = 0;
            
            centerx = acx-3;
            centery = acy-1;



        }

        void setCenter(int x, int y){
            acx = x;
            acy = y;
            centerx = acx-3;
            centery = acy-1;
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
                            thingsToDraw.add(new SelfDrawingImageHex(/*"iceTest"*/ map[i][j].getTerrainType(), tileCenterx, tileCentery, screenRatio, map[i][j].getVisibilityMode()));
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

                        if(map[i][j].getTerrainType()!= null){
                            thingsToDraw.add(new SelfDrawingImageHex(/*"iceTest"*/ map[i][j].getTerrainType(), tileCenterx, tileCentery, screenRatio, map[i][j].getVisibilityMode()));
                        }
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
                         //System.out.println(map[i][j].getBreedingWorkers());
                        if(map[i][j].getBreedingWorkers()>0/*true*/){ //fixHere
                            System.out.println(map[i][j].getBreedingWorkers());
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
                            Integer idle = /*6457*/map[i][j].getIdleWorkers();
                            String fo = idle.toString();
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
                if(highlights.get(h)!=null){
                    double tileCenterx = (highlights.get(h).getX()-centerx)*sideLength*1.5;
                    double tileCentery = (highlights.get(h).getY()-centery)*sideLength*Math.sqrt(3)*screenRatio;
                    if(highlights.get(h).getX()%2 == 1){
                            tileCentery +=  sideLength*Math.sqrt(3)*screenRatio*.5;
                    }
                    thingsToDraw.add(new SelfDrawingHexHighlight(tileCenterx, tileCentery, screenRatio));
                }
            }


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
            if(vm.getCurrentlySelectedInstance()!=null){
                thingsToDraw.add(new SelfDrawingText(  /*"Colonist 1"*/vm.getCurrentlySelectedInstance().getType() + vm.getCurrentlySelectedInstance().getID(), //comm3
                                                        1-.12,
                                                        1-.08125*3 + .035));
            }

            //ABILITY BOX
            thingsToDraw.add(new SelfDrawingImage(  "marblecake", //comm4
                                                    1-.15626,
                                                    0+.08125*3,
                                                    1,
                                                    .08125*4));
            if(vm.getCurrentlySelectedInstance()!=null){
                thingsToDraw.add(new SelfDrawingText(  /*"Ability"*/ vm.getCurrentlySelectedInstance().getAbility(), //comm4
                                                        1-.12,
                                                        1-.08125*4 + .035));
            }

            //STATUS BOX
            thingsToDraw.add(new SelfDrawingImage(  "marblecake", //comm5
                                                    1-.15626,
                                                    0+.08125*4,
                                                    1,
                                                    .08125*5));
            if(vm.getCurrentlySelectedInstance()!=null){
                thingsToDraw.add(new SelfDrawingText(  /*"Status"*/ vm.getCurrentlySelectedInstance().getStatus(), //comm5
                                                        1-.12,
                                                        1-.08125*5 + .035));
            }


            if(vm.getCurrentSelectorPathToInstance().get(0)!=null){
                /*for(int i = 0; i < 26; ++i){
                    if(i < 13){
                        thingsToDraw.add(new SelfDrawingImage(  "cat",
                                                                .22 + i * .035,
                                                                .86 ,
                                                                .245 + i * .035,
                                                                .90));
                        thingsToDraw.add(new SelfDrawingBar(    .22 + i * .035,
                                                                .90 ,
                                                                .245 + i * .035,
                                                                .91,
                                                                Color.GREEN,
                                                                Color.WHITE));
                    }
                    else{
                        thingsToDraw.add(new SelfDrawingImage(  "cat",
                                                                .22 + (i-13) * .035,
                                                                .93 ,
                                                                .245 + (i-13) * .035,
                                                                .97));
                        thingsToDraw.add(new SelfDrawingBar(    .22 + (i-13) * .035,
                                                                .97 ,
                                                                .245 + (i-13) * .035,
                                                                .98,
                                                                Color.GREEN,
                                                                Color.WHITE));
                    }

                }*/
                if(vm.getCurrentSelectorPathToInstance().get(0).equals("Structure") && vm.getCurrentlySelectedStructure()!=null){
                    thingsToDraw.add(new SelfDrawingText("Atk: " + vm.getCurrentlySelectedStructure().getAttack(),
                                                             0.81,
                                                             .028 + 4 *.035));
                    thingsToDraw.add(new SelfDrawingText("Def: " + vm.getCurrentlySelectedStructure().getDefense(),
                                                             0.81,
                                                             .028 + 3 *.035));
                    thingsToDraw.add(new SelfDrawingText("Arm: " + vm.getCurrentlySelectedStructure().getArmor(),
                                                             0.81,
                                                             .028 + 2 *.035));
                    thingsToDraw.add(new SelfDrawingImage(  "cat",
                                                                .22 + .035,
                                                                .86 ,
                                                                .245 + .035,
                                                                .90));
                    thingsToDraw.add(new SelfDrawingBar(    .22 + .035,
                                                            .90 ,
                                                            .22 + .035 + ((.245 + .035)-(.22 + .035))*vm.getCurrentlySelectedStructure().getHealth(),
                                                            .91,
                                                            Color.GREEN,
                                                            Color.WHITE));
                }
                if(vm.getCurrentSelectorPathToInstance().get(0).equals("Rally") && vm.getCurrentlySelectedRallyPoint()!=null){
                    thingsToDraw.add(new SelfDrawingText("Atk: " + vm.getCurrentlySelectedRallyPoint().getAttack(),
                                                             0.81,
                                                             .028 + 4 *.035));
                    thingsToDraw.add(new SelfDrawingText("Def: " + vm.getCurrentlySelectedRallyPoint().getDefense(),
                                                             0.81,
                                                             .028 + 3 *.035));
                    thingsToDraw.add(new SelfDrawingText("Spd: " + vm.getCurrentlySelectedRallyPoint().getSpeed(),
                                                             0.81,
                                                             .028 + 2 *.035));
                    List<ViewableUnit> units = vm.getCurrentlySelectedRallyPoint().getAllUnits();
                    for(int i = 0; i < units.size(); ++i){
                        if(i < 13){
                            thingsToDraw.add(new SelfDrawingImage(  units.get(i).getType(),
                                                                    .22 + i * .035,
                                                                    .86 ,
                                                                    .245 + i * .035,
                                                                    .90));
                            thingsToDraw.add(new SelfDrawingBar(    .22 + i * .035,
                                                                    .90 ,
                                                                    .22 + i * .035 + ((.245 + i * .035) - (.22 + i * .035))*units.get(i).getHealth(),
                                                                    .91,
                                                                    Color.GREEN,
                                                                    Color.WHITE));
                        }
                        else{
                            thingsToDraw.add(new SelfDrawingImage(  units.get(i).getType(),
                                                                    .22 + (i-13) * .035,
                                                                    .93 ,
                                                                    .245 + (i-13) * .035,
                                                                    .97));
                            thingsToDraw.add(new SelfDrawingBar(    .22 + (i-13) * .035,
                                                                    .97 ,
                                                                    .22 + (i-13) * .035 + ((.245 + (i-13) * .035) - (.22 + (i-13) * .035))*units.get(i).getHealth(),
                                                                    .98,
                                                                    Color.GREEN,
                                                                    Color.WHITE));
                        }

                    }

                }
                if(vm.getCurrentSelectorPathToInstance().get(0).equals("Unit") && vm.getCurrentlySelectedUnit()!=null){
                    thingsToDraw.add(new SelfDrawingText("x " + vm.getCurrentlySelectedUnit().getLocation().getX() + " y " + vm.getCurrentlySelectedUnit().getLocation().getY(),
                                                             0.81,
                                                             .028 + 5 *.035));
                    thingsToDraw.add(new SelfDrawingText("Atk: " + vm.getCurrentlySelectedUnit().getAttack(),
                                                             0.81,
                                                             .028 + 4 *.035));
                    thingsToDraw.add(new SelfDrawingText("Def: " + vm.getCurrentlySelectedUnit().getDefense(),
                                                             0.81,
                                                             .028 + 3 *.035));
                    thingsToDraw.add(new SelfDrawingText("Arm: " + vm.getCurrentlySelectedUnit().getArmor(),
                                                             0.81,
                                                             .028 + 2 *.035));
                    thingsToDraw.add(new SelfDrawingText("Spd: " + vm.getCurrentlySelectedUnit().getSpeed(),
                                                             0.81,
                                                             .028 + 1 *.035));
                    thingsToDraw.add(new SelfDrawingText("Sze: " + vm.getCurrentlySelectedUnit().getSize(),
                                                             0.81,
                                                             .028 + 0 *.035));
                    thingsToDraw.add(new SelfDrawingImage(  "cat",
                                                                .22 + .035,
                                                                .86 ,
                                                                .245 + .035,
                                                                .90));
                    thingsToDraw.add(new SelfDrawingBar(    .22 + .035,
                                                            .90 ,
                                                            .22 + .035 + ((.245 + .035)-(.22 + .035))*vm.getCurrentlySelectedUnit().getHealth(),
                                                            .91,
                                                            Color.GREEN,
                                                            Color.WHITE));
                }
            }
            /*if()
            thingsToDraw.add(new SelfDrawingImage(  ));*/

            //thingsToDraw.add(new SelfDrawingText())

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
