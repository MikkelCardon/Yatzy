package models;

/**
 * Used to calculate the score of throws with 5 dice
 */
public class YatzyResultCalculator {
int[] eyesCount = new int[6];
Die[] diceThrow;


    /**
     *
     * @param dice
     */
    public YatzyResultCalculator(Die[] dice) {
        //TODO: implement YatzyResultCalculator constructor.
        this.diceThrow = dice;
        doEyesCount();
    }

    public void doEyesCount(){
        for (Die die : diceThrow) {
            eyesCount[die.getDie()-1]++;
        }
    }

    /**
     * Calculates the score for Yatzy uppersection
     * @param eyes eye value to calculate score for. eyes should be between 1 and 6
     * @return the score for specified eye value
     */
    public int upperSectionScore(int eyes) {
        //TODO: Implement upperSectionScore method.

        return eyesCount[eyes-1] * eyes;
    }

    public int onePairScore() {
        //TODO: implement onePairScore method.

        for (int i = 5; i > -1; i--) {
            if (eyesCount[i] >= 2){
               return (i+1) *2;
            }
        }
        return 0;
    }

    public int twoPairScore() {
        //TODO: implement twoPairScore method.
        int numberOfPairs = 0;
        int sum = 0;

        for (int i = 5; i > -1; i--) {
            if (eyesCount[i] >= 2) {
                sum += (i+1) *2;
                numberOfPairs++;
            }
        }
        if (numberOfPairs >= 2){ return sum;}
        return 0;
    }

    public int threeOfAKindScore() {
        //TODO: implement threeOfAKindScore method.
        for (int i = 5; i > -1; i--) {
            if (eyesCount[i] >= 3){
                return (i+1) *3;
            }
        }
        return 0;
    }

    public int fourOfAKindScore() {
        //TODO: implement fourOfAKindScore method.
        for (int i = 5; i > -1; i--) {
            if (eyesCount[i] >= 4){
                return (i+1) *4;
            }
        }
        return 0;
    }

    public int smallStraightScore() {
        //TODO: implement fourOfAKindScore method.
        int sum = 0;
        for (int i = 0; i < eyesCount.length-1; i++) {
           if (eyesCount[i] > 0){
               sum+= i+1;
           }
        }
        if (sum == 15){ return 15;}
        return 0;
    }

    public int largeStraightScore() {
        //TODO: implement largeStraightScore method.
        int sum = 0;
        for (int i = 1; i < eyesCount.length; i++) {
            if (eyesCount[i] > 0){
                sum+= i+1;
            }
        }
        if (sum == 20){ return 20;}
        return 0;
    }

    public int fullHouseScore() {
        //TODO: implement fullHouseScore method.
        int threeOfAkind = 0;
        int twoOfAKind = 0;

        for (int i = 5; i > -1; i--) {
            if (eyesCount[i] >= 3){
                threeOfAkind= (i+1)*3;
            }
            else {
                if (eyesCount[i] >= 2){
                    twoOfAKind = (i+1)*2;
                }
            }

        }
        if (threeOfAkind != 0 && twoOfAKind != 0){ return threeOfAkind + twoOfAKind;}
        return 0;
    }

    public int chanceScore() {
        //TODO: implement chanceScore method.
        int sum = 0;

        for (Die die : diceThrow) {
            sum += die.getDie();
        }
        return sum;
    }

    public int yatzyScore() {
        //TODO: implement yatzyScore method.
        for (int i = 5; i > -1; i--) {
            if (eyesCount[i] == 5){
                return 50;
            }
        }
        return 0;
    }
}
