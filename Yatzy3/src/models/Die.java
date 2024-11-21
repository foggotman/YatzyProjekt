package models;

import java.util.Random;

public class Die {
    private int eyes = 0;
    private boolean isHold;
    private final Random random = new Random();

    /**
     * Creates a new Die object, with face set to eyes. Used for test purpose
     *
     * @param eyes value should be between 1 and 6
     */
    public Die(int eyes) {
        if (eyes < 1 || eyes > 6) {
            throw new IllegalArgumentException("Die value must be between 1 and 6. Given: " + eyes);
        }
        this.eyes = eyes;
    }

    public Die() {
    }

    public void roll() {
        if (!isHold) {
            eyes = random.nextInt(6) + 1; //Giver eyes en værdi mellem 1 og 6.
        }
    }

    public int getEyes() {
        return eyes;
    }


    public Random getRandom(int eyes) {
        return random;
    }

    public void setHold(boolean isHold) {
        this.isHold = isHold;
    }
}
