package com.bjarnebjarne.model.game;

public class DiceRoller {
    private final int numDice;
    private final int numSides;

    public DiceRoller(int numDice, int numSides) {
        this.numDice = numDice;
        this.numSides = numSides;
    }

    public RollResult roll() {
        int total = 0;
        int[] values = new int[this.numDice];
        boolean allEqual = true;
        Die die = new Die(this.numSides);

        if (this.numDice == 1) {
            allEqual = false;
        }

        for (int i = 0; i < this.numDice; i++) {
            values[i] = die.roll();
            total += values[i];
            if (i > 0 && values[i] != values[i-1] && allEqual) {
                allEqual = false;
            }
        }
        
        return new RollResult(total, values, allEqual);
    }
}
