package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class RailroadSquare extends PurchaseableSquare {

    public RailroadSquare(String type, String name, int position, int price, int mortgage, int[] rent) {
        super(type, name, position, price, mortgage, rent);
    }

    @Override
    public int calculateRent(GameState state) {
        int railroadsOwned = 0;
        for (Square square : state.getBoard().getSquares()) {
            if (square instanceof RailroadSquare railroad && railroad.getOwner() == this.getOwner()) {
                railroadsOwned++;
            }
        }
        if (railroadsOwned >= 0 && railroadsOwned <= rent.length) {
            return this.rent[railroadsOwned - 1];
        }
        throw new IndexOutOfBoundsException("Railroads owned must be between 0 and " + rent.length);
    }
}
