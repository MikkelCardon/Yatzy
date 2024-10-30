package models;

import java.util.Random;

public class Die {
    private int eyes = 0;
    private boolean rollAgain = false;
    private final Random random = new Random();

    /**
     * Creates a new Die object, with face set to eyes. Used for test purpose
     * //@param eyes value should be between 1 and 6
     */

    public Die() {
        roll();
    }

    public void roll() {
        //TODO: implement roll method.
        this.eyes = (int)(Math.random()*6+1);
    }

    public int getDie(){
        return eyes;
    }


    public boolean RollAgain() {
        return rollAgain;
    }

    public void setRollAgain(boolean rollAgain) {
        this.rollAgain = rollAgain;
    }
}
