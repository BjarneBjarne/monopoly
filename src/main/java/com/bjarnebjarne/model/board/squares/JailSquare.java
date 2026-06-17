package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.game.GameState;

public class JailSquare extends Square {

    public JailSquare(String type, String name, int position) {
        super(type, name, position);
    }

    @Override
    public void onLand(GameState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onLand'");
    }
    
}
