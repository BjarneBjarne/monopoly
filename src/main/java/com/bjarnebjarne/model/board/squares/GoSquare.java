package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class GoSquare extends Square {

    public GoSquare(String type, String name, int position) {
        super(type, name, position);
    }

    @Override
    public void onLand(GameState state) {
        state.getCurrentPlayer().changeBalance(200);
    }
}
