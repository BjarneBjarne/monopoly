package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class TaxSquare extends Square {
    int taxAmount;

    public TaxSquare(String type, String name, int position, int taxAmount) {
        super(type, name, position);
        this.taxAmount = taxAmount;
    }

    @Override
    public void onLand(GameState state) {
        // Player pays money dependent on taxRate
    };
}
