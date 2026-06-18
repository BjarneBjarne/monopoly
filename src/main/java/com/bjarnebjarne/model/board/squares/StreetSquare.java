package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class StreetSquare extends PurchaseableSquare {
    private String colorGroup;
    private int houseCost;
    private int numHouses;

    public StreetSquare(String type, String name, int position, int price, int mortgage, int[] rent, String colorGroup, int houseCost) {
        super(type, name, position, price, mortgage, rent);
        this.colorGroup = colorGroup;
        this.houseCost = houseCost;
        this.numHouses = 0;
    }

    @Override
    public int calculateRent(GameState state) {
        if (state.playerOwnsColorGroup(this.owner, this.colorGroup)) {
            return this.rent[0] * 2;
        }
        return this.rent[numHouses];
    }

    public String getColorGroup() {
        return colorGroup;
    }
    
}
