package com.bjarnebjarne.model.game;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.bjarnebjarne.model.board.Board;
import com.bjarnebjarne.model.board.squares.Square;
import com.bjarnebjarne.model.board.squares.UtilitySquare;
import com.bjarnebjarne.model.player.Player;

public class GameStateNumberPlayerOwns {

    @Test
    void numberPlayerOwnsShouldReturnZeroWhenZeroUtilitiesAreOwned() {
        Player player = new Player("Bjarne");

        UtilitySquare utility1 = new UtilitySquare("utility", "utility1", 0, 2, 3, new int[] {4, 10});
        UtilitySquare utility2 = new UtilitySquare("utility", "utility2", 1, 3, 3, new int[] {4, 10});

        Board board = new Board(List.of((Square) utility1, utility2));
        GameState state = new GameState(board, List.of(), List.of(), 0, List.of(player));

        assertEquals(0, state.numberPlayerOwns(utility1));
    }

    @Test
    void numberPlayerOwnsShouldReturnTwoWhenTwoUtilitiesAreOwned() {
        Player player = new Player("Bjarne");

        UtilitySquare utility1 = new UtilitySquare("utility", "utility1", 0, 2, 3, new int[] {4, 10});
        UtilitySquare utility2 = new UtilitySquare("utility", "utility2", 1, 3, 3, new int[] {4, 10});

        player.addProperty(utility1);
        player.addProperty(utility2);

        Board board = new Board(List.of((Square) utility1, utility2));
        GameState state = new GameState(board, List.of(), List.of(), 0, List.of(player));

        assertEquals(2, state.numberPlayerOwns(utility1));
    }

    @Test
    void numberPlayerOwnsShouldReturnOneWhenOneUtilityIsOwned() {
        Player player = new Player("Bjarne");

        UtilitySquare utility1 = new UtilitySquare("utility", "utility1", 0, 2, 3, new int[] {4, 10});
        UtilitySquare utility2 = new UtilitySquare("utility", "utility2", 1, 3, 3, new int[] {4, 10});

        player.addProperty(utility1);

        Board board = new Board(List.of((Square) utility1, utility2));
        GameState state = new GameState(board, List.of(), List.of(), 0, List.of(player));

        assertEquals(1, state.numberPlayerOwns(utility1));
    }
}
