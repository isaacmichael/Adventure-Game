package edu.bsu.cs222.PirateAdventure;

@SuppressWarnings("ALL")
//warnings were suppressed because the variables and methods are currently unused
public class Supplies {

    private static int crewSupplies;
    static int foodSupplies;

    public void MainSummationOfSupplies(int x) {
        if (x < 0) {
            //subtractSupplies(x);
        } else if (x > 0) {
            // addSupplies(x);
        }
    }

    void subtractCrewSupplies(int negativeSupplies) {
        crewSupplies = crewSupplies - negativeSupplies;
        if (crewSupplies < 0) {
            crewSupplies = 0;
        }
    }

    void addCrewSupplies(int positiveSupplies) {
        crewSupplies += positiveSupplies;
    }

    void subtractFoodSupplies(int negativeSupplies) {
        foodSupplies = foodSupplies - negativeSupplies;
        if (foodSupplies < 0) {
            foodSupplies = 0;
        }
        if (foodSupplies <= 0){
            RandomEvents.canMove = false;
            GameLost.loseGame();
        }
    }


    void addFoodSupplies(int positiveSupplies) {
        foodSupplies += positiveSupplies;
    }

    String getFoodSupplies() {
        System.out.println(foodSupplies);
        return "" + foodSupplies;
    }

    String getCrewSupplies() {
        System.out.println(crewSupplies);
        return "" + crewSupplies;
    }

    public int karmaSuppliesMultiplier(int sceneSupplies) {
        Karma karma = new Karma();
        int multiplier = (int) karma.getKarma();
        return sceneSupplies * multiplier;
    }

}



