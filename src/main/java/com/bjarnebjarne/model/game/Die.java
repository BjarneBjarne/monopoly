package com.bjarnebjarne.model.game;

public class Die {
    int numSides;

    public Die(int numSides) {
        this.numSides = numSides;
    }

    public int roll() {
        return (int)Math.floor(Math.random()*this.numSides) + 1;
    }
}
