package models;

public class ResultStorage {
    //UpperSection
    private int[] upperSection = new int[6];

    //LowerSection
    private int[] lowerSection = new int[9];

    //Overordnede totaler
    private int bonusSum = 0;
    private int upperSectionSum = 0;

    private int totalScore = 0;




    public int getUpperSectionSum() {
        upperSectionSum = 0;

        for (int upperSectionResult : upperSection) {
            upperSectionSum+=upperSectionResult;
        }
        return upperSectionSum;
    }

    public int bonusUnlocked(){
        if (upperSectionSum >= 63){
            return bonusSum = 50;
        }
        return bonusSum;
    }


    public int getTotalScore() {
        int lowerSectionSum = 0;
        for (int lowerSectionResult : lowerSection) {
            lowerSectionSum+= lowerSectionResult;
        }
        return  upperSectionSum + bonusSum + lowerSectionSum;
    }

    public void setLowerSection(int result, int indeks) {
        this.lowerSection[indeks] = result;
    }

    public void setUpperSection(int result, int indeks) {
        this.upperSection[indeks] = result;
    }
}
