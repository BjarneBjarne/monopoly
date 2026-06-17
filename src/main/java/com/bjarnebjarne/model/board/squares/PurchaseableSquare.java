package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;
import com.bjarnebjarne.model.player.Player;

public abstract class PurchaseableSquare extends Square {
    int price;
    Player owner;
    boolean isMortgaged;
    int mortgage;
    int[] rent;
    
    public PurchaseableSquare(String type, String name, int position, int price, int mortgage, int[] rent) {
        super(type, name, position);
        this.price = price;
        this.owner = null;
        this.isMortgaged = false;
        this.mortgage = mortgage;
        this.rent = rent;
    }

    @Override
    public void onLand(GameState state) {
        if (this.isMortgaged) return;
        if (this.owner == null) {
            // offer to buy
            return;
        }
        if (this.owner == state.getCurrentPlayer()) return;
        int rentToTransfer = calculateRent(state);
        state.getCurrentPlayer().changeBalance(-rentToTransfer);
        this.owner.changeBalance(rentToTransfer);
    }

    public abstract int calculateRent(GameState state);

    public Player getOwner() {
        return owner;
    }
}
