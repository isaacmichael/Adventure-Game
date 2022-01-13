package edu.bsu.cs222.PirateAdventure;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

public class Tests {

    @Test
    public void TestSceneChange(){
        SceneController scene = new SceneController();
        scene.setScene(2,5);
        String x = scene.getSceneNumber();
        System.out.println(x);
        assert x.equals("1") :"valid";
    }
    @Test
    public void TestSceneChangeWithObjectDetectionOfPirates(){
        SceneController scene = new SceneController();
        int piratePlacementX = 3;
        int piratePlacementY = 7;
        scene.setScene(piratePlacementX,piratePlacementY);
        String x = scene.getSceneNumber();
        assert x.equals("3"):"valid";
    }
    @Test
    public void TestCrewSupplies() throws IOException, ParseException {
        Supplies supplies = new Supplies();
        String x =supplies.getCrewSupplies();
        assert x.equals("0");
    }
    @Test
    public void TestCrewSuppliesGain(){
        Supplies supplies = new Supplies();
        String original = supplies.getCrewSupplies();
        supplies.addCrewSupplies(1);
        String revised = supplies.getCrewSupplies();
        assert !original.equals(revised);
    }
    @Test
    public void TestCrewSuppliesLoss(){
        Supplies supplies = new Supplies();
        supplies.addCrewSupplies(2);
        String original = supplies.getCrewSupplies();
        supplies.subtractCrewSupplies(1);
        String revised = supplies.getCrewSupplies();
        assert !original.equals(revised);
    }
    @Test
    public void TestCrewSuppliesNegativeReset(){
        Supplies supplies = new Supplies();
        supplies.getCrewSupplies(); //equals 0
        supplies.subtractCrewSupplies(1);
        String negativeSupplies = supplies.getCrewSupplies();
        assert negativeSupplies.equals("0");
    }
    ////////
    @Test
    public void TestFoodSupplies() throws IOException, ParseException {
        Supplies supplies = new Supplies();
        String x =supplies.getFoodSupplies();
        assert x.equals("0");
    }
    @Test
    public void TestFoodSuppliesGain(){
        Supplies supplies = new Supplies();
        String original = supplies.getFoodSupplies();
        supplies.addFoodSupplies(1);
        String revised = supplies.getFoodSupplies();
        assert original != revised;
    }
    @Test
    public void TestFoodSuppliesLoss(){
        Supplies supplies = new Supplies();
        supplies.addFoodSupplies(2);
        String original = supplies.getFoodSupplies();
        supplies.subtractFoodSupplies(1);
        String revised = supplies.getFoodSupplies();
        assert original != revised;
    }
    @Test
    public void TestFoodSuppliesNegativeReset(){
        Supplies supplies = new Supplies();
        supplies.getFoodSupplies(); //equals 0
        supplies.subtractFoodSupplies(1);
        String negativeSupplies = supplies.getFoodSupplies();
        assert negativeSupplies.equals("0");
    }
    @Test
    public void TestKarmaGain(){
        Karma karma = new Karma();
        karma.addGoodKarma();
        float x = karma.getKarma();
        System.out.println(karma.getKarma());
        assert x == 1;
    }
    @Test
    public void TestKarmaFunctionalMultiplier(){
        Karma karma = new Karma();
        karma.addGoodKarma();
        karma.CalculateKarma();
        float x = karma.getKarma();
        assert x == 1.0;
    }
    @Test
    public void TestKarmaAdditionIntoSub1Float(){
        Karma karma = new Karma();
        karma.addGoodKarma();
        karma.addBadKarma();
        float x = karma.getKarma();
        System.out.println(x);
        assert x == 0.5;
    }
    @Test
    public void TestSuppliesMonitorFoodGain(){
        SuppliesMonitor monitor = new SuppliesMonitor();
        String original = "-"+monitor.getSuppliesMonitorFood() +"per day";
        monitor.addFood(1);
        String revised = "-"+monitor.getSuppliesMonitorFood()+" per day";
        assert !original.equals(revised);
    }
    @Test
    public void TestSuppliesMonitorCrewGain(){
        SuppliesMonitor monitor = new SuppliesMonitor();
        String original = "-"+monitor.getSuppliesMonitorCrew() +"per day";
        monitor.addCrew(1);
        String revised = "-"+monitor.getSuppliesMonitorCrew()+" per day";
        assert !original.equals(revised);
    }
    @Test
    public void TestSuppliesMonitorFoodNegativeLoss(){
        SuppliesMonitor monitor = new SuppliesMonitor();
        String wantedResult = monitor.getSuppliesMonitorFood();
        monitor.subtractFood(1);
        String actualResult = monitor.getSuppliesMonitorFood();
        assert actualResult.equals("-1 per day");
    }
    @Test
    public void TestSuppliesMonitorCrewNegativeLoss(){
        SuppliesMonitor monitor = new SuppliesMonitor();
        String wantedResult = monitor.getSuppliesMonitorCrew();
        monitor.subtractFood(1);
        String actualResult = monitor.getSuppliesMonitorCrew();
        assert wantedResult.equals(actualResult);
    }

}