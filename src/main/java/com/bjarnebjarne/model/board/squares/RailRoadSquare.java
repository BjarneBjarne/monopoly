package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class RailRoadSquare extends PurchaseableSquare {

    public RailRoadSquare(String type, String name, int position, int price, int mortgage, int[] rent) {
        super(type, name, position, price, mortgage, rent);
    }



    @Override
    public void onLand(GameState state) {

    }
    
}
