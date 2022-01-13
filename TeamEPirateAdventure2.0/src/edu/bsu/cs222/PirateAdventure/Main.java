package edu.bsu.cs222.PirateAdventure;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

//opens the window for game
    @Override
    public void start(Stage primaryStage) throws Exception {
        Supplies supplies = new Supplies();
        supplies.addFoodSupplies(50);
        supplies.addCrewSupplies(50);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pirate Adventure");
        primaryStage.getIcons().add(new Image("PirateAdventureIcon.PNG"));
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }



    public static void main(String[] args) {
            launch(args);
    }
}
