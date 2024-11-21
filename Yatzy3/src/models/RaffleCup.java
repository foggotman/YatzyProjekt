package models;

public class RaffleCup {
    private Die[] femDice = new Die[5]; //Definere femDice til at være med 5terninger



    public RaffleCup() {
        for (int i = 0; i < femDice.length; i++) {
            femDice[i] = new Die(); //Fylder raflebægeret med terninger
        }
        throwDice();
    }

    public void throwDice() {
        for(Die die : femDice){
            die.roll(); //Kaster alle terningerne i femDice
        }
    }
    public int getDieValue(int index) {
        return femDice[index].getEyes();
    }

    public void setFemDice(Die[] femDice) {
        this.femDice = femDice;
    }

    public Die[] getFemDice() {
        return femDice;
    }

    public void setDieValue(int index, Die die) {
            femDice[index] = die; // Set the die to the specific die object
        }

    public void setHold(int dieNumber, boolean isHold) {
        femDice[dieNumber].setHold(isHold);
    }
}
