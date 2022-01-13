package edu.bsu.cs222.PirateAdventure;


import javafx.scene.text.Text;

@SuppressWarnings("ALL")
//subtractCrew is currently unused, so it needed to be suppressed
public class SuppliesMonitor {
    private static int food;
    private static int crew;
    public static String objective = "Objective: ";

    //food methods
    //warnings were suppressed  because they are currently unused
    void addFood(@SuppressWarnings("SameParameterValue") int postiveFood) {
        food = food+postiveFood;
    }
    //this warning was suppressed because the variable is currently unused
    void subtractFood(@SuppressWarnings("SameParameterValue") int negativeFood){
        food = negativeFood;
    }
    //crew methods
    //this warning was suppressed because the variable is currently unused
    void addCrew(@SuppressWarnings("SameParameterValue") int positiveCrew){
        crew = crew + positiveCrew;
    }
    public void subtractCrew(int negativeCrew){
        crew = crew - negativeCrew;
        if(crew < 0){
            crew = 0;
        }
    }
//setting integers to string for textFlows and returning monitor info
    String getSuppliesMonitorFood() {
        String intToString = "" + food;
        return "-"+ intToString + " per day";
    }
    String getSuppliesMonitorCrew() {
        String intToString = "" + crew;
        return "-" + intToString +" per day";
    }
    Text getObjective()
    {
        return new Text(objective);
    }
}
