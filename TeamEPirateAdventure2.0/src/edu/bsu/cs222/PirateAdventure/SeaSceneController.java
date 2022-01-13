package edu.bsu.cs222.PirateAdventure;

import javafx.scene.text.Text;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class SeaSceneController {

    //private String sceneNumber;
        private static String sceneNumber;

//initialization of variables
        //methods
private String getSceneNumber(){
            return sceneNumber;
        }

        void setScene(int xPlacement, int yPlacement) {
            //this island
            System.out.println(xPlacement +" "+ yPlacement);
            if ((xPlacement == 4 && yPlacement == 8) || (xPlacement ==  4 && yPlacement == 7) || (xPlacement == 3 && yPlacement == 6) || (xPlacement == 2 && yPlacement == 6) || (xPlacement == 1 && yPlacement == 7) || (xPlacement ==  1 && yPlacement == 8) || (xPlacement == 2 && yPlacement == 9) || (xPlacement == 3 && yPlacement == 9)) {
                setSceneNumber(1);
                System.out.println(sceneNumber);
                //that island
            }else if((xPlacement == 6 && yPlacement == 15) || (xPlacement ==  6 && yPlacement == 16) || (xPlacement ==  6 && yPlacement == 17) || (xPlacement ==  5 && yPlacement == 18) || (xPlacement == 4 && yPlacement ==18) || (xPlacement ==  3 && yPlacement ==18) || (xPlacement ==  2 && yPlacement == 17) || (xPlacement ==  2 && yPlacement == 16)||(xPlacement ==  2 && yPlacement == 15)||(xPlacement ==  3 && yPlacement == 14)||(xPlacement ==  4 && yPlacement == 14)||(xPlacement ==  5 && yPlacement == 14)){
                setSceneNumber(2);
                //side island
            }else if((xPlacement == 11 && yPlacement == 0) || (xPlacement == 11 && yPlacement == 1) || (xPlacement ==  10 && yPlacement == 2) || (xPlacement ==  9 && yPlacement == 2)||(xPlacement ==  8 && yPlacement == 2)||(xPlacement ==  7 && yPlacement == 1)||(xPlacement ==  7 && yPlacement == 0)){
                setSceneNumber(3);
                //last island
            }else if((xPlacement == 16 && yPlacement == 6) || (xPlacement == 17 && yPlacement == 6) || (xPlacement ==  18 && yPlacement == 5) || (xPlacement ==  18 && yPlacement == 4)||(xPlacement ==  17 && yPlacement == 3)||(xPlacement ==  16 && yPlacement == 3)||(xPlacement ==  15 && yPlacement == 4)||(xPlacement ==  15 && yPlacement == 5)){
                setSceneNumber(4);
                //corner island
            }else if((xPlacement == 20 && yPlacement == 18) || (xPlacement == 19 && yPlacement == 18) || (xPlacement ==  18 && yPlacement == 18) || (xPlacement ==  17 && yPlacement == 19)||(xPlacement ==  17 && yPlacement == 20)){
                setSceneNumber(5);
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
            return new Text(json.readSeaJsonFile(sceneNumber));
        }

        @SuppressWarnings("ConstantConditions")
        //warning was suppressed because the variable doesn't have a reason to change yet
        public void testIfRedundantScene(String scene) throws IOException, ParseException
        {
            boolean scene1 = false;
            if(!scene1)
            {
                getSceneText();
            }
        }
    }


