package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class CardSquare extends Square {
    String deckType;

    public CardSquare(String type, String name, int position, String deckType) {
        super(type, name, position);
        this.deckType = deckType;
    }

    @Override
    public void onLand(GameState state) {
    }
    
}
