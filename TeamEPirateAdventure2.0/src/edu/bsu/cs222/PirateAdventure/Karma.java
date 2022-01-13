package edu.bsu.cs222.PirateAdventure;



class Karma {

    //initialization of variables
    private static float karma;
    private static float badKarmaChosen;
    private static float goodKarmaChosen;

    float getKarma(){
        CalculateKarma();
        return karma;
    }
    void CalculateKarma(){
        karma = (goodKarmaChosen / (goodKarmaChosen+badKarmaChosen));
    }
    void addBadKarma(){
        badKarmaChosen = badKarmaChosen+1;
    }
    void addGoodKarma(){
        goodKarmaChosen = goodKarmaChosen+1;
    }



}
