package edu.bsu.cs222.PirateAdventure;

import javafx.scene.text.Text;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Story {

    //beginning variables
    static JsonReader jsonReader = new JsonReader();

    static boolean beginningComplete = false;
    static boolean phase1Complete = false;
    static boolean phase2Complete = false;
    static boolean phase3Complete = false;
    static boolean phase4Complete = false;
    static boolean endComplete = false;

    public static String line1;
    public static String line2;
    public static String line3;
    public static String line4;
    public static String line5;
    public static String line6;
    public static String line7;
    public static String line8;
    public static String line9;
    public static String line10;
    public static String line13;
    public static String line14;
    public static String line15;
    public static String line16;
    public static String line17;
    public static String line18;
    public static String line19;
    public static String line21;
    public static String line22;
    public static String line23;
    public static String line24;
    public static String line25;
    public static String line26;

    public static Text currentStory;

    //captain dies, you become captain, you move to port comenzar
    static Text beginning() throws IOException, ParseException{
        System.out.println("beginning");
        line1 = jsonReader.readStoryJsonFile("1");
        line2 = jsonReader.readStoryJsonFile("2");
        line3 = jsonReader.readStoryJsonFile("3");
        line4 = jsonReader.readStoryJsonFile("4");
        line5 = jsonReader.readStoryJsonFile("5");
        line6 = jsonReader.readStoryJsonFile("6");
        currentStory = new Text(line1 + line2 + line3 + line4 + line5 + line6);
        beginningComplete = true;
        return currentStory;
    }

    //ship tab to go to captains room
    static Text phase1() throws IOException, ParseException {
        System.out.println("1");
        line7 = jsonReader.readStoryJsonFile("7")+ "\n";
        line8 = jsonReader.readStoryJsonFile("8")+ "\n";
        line9 = jsonReader.readStoryJsonFile("9")+ "\n";
        line10 = jsonReader.readStoryJsonFile("10")+ "\n";
        currentStory = new Text(line7 + line8 + line9 + line10);
        phase1Complete = true;
        return currentStory;
    }

    //you get map piece and parrot, meet uncle jay on Caesar's bay
    static Text phase2() throws Exception {
        System.out.println("2");
        line13 = jsonReader.readStoryJsonFile("13")+ "\n";
        line14 = jsonReader.readStoryJsonFile("14")+ "\n";
        line15 = jsonReader.readStoryJsonFile("15")+ "\n";
        line16 = jsonReader.readStoryJsonFile("16")+ "\n";
        line17 = jsonReader.readStoryJsonFile("17")+ "\n";
        line18 = jsonReader.readStoryJsonFile("18")+ "\n";
        line19 = jsonReader.readStoryJsonFile("19")+ "\n";
        currentStory = new Text(line13 + line14 + line15 + line16 + line17 + line18 + line19);
        phase2Complete = true;
        return currentStory;
    }

    //Harbor of bones, go to Bone Zone and get map piece
    static Text phase3() throws IOException, ParseException {
        System.out.println("3");
        line21 = jsonReader.readStoryJsonFile("21")+ "\n";
        line22 = jsonReader.readStoryJsonFile("22")+ "\n";
        currentStory = new Text(line21 + line22);
        phase3Complete = true;
        return currentStory;
    }

    //Talk to Oni and get map piece on Oni's island
    static Text phase4() throws IOException, ParseException{
        System.out.println("4");
        line23 = jsonReader.readStoryJsonFile("23")+ "\n";
        line24 = jsonReader.readStoryJsonFile("24")+ "\n";
        line25 = jsonReader.readStoryJsonFile("25")+ "\n";
        currentStory = new Text(line23 + line24 + line25);
        phase4Complete = true;
        return currentStory;
    }
    //Go to Ivory Bluffs and win game
    static Text end() throws IOException, ParseException {
        System.out.println("end");
        System.out.println(jsonReader.readStoryJsonFile("26"));
        line26 = jsonReader.readStoryJsonFile("26")+ "\n";
        currentStory = new Text(line26);
        endComplete = true;
        return currentStory;
    }
}
