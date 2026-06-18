package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class UtilitySquare extends PurchaseableSquare {

    public UtilitySquare(String type, String name, int position, int price, int mortgage, int[] rent) {
        super(type, name, position, price, mortgage, rent);
    }

    @Override
    public int calculateRent(GameState state) {
        int utilitiesOwned = state.numberPlayerOwns(this);
        int rollTotal = state.getLastRoll().total();

        if (utilitiesOwned >= 1 && utilitiesOwned <= rent.length) {
            return this.rent[utilitiesOwned - 1] * rollTotal;
        }
        throw new IndexOutOfBoundsException("Utilities owned must be between 0 and " + rent.length);
    }
    
}
