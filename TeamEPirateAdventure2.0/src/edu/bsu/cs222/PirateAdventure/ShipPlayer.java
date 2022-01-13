package edu.bsu.cs222.PirateAdventure;

class ShipPlayer {

    public boolean hitDoor;
    //initializations of variables
    private int shipRowMovement = 4;
    private int shipColumnMovement = 4;


//initializations of objects
    private DoubleMovement doubleMovement = new DoubleMovement();



//bounds for movement on ship
    int setShipRowIndexUp(){
        //collision for x
        if(shipRowMovement == 3 && shipColumnMovement == 4){
            hitDoor = true;
            return shipRowMovement;
        }
        //collision for crew member
        else if(shipRowMovement == 3 && shipColumnMovement == 7) {
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipRowMovement;
        }
        //collision for blue crew member
        else if(shipRowMovement == 8 && shipColumnMovement == 1) {
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipRowMovement;

        }
        //collision for edge of map
        else if(shipRowMovement>0)
        {
            return shipRowMovement -= 1;
        }
        return shipRowMovement;
    }

    int setShipRowIndexDown(){
        //collision for x
        if(shipRowMovement == 1 && shipColumnMovement == 4){
            hitDoor = true;
            return shipRowMovement;
        }
        //collision for crew member
        else if(shipRowMovement == 1 && shipColumnMovement == 7)
        {
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipRowMovement;
        }
        //collision for blue crew member
        else if(shipRowMovement == 6 && shipColumnMovement == 1)
        {
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipRowMovement;
        }
        //collision for edge of map
        else if(shipRowMovement<8)
        {
            return shipRowMovement += 1;
        }
        return shipRowMovement;
    }

    int setShipColumnIndexLeft(){
        //collision for x
        if(shipRowMovement == 2 && shipColumnMovement == 5){
            hitDoor = true;
            return shipColumnMovement;

        }
        //collision for crew member
        else if(shipRowMovement == 2 && shipColumnMovement == 8)
        {
            System.out.println("sensing reg crew");
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipColumnMovement;
        }
        //collision for blue crew member
        else if(shipRowMovement == 7 && shipColumnMovement == 2)
        {
            System.out.println("sensing blue crew");
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipColumnMovement;
        }
        //collision for edge of map
        else if(shipColumnMovement>0)
        {
            return shipColumnMovement -= 1;
        }
        return shipColumnMovement;
    }


    int setShipColumnIndexRight(){
        //collision for x
        if(shipRowMovement == 2 && shipColumnMovement == 3){
            hitDoor = true;
            return shipColumnMovement;
        }
        //collision for crew member
        else if(shipRowMovement == 2 && shipColumnMovement == 6)
        {
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipColumnMovement;
        }
        //collision for blue crew member
        else if(shipRowMovement == 7 && shipColumnMovement == 0)
        {
            doubleMovement.setDoubleMovement(shipRowMovement,shipColumnMovement);
            return shipColumnMovement;
        }
        //collision for edge of map
        else if(shipColumnMovement<8)
        {
            return shipColumnMovement += 1;
        }
        return shipColumnMovement;
    }
}
