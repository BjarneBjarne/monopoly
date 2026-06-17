package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class GoToJailSquare extends Square {

    public GoToJailSquare(String type, String name, int position) {
        super(type, name, position);
    }

    @Override
    public void onLand(GameState state) {
        state.sendToJail(state.getCurrentPlayer());
    }
}
