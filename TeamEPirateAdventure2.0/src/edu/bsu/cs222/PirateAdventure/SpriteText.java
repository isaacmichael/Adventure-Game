package edu.bsu.cs222.PirateAdventure;

import javafx.fxml.FXML;

class SpriteText {

//methods
    @FXML
    void promptSpriteText(int x,int y) {
        SceneController scene = new SceneController();
        scene.setScene(x,y);
    }
}
