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
        int[] values;
        boolean allEqual = false;

        for (int i = 0; i < this.numDice)
    }
}
