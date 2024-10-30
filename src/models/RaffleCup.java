package models;

public class RaffleCup {
    private Die[] dice = new Die[5];

//Kunne være en løsning som første gangs kast.
// Da alle 5 terninger skal kastes. Derefter kan man sende x-antal terninger.


    public RaffleCup() {
        //TODO: Create an instance of RaffleCup.
        throwDice();
    }

    public void throwDice() {
        //TODO: implement throwDice method.
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == null || dice[i].RollAgain()) {
                dice[i] = new Die();
            }
        }

    }

    public Die[] getDice() {
        return dice;
    }

}
