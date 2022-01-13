package edu.bsu.cs222.PirateAdventure;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
//initializations of variables
    //map grids
    public GridPane shipGridPane;
    public GridPane seaGridPane;

    //user characters
    public Circle shipPlayerCircle;
    public ImageView seaUser;

    //textFlows
    public TextFlow MonitorTextFlow;
    public TextFlow suppliesTextFlow;
    public TextFlow textStream;
    public Button option1;

    public TextField phaseSelector;
    public ImageView evilBoat;
    public Circle blueCrewMember;
    public Circle crewMember;
    public Button option2;
    public ImageView phase2X;
    public ImageView phase3X;
    public ImageView phase4X;
    public ImageView endX;
    public ImageView phase1X;
    public Button playButton;
    JsonReader jsonReader = new JsonReader();

    private boolean onShip = false;
    static boolean buttonCanBePressed = false;




    //initialization of objects
    private SeaPlayer seaPlayer = new SeaPlayer();
    private ShipPlayer shipPlayer = new ShipPlayer();
    private Story story = new Story();
    SuppliesMonitor suppliesMonitor = new SuppliesMonitor();

    private static boolean choice1 = false;
    private static boolean choice2 = false;


//methods for ship and sea tabs
    public void shipButtonPushed(@SuppressWarnings("unused")  ActionEvent actionEvent) throws IOException, ParseException {
        onShip = true;
        //switch GridPanes
        seaGridPane.setVisible(false);
        shipGridPane.setVisible(true);
        getSuppliesTextFlow();
    }

    public void seaButtonPushed(@SuppressWarnings("unused")  ActionEvent actionEvent) throws IOException, ParseException {
        onShip = false;
        //switch GridPanes
        shipGridPane.setVisible(false);
        seaGridPane.setVisible(true);
        getSeaSuppliesTextFlow();
    }

//choice buttons at bottom of screen
    public void button1Pressed() {
        if(buttonCanBePressed){
            choice1 = true;
            choice2 = false;
            if (RandomEvents.pirateAttack){
                RandomEvents.pirateAttackEvent();
            } else if(RandomEvents.whirlPool){
                RandomEvents.whirlPoolEvent();
            } else if(RandomEvents.jaggedRocks){
                RandomEvents.jaggedRocksEvent();
            }
            getEventsResultTextFlow();
            getCurrentSuppliesTextFlow();
            choice1 = false;
            buttonCanBePressed = false;
        }
    }
    boolean getChoice1(){
        return choice1;
    }

    public void button2Pressed() {
        if(buttonCanBePressed){
            choice1 = false;
            choice2 = true;
            if (RandomEvents.pirateAttack){
                RandomEvents.pirateAttackEvent();
            } else if(RandomEvents.whirlPool){
                RandomEvents.whirlPoolEvent();
            } else if(RandomEvents.jaggedRocks){
                RandomEvents.jaggedRocksEvent();
            }
            getEventsResultTextFlow();
            getCurrentSuppliesTextFlow();
            choice2 = false;
            buttonCanBePressed = false;
        }
    }
    boolean getChoice2(){
        return choice2;
    }

//moves the ship around the sea
    private void seaMoveUp() {
        try {
            GridPane.setRowIndex(seaUser, seaPlayer.setSeaRowIndexUp());
            seaUser.setImage(seaPlayer.setBoatSpriteUp());
            getSeaSuppliesTextFlow();
            RandomEvents.randomEvents();
            getEventsTextFlow();
            if(!Story.phase2Complete && seaPlayer.hitCeasarsBayDock)
            {
                phaseSelector.setText("2");
                refreshPhase(null);
            }
            else if(!Story.phase3Complete && seaPlayer.hitHarborOfBonesDock)
            {
                phaseSelector.setText("3");
                refreshPhase(null);
            }
            else if(!Story.phase4Complete && seaPlayer.hitOnisIslandDock)
            {
                phaseSelector.setText("4");
                refreshPhase(null);
            }
            else if(!Story.endComplete && seaPlayer.hitIvoryBluffsDock)
            {
                phaseSelector.setText("end");
                refreshPhase(null);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void seaMoveDown(){
        try {
            GridPane.setRowIndex(seaUser, seaPlayer.setSeaRowIndexDown());
            seaUser.setImage(seaPlayer.setBoatSpriteDown());
            getSeaSuppliesTextFlow();
            RandomEvents.randomEvents();
            getEventsTextFlow();
            if(!Story.phase2Complete && seaPlayer.hitCeasarsBayDock)
            {
                phaseSelector.setText("2");
                refreshPhase(null);
            }
            else if(!Story.phase3Complete && seaPlayer.hitHarborOfBonesDock)
            {
                phaseSelector.setText("3");
                refreshPhase(null);
            }
            else if(!Story.phase4Complete && seaPlayer.hitOnisIslandDock)
            {
                phaseSelector.setText("4");
                refreshPhase(null);
            }
            else if(!Story.endComplete && seaPlayer.hitIvoryBluffsDock)
            {
                phaseSelector.setText("end");
                refreshPhase(null);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void seaMoveLeft(){
        try {
            GridPane.setColumnIndex(seaUser, seaPlayer.setSeaColumnIndexLeft());
            seaUser.setImage(seaPlayer.setBoatSpriteLeft());
            getSeaSuppliesTextFlow();
            RandomEvents.randomEvents();
            getEventsTextFlow();
            if(!Story.phase2Complete && seaPlayer.hitCeasarsBayDock)
            {
                phaseSelector.setText("2");
                refreshPhase(null);
            }
            else if(!Story.phase3Complete && seaPlayer.hitHarborOfBonesDock)
            {
                phaseSelector.setText("3");
                refreshPhase(null);
            }
            else if(!Story.phase4Complete && seaPlayer.hitOnisIslandDock)
            {
                phaseSelector.setText("4");
                refreshPhase(null);
            }
            else if(!Story.endComplete && seaPlayer.hitIvoryBluffsDock)
            {
                phaseSelector.setText("end");
                refreshPhase(null);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void seaMoveRight(){
        try {
            GridPane.setColumnIndex(seaUser, seaPlayer.setSeaColumnIndexRight());
            seaUser.setImage(seaPlayer.setBoatSpriteRight());
            getSeaSuppliesTextFlow();
            RandomEvents.randomEvents();
            getEventsTextFlow();
            if(!Story.phase2Complete && seaPlayer.hitCeasarsBayDock)
            {
                phaseSelector.setText("2");
                refreshPhase(null);
            }
            else if(!Story.phase3Complete && seaPlayer.hitHarborOfBonesDock)
            {
                phaseSelector.setText("3");
                refreshPhase(null);
            }
            else if(!Story.phase4Complete && seaPlayer.hitOnisIslandDock)
            {
                phaseSelector.setText("4");
                refreshPhase(null);
            }
            else if(!Story.endComplete && seaPlayer.hitIvoryBluffsDock)
            {
                phaseSelector.setText("end");
                refreshPhase(null);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


//moves the player around the ship
    private void shipMoveUp(){
        try {
            GridPane.setRowIndex(shipPlayerCircle, shipPlayer.setShipRowIndexUp());
            getSeaSuppliesTextFlow();
            if(!Story.phase1Complete && shipPlayer.hitDoor)
            {
                phaseSelector.setText("1");
                refreshPhase(null);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void shipMoveDown(){
        try {
            GridPane.setRowIndex(shipPlayerCircle, shipPlayer.setShipRowIndexDown());
            getSeaSuppliesTextFlow();
            if(!Story.phase1Complete && shipPlayer.hitDoor)
            {
                phaseSelector.setText("1");
                refreshPhase(null);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void shipMoveLeft(){
        try
        {
            GridPane.setColumnIndex(shipPlayerCircle, shipPlayer.setShipColumnIndexLeft());
            getSeaSuppliesTextFlow();
            if(!Story.phase1Complete && shipPlayer.hitDoor)
            {
                phaseSelector.setText("1");
                refreshPhase(null);
            }

        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
    }

    private void shipMoveRight(){
        try {
            GridPane.setColumnIndex(shipPlayerCircle, shipPlayer.setShipColumnIndexRight());
            getSeaSuppliesTextFlow();
            if(!Story.phase1Complete && shipPlayer.hitDoor)
            {
                phaseSelector.setText("1");
                refreshPhase(null);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    private void getSuppliesTextFlow() throws IOException, ParseException {
        SceneController scene = new SceneController();
        System.out.println("removed\n");
        textStream.getChildren().clear();
        textStream.getChildren().add(scene.getSceneText());
    }
    private void getSeaSuppliesTextFlow() throws IOException, ParseException {
        SeaSceneController scene = new SeaSceneController();
        textStream.getChildren().clear();
        textStream.getChildren().add(scene.getSceneText());
    }
    public void getCurrentSuppliesTextFlow(){
        Supplies supplies = new Supplies();
        suppliesTextFlow.getChildren().clear();
        Text text;
        text = new Text("YOUR CREW: "+supplies.getCrewSupplies()+"\n"+  "YOUR FOOD: "+supplies.getFoodSupplies() + "\n");
        suppliesTextFlow.getChildren().add(text);

    }
    public void getBeginning(){
        textStream.getChildren().clear();
        try {
            textStream.getChildren().add(Story.beginning());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void getPhase1(){
        textStream.getChildren().clear();
        try {
            textStream.getChildren().add(Story.phase1());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void getPhase2(){
        textStream.getChildren().clear();
        try {
            textStream.getChildren().add(Story.phase2());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getPhase3(){
        textStream.getChildren().clear();
        try {
            textStream.getChildren().add(Story.phase3());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void getPhase4(){
        textStream.getChildren().clear();
        try {
            textStream.getChildren().add(Story.phase4());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void getEnd(){
        textStream.getChildren().clear();
        try {
            textStream.getChildren().add(Story.end());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void getEventsTextFlow(){
        RandomEvents random = new RandomEvents();
        textStream.getChildren().clear();
        textStream.getChildren().add(random.getEventText());
        textStream.getChildren().add(random.addSpace());
    }
    public void getEventsResultTextFlow(){
        RandomEvents random = new RandomEvents();
        textStream.getChildren().clear();
        textStream.getChildren().add(random.getEventResultText1());
        textStream.getChildren().add(random.addSpace());
        textStream.getChildren().add(random.getEventResultText2());
        textStream.getChildren().add(random.getNullResult());
    }


    //text flows functions

    private Text GetTextFlow(){

        Text text1;
        Supplies supplies = new Supplies();
        text1 =  new Text("YOUR CREW: "+supplies.getCrewSupplies()+"\n"+  "YOUR FOOD: "+supplies.getFoodSupplies());
        return text1;

    }
    public void getObjectiveTextFlow()
    {
        Text text = new Text(SuppliesMonitor.objective);

        MonitorTextFlow.getChildren().clear();
        MonitorTextFlow.getChildren().setAll(text);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        MonitorTextFlow.getChildren().setAll(suppliesMonitor.getObjective());


        //Supplies TextFlow

            suppliesTextFlow.getChildren().add(GetTextFlow());


        SceneController sceneControl = new SceneController();

        try {
            textStream.getChildren().add(sceneControl.getSceneText());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public void keyPushed(@SuppressWarnings("unused")KeyEvent keyEvent) {
    }

    public void MovKeyPressed(KeyEvent keyEvent)
    {
        if (onShip && RandomEvents.canMove)
        {
            if(keyEvent.getCode() == KeyCode.W) {
                shipMoveUp();
            }
            else if (keyEvent.getCode() == KeyCode.A)
            {
                shipMoveLeft();
            }
            else if (keyEvent.getCode() == KeyCode.D)
            {
                shipMoveRight();
            }
            else if (keyEvent.getCode() == KeyCode.S)
            {
                shipMoveDown();
            }
        }
        else if (!onShip && RandomEvents.canMove)
        {
            if(keyEvent.getCode() == KeyCode.W) {
                seaMoveUp();
            }
            else if (keyEvent.getCode() == KeyCode.A)
            {
                seaMoveLeft();
            }
            else if (keyEvent.getCode() == KeyCode.D)
            {
                seaMoveRight();
            }
            else if (keyEvent.getCode() == KeyCode.S)
            {
                seaMoveDown();
            }
        }
    }




    public void refreshPhase(@SuppressWarnings("unused")ActionEvent actionEvent) throws IOException, ParseException{
        switch (phaseSelector.getText()) {
            case "beginning":

                RandomEvents.canMove = false;
                Story.beginning();
                evilBoat.setVisible(false);

                seaPlayer.seaRowMovement = 4;
                seaPlayer.seaColumnMovement = 5;
                GridPane.setRowIndex(seaUser, 4);
                GridPane.setColumnIndex(seaUser, 5);
                seaUser.setImage(seaPlayer.setBoatSpriteRight());
                RandomEvents.canMove = true;
                SuppliesMonitor.objective = jsonReader.readStoryJsonFile("12");
                getObjectiveTextFlow();
                phase1X.setVisible(true);
                break;
            case "1":

                getPhase1();
                phase1X.setVisible(false);
                phase2X.setVisible(true);
                SuppliesMonitor.objective = jsonReader.readStoryJsonFile("11");
                getObjectiveTextFlow();
                break;
            case "2":

                getPhase2();
                phase2X.setVisible(false);
                phase3X.setVisible(true);
                SuppliesMonitor.objective = jsonReader.readStoryJsonFile("20");
                getObjectiveTextFlow();
                break;
            case "3":

                getPhase3();
                phase3X.setVisible(false);
                phase4X.setVisible(true);
                break;
            case "4":

                getPhase4();
                phase4X.setVisible(false);
                endX.setVisible(true);
                SuppliesMonitor.objective = jsonReader.readStoryJsonFile("27");
                getObjectiveTextFlow();
                break;
            case "end":
                getEnd();
                break;
        }
    }

    public void startStory(@SuppressWarnings("unused")ActionEvent actionEvent) throws ParseException, IOException {
        phaseSelector.setText("beginning");
        getBeginning();
        refreshPhase(null);
        playButton.setVisible(false);
    }
}

