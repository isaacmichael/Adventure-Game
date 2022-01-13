package edu.bsu.cs222.PirateAdventure;

import javafx.fxml.FXML;
import org.json.simple.parser.ParseException;

import java.io.IOException;

class IslandText {
    @FXML
    void promptIslandText(int x,int y) throws IOException, ParseException {
        SeaSceneController scene = new SeaSceneController();
        scene.setScene(x,y);
        System.out.println(scene.getSceneText());

    }
}
