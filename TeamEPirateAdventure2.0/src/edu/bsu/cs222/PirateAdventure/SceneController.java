package edu.bsu.cs222.PirateAdventure;

import javafx.scene.text.Text;
import org.json.simple.parser.ParseException;

import java.io.IOException;

//private String sceneNumber;
public class SceneController {
    private static String sceneNumber;

//initialization of variables


//methods
    String getSceneNumber(){
        return sceneNumber;
    }

    void setScene(int xPlacement, int yPlacement) {
        //captain collision
        System.out.println(xPlacement +" "+ yPlacement);
        if ((xPlacement == 2 && yPlacement == 5) || (xPlacement ==  3 && yPlacement == 4) || (xPlacement == 2 && yPlacement == 3) || (xPlacement == 1 && yPlacement == 4)) {
            setSceneNumber(1);
            System.out.println("setting scene to scene 2 because at 2,5");
            System.out.println(sceneNumber);
            //crew collision
        }else if((xPlacement == 3 && yPlacement == 7) || (xPlacement ==  2 && yPlacement == 6) || (xPlacement ==  1 && yPlacement == 7) || (xPlacement ==  2 && yPlacement == 8)){
            setSceneNumber(3);
        }else if((xPlacement == 8 && yPlacement == 1) || (xPlacement ==  7 && yPlacement == 2) || (xPlacement ==  6 && yPlacement == 1)){
            setSceneNumber(2);
        }
    }
    private void setSceneNumber(int x){
        sceneNumber = Integer.toString(x);
    }
    Text getSceneText() throws IOException, ParseException {
        while (sceneNumber == null) {
            setSceneNumber(1);
        }

        JsonReader json = new JsonReader();
        return new Text(json.readJsonFile(sceneNumber));
    }


    //warning was suppressed because the variable doesn't have a reason to change yet
    @SuppressWarnings({"unused", "ConstantConditions"})
    public void testIfRedundantScene(String scene) throws IOException, ParseException
    {
        boolean scene1 = false;
        if(!scene1)
        {
            getSceneText();
        }
    }
}

