package edu.bsu.cs222.PirateAdventure;

import javafx.scene.text.Text;

import java.util.Random;

class RandomEvents {

    static boolean canMove = false;
    static boolean pirateAttack = false;
    static boolean whirlPool = false;
    static boolean jaggedRocks = false;
    static String currentEvent;
    static String currentEventResult1;
    static String currentEventResult2;
    public static Text stringToText;
    public static Text stringToText2;


    private static int eventRandomValue(){
        Random random = new Random();
        return random.nextInt(25);
    }

    private static int resultRandomValue(){
        Random random = new Random();
        return random.nextInt(2);

    }

    Text getEventText(){
        stringToText = new Text(currentEvent);
        return stringToText;
    }
    Text addSpace(){
        stringToText = new Text("\n");
        return stringToText;
    }

    Text getEventResultText1(){
        stringToText = new Text(currentEventResult1);
        return stringToText;
    }
    Text getEventResultText2(){
        stringToText2 = new Text(currentEventResult2);
        return stringToText2;
    }
    Text getNullResult(){
        return new Text("");
    }

    static void randomEvents(){
        int randomValue = eventRandomValue();
        Controller.buttonCanBePressed = true;
        if (randomValue == 0){
            currentEvent = "Another ship is approaching Do you want to try and sail past (button 1) or try and raid them(button 2)?";
            pirateAttackEvent();
            canMove = false;
            pirateAttack = true;

        } else if (randomValue == 1){
            currentEvent = "FIELD OF JAGGED ROCKS AHEAD! Do you want to try to navigate the rocks (button 1) or attempt to find another way around(button 2)?";
            jaggedRocksEvent();
            canMove = false;
            jaggedRocks = true;

        } else if (randomValue == 2){
            currentEvent = "WHIRLPOOL!!! Do you want to try and sail around (button 1) or attempt to turn around(button 2)?";
            whirlPoolEvent();
            canMove = false;
            whirlPool = true;

        } else{
            currentEvent = "moved safely";
            System.out.println();
        }
    }

    static void whirlPoolEvent() {
        Supplies supplies = new Supplies();
        Controller controller = new Controller();
        int randomValue = resultRandomValue();
        if(controller.getChoice1()){
            currentEventResult1 = "You try to sail around the whirl pool...";
            if (randomValue == 0) {
                currentEventResult2 = "You manage to sail around without being sucked in!";
                canMove = true;
                System.out.println();
            } else if (randomValue == 1) {
                currentEventResult2 = "You got sucked in and tipped a bit but managed to stay afloat! LOSE 6 SUPPLIES!";
                canMove = true;
                supplies.subtractFoodSupplies(6);
                System.out.println();
            }
        } else if(controller.getChoice2()){
            currentEventResult1= "You attempt to turn around...";
            if (randomValue == 0) {
                currentEventResult2 = "You manage to turn around!";
                canMove = true;
                System.out.println();
            } else if (randomValue == 1) {
                currentEventResult2 = "The pull was too strong! LOSE 10 SUPPLIES AND 1 CREW MEMBER!";
                canMove = true;
                supplies.subtractFoodSupplies(10);
                supplies.subtractCrewSupplies(1);

                System.out.println();
            }
        }
        whirlPool = false;
        if (Supplies.foodSupplies <= 0){
            RandomEvents.canMove = false;
            GameLost.loseGame();
        }
    }

    static void jaggedRocksEvent() {
        Controller controller = new Controller();
        Supplies supplies = new Supplies();
        int randomValue = resultRandomValue();
        if(controller.getChoice1()){
            currentEventResult1 = "You try to navigate through...";
            if (randomValue == 0) {
                currentEventResult2 = "You somehow manage to maneuver your ship through!";
                canMove = true;

                System.out.println();
            } else if (randomValue == 1) {
                currentEventResult2 = "You hit a rock! LOSE 2 SUPPLIES!";
                canMove = true;
                supplies.subtractFoodSupplies(2);
                System.out.println();
            }
        } else if(controller.getChoice2()){
            currentEventResult1 = "You attempt to find another way around...";
            if (randomValue == 0) {
                currentEventResult2 = "You find a clearing in the rocks!";
                canMove = true;
                System.out.println();
            } else if (randomValue == 1) {
                currentEventResult2 = "You had to go completely around! LOSE 5 FOOD!";
                canMove = true;
                supplies.subtractFoodSupplies(5);
                System.out.println();
            }
        }
        jaggedRocks = false;
        if (Supplies.foodSupplies <= 0){
            RandomEvents.canMove = false;
            GameLost.loseGame();
        }
    }

    static void pirateAttackEvent() {
        Controller controller = new Controller();
        Supplies supplies = new Supplies();
        int randomValue = resultRandomValue();
        if(controller.getChoice1()){
            currentEventResult1 = "You try to sail past...";
            if(randomValue == 0){
                currentEventResult2 = "You sail past smoothly, looks like they were friendly... enough";
                canMove = true;
                System.out.println();
            } else if(randomValue == 1){
               currentEventResult2 = "They attacked and you were not prepared... LOST 4 FOOD";
                canMove = true;
                supplies.subtractFoodSupplies(4);
                System.out.println();
            }
        } else if(controller.getChoice2()){
            currentEventResult1 = "You attempt to raid...";
            if (randomValue == 0){
                currentEventResult2 = "You caught them by surprise... GAINED 7 FOOD";
                canMove = true;
                supplies.addFoodSupplies(7);
                System.out.println();
            } else if(randomValue == 1){
                currentEventResult2 = "They outnumbered you but let you continue sailing... at a price. LOST 1 CREW MEMBER";
                canMove = true;
                supplies.subtractCrewSupplies(1);
                System.out.println();
            }
        }
        pirateAttack = false;
        if (Supplies.foodSupplies <= 0){
            RandomEvents.canMove = false;
            GameLost.loseGame();
        }
    }
}
