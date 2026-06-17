package com.bjarnebjarne.model.board.squares;

import com.bjarnebjarne.model.board.Landable;

public abstract class Square implements Landable {
    String type;
    String name;
    int position;

    public Square(String type, String name, int position) {
        this.type = type;
        this.name = name;
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }
}
