package models;

/**
 * Used to calculate the score of throws with 5 dice
 */
public class YatzyResultCalculator {
    private Die[] dice;
    private int[] sum = new int[6];

    /**
     * @param dice
     */
    public YatzyResultCalculator(Die[] dice) {
        this.dice = dice;
        for (Die die : dice) { //Kører gennem diceArrayet(5 gange)
            sum[die.getEyes() - 1]++; //Henter det antal øjne på terningen, og plusser tilsvarende indeks i sum med en.
        }
    }
    public void updateSum(Die[] dice) {
        for (int i = 0; i < sum.length; i++) {
            sum[i] = 0;
        }
        for (Die die : dice) {
            int dieValue = die.getEyes();
            if (dieValue >= 1 && dieValue <= 6) {
                sum[dieValue - 1]++;
            }
        }
    }

    /**
     * Calculates the score for Yatzy uppersection
     *
     * @param eyes eye value to calculate score for. eyes should be between 1 and 6
     * @return the score for specified eye value
     */
    public int upperSectionScore(int eyes) {
        return sum[eyes - 1] * eyes;
    }

    public int onePairScore() {
        for (int i = sum.length - 1; i > 0; i--) {//Start oppefra for at sikre at første par fundet, er det højeste par.
            if (sum[i] >= 2) {
                return (i + 1) * 2;
            }
        }
        return 0;
    }

    public int twoPairScore() {
        int antalPar = 0; // Tæller antallet af par fundet
        int score = 0;    // Holder den samlede score for de to par
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] > 1) {       // Tjek om der er mindst to af samme værdi
                score += (i + 1) * 2; // Tilføj værdien af dette par til scoren
                antalPar++;           // Øg antallet af fundne par
                if (antalPar == 2) {  // Hvis to par er fundet, returnér scoren
                    return score;
                }
            }
        }
        return 0;
    }

    public int threeOfAKindScore() {
        for (int i = sum.length - 1; i > 0; i--) {
            if (sum[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public int fourOfAKindScore() {
        for (int i = sum.length - 1; i > 0; i--) {
            if (sum[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public int smallStraightScore() {
        int antalIStreg = 0;
        for (int i = 0; i < 5; i++) {
            if (sum[i] == 1) {
                antalIStreg++;
                if (antalIStreg == 5)
                    return 15;
            }
        }
        return 0;
    }

    public int largeStraightScore() {
        int antalIStreg = 0;
        for (int i = 1; i < 6; i++) {
            if (sum[i] == 1) {
                antalIStreg++;
                if (antalIStreg == 5)
                    return 20;
            }
        }
        return 0;
    }

    public int fullHouseScore() {
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] == 3) {
                for (int j = sum.length - 1; j >= 0; j--) {
                    if (sum[j] == 2) {
                        return ((i + 1) * 3) + ((j + 1) * 2);
                    }
                }
            }
        }
        return 0;
    }

    public int chanceScore() {
        int score = 0;
        for (int i = 0; i < sum.length; i++) {
            score += (i + 1) * sum[i];
        }
        return score;
    }

    public int yatzyScore() {
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == 5) {
                return 50;
            }
        }
        return 0;
    }
}
