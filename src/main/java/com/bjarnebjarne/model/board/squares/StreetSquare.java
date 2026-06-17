package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class StreetSquare extends PurchaseableSquare {
    String colorGroup;
    int houseCost;

    public StreetSquare(String type, String name, int position, int price, int mortgage, int[] rent, String colorGroup, int houseCost) {
        super(type, name, position, price, mortgage, rent);
        this.colorGroup = colorGroup;
        this.houseCost = houseCost;
    }

    @Override
    public int calculateRent(GameState state) {
        return 0;
    }
    
}
