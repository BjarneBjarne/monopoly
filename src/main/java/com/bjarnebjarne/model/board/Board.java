package com.bjarnebjarne.model.board;

import java.util.List;
import java.util.NoSuchElementException;

import com.bjarnebjarne.model.board.squares.Square;

public class Board {
    private final List<Square> squares;

    public Board(List<Square> squares) {
        this.squares = squares;
    }

    public Square findNearestByType(String type, int fromPosition) {
        for (int i = fromPosition + 1; i <= fromPosition + squares.size(); i++) {
            String squareType = squares.get(i % squares.size()).getType();
            if (squareType.equals(type)) {
                return squares.get(i % squares.size());
            }
        }
        throw new NoSuchElementException("No square found with type " + type);
    }

    public Square getSquare(int position) {
        if (position < 0 || position >= squares.size()) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        return squares.get(position);
    }

    public int getSize() {
        return squares.size();
    }

    public List<Square> getSquares() {
        return squares;
    }
    
}
