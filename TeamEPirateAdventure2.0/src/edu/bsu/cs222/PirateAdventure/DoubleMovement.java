package edu.bsu.cs222.PirateAdventure;

import org.json.simple.parser.ParseException;

import java.io.IOException;

class DoubleMovement {
    //initialization of variables
    private int doubleMovementOnShip;
    private int doubleMovement;


    //initialization of objects
    private SpriteText spriteText = new SpriteText();
    private IslandText islandText = new IslandText();

    //methods
    void setDoubleMovement(int x, int y){
        doubleMovementOnShip = doubleMovementOnShip + 1;
        if (doubleMovementOnShip >= 2) {
            spriteText.promptSpriteText(x, y);
            doubleMovementOnShip = 0;
        }
    }

    void setDoubleShipMovement(int x, int y) throws IOException, ParseException {
        doubleMovement = doubleMovement + 1;
        if (doubleMovement >= 2) {
            islandText.promptIslandText(x, y);
            doubleMovement = 0;
        }
    }
}
