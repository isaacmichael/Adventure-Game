package edu.bsu.cs222.PirateAdventure;

import javafx.scene.image.Image;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class SeaPlayer {

//initialization of variables
    public int seaRowMovement = 10;
    public int seaColumnMovement = 10;
    boolean hitCeasarsBayDock = false;
    boolean hitHarborOfBonesDock = false;
    boolean hitOnisIslandDock = false;
    boolean hitIvoryBluffsDock  = false;

//initialization of objects
    private Image boatIconUp = new Image("boatIconUp.png");
    private Image boatIconDown = new Image("boatIconDown.png");
    private Image boatIconLeft = new Image("boatIconLeft.png");
    private Image boatIconRight = new Image("boatIconRight.png");
    private DoubleMovement doubleMove = new DoubleMovement();

    //bounds for movement in sea
    int setSeaRowIndexUp() throws IOException, ParseException {
        //bounds for "Port Comenzar"
        if(seaRowMovement == 4 && (seaColumnMovement == 7 || seaColumnMovement ==8))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }
        //bounds for "Harbor of Bones"
        else if(seaRowMovement == 11 && (seaColumnMovement == 0 || seaColumnMovement == 1))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }
        //bounds for "Caesar's Bay"
        else if(seaRowMovement == 6 && (seaColumnMovement == 15 || seaColumnMovement == 16 || seaColumnMovement == 17))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }
        //bounds for "Oni's Island"
        else if(seaRowMovement == 18 && (seaColumnMovement == 4 || seaColumnMovement == 5))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }

        //bounds for Caesar's Bay dock
        else if(seaRowMovement == 8 && seaColumnMovement == 16)
        {
            hitCeasarsBayDock = true;
            return seaRowMovement;
        }
        //bounds for harbor of bones dock
        else if(seaRowMovement == 11 && seaColumnMovement == 3)
        {
            hitHarborOfBonesDock = true;
            return seaRowMovement;
        }
        //bounds for Oni's island dock
        else if(seaRowMovement == 15 && seaColumnMovement == 4)
        {
            hitOnisIslandDock = true;
            return seaRowMovement;
        }


        //bounds for edge of map
        else if(seaRowMovement>0)
        {
            return seaRowMovement -= 1;
        }
        return seaRowMovement;
    }

    int setSeaRowIndexDown() throws IOException, ParseException {
        //bounds for "Harbor of Bones"
        if(seaRowMovement == 7 && (seaColumnMovement == 0 || seaColumnMovement == 1))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }
        //bounds for "Port Comenzar"
        else if(seaRowMovement == 1 && (seaColumnMovement == 7 || seaColumnMovement == 8))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }
        //bounds for "Caesar's Bay"
        else if(seaRowMovement == 2 && (seaColumnMovement == 15 || seaColumnMovement == 16 || seaColumnMovement == 17))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }
        //bounds for "Ivory Bluffs"
        else if(seaRowMovement == 17 && (seaColumnMovement == 19 || seaColumnMovement == 20))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }
        //bounds for "Oni's island"
        else if(seaRowMovement == 15 && (seaColumnMovement == 4 || seaColumnMovement == 5))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaRowMovement;
        }

        //bounds for Ivory Bluffs dock
        else if(seaRowMovement == 19 && seaColumnMovement == 17)
        {
            hitIvoryBluffsDock = true;
            return seaRowMovement;
        }
        //bounds for harbor of bones dock
        else if(seaRowMovement == 9 && seaColumnMovement == 3)
        {
            hitHarborOfBonesDock = true;
            return seaRowMovement;
        }
        //bounds for Oni's island dock
        else if(seaRowMovement == 13 && seaColumnMovement == 4)
        {
            hitOnisIslandDock = true;
            return seaRowMovement;
        }
        //bounds for edge of map
        else if(seaRowMovement<20)
        {
            return seaRowMovement += 1;
        }
        return seaRowMovement;

    }

    int setSeaColumnIndexLeft() throws IOException, ParseException {
        //bounds for "Port Comenzar"
        if(seaColumnMovement == 9 && (seaRowMovement == 2 || seaRowMovement == 3))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }
        //bounds for "Caesar's bay"
        else if(seaColumnMovement == 18 && (seaRowMovement == 3 || seaRowMovement == 4 || seaRowMovement == 5))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }
        //bounds for "Harbor of bones"
        else if(seaColumnMovement == 2 && (seaRowMovement == 8 || seaRowMovement == 9 || seaRowMovement == 10))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }
        //bounds for "oni's island"
        else if(seaColumnMovement == 6 && (seaRowMovement == 16 || seaRowMovement == 17))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }

        //bounds for Caesar's Bay dock
        else if(seaRowMovement == 7 && seaColumnMovement == 17)
        {
            hitCeasarsBayDock = true;
            return seaColumnMovement;
        }
        //bounds for harbor of bones dock
        else if(seaRowMovement == 10 && seaColumnMovement == 4)
        {
            hitHarborOfBonesDock = true;
            return seaColumnMovement;
        }
        //bounds for Oni's island dock
        else if(seaRowMovement == 14 && seaColumnMovement == 5)
        {
            hitOnisIslandDock = true;
            return seaColumnMovement;
        }

        else if(seaColumnMovement>0){
            return seaColumnMovement -= 1;
        }
        return seaColumnMovement;

    }

    int setSeaColumnIndexRight() throws IOException, ParseException {
        //bounds for "Port Comenzar"
        if(seaColumnMovement == 6 && (seaRowMovement == 2 || seaRowMovement == 3))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }
        //bounds for "Caesar's Bay"
        else if(seaColumnMovement == 14 && (seaRowMovement == 3 || seaRowMovement == 4 || seaRowMovement == 5))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }
        //bounds for "Ivory Bluffs"
        else if(seaColumnMovement == 18 && (seaRowMovement == 18 || seaRowMovement == 19 || seaRowMovement == 20))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }
        //bounds for "Oni's island"
        else if(seaColumnMovement == 3 && (seaRowMovement == 16 || seaRowMovement == 17))
        {
            doubleMove.setDoubleShipMovement(seaRowMovement,seaColumnMovement);
            return seaColumnMovement;
        }

        //bounds for Caesar's Bay dock
        else if(seaRowMovement == 7 && seaColumnMovement == 15)
        {
            hitCeasarsBayDock = true;
            return seaColumnMovement;
        }
        //bounds for Ivory Bluffs dock
        else if(seaRowMovement == 20 && seaColumnMovement == 16)
        {
            hitIvoryBluffsDock = true;
            return seaColumnMovement;
        }
        //bounds for Oni's island dock
        else if(seaRowMovement == 14 && seaColumnMovement == 3)
        {
            hitOnisIslandDock = true;
            return seaColumnMovement;
        }

        else if(seaColumnMovement<20)
        {
            return seaColumnMovement += 1;
        }
        return seaColumnMovement;

    }

//boat sprite changing position
    Image setBoatSpriteUp()
    {
        return boatIconUp;
    }

    Image setBoatSpriteDown()
    {
        return boatIconDown;
    }

    Image setBoatSpriteLeft()
    {
        return boatIconLeft;
    }

    Image setBoatSpriteRight()
    {
        return boatIconRight;
    }

}
