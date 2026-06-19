package com.bjarnebjarne.model.game;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.bjarnebjarne.model.board.Board;
import com.bjarnebjarne.model.board.squares.Square;
import com.bjarnebjarne.model.board.squares.StreetSquare;
import com.bjarnebjarne.model.player.Player;

class GameStateTestColorGroupTest {

    @Test
    void playerOwnsColorGroupReturnsFalseWhenPlayerOwnsNoPropertiesInGroup() {
        Player player = new Player("Alice");

        StreetSquare brown1 = new StreetSquare(
            "street", "Mediterranean Avenue", 1, 60, 30,
            new int[] {2, 10, 30, 90, 160, 250}, "brown", 50
        );
        StreetSquare brown2 = new StreetSquare(
            "street", "Baltic Avenue", 3, 60, 30,
            new int[] {4, 20, 60, 180, 320, 450}, "brown", 50
        );

        Board board = new Board(List.of((Square) brown1, brown2));
        GameState state = new GameState(board, List.of(), List.of(), 0, List.of(player));

        assertFalse(state.playerOwnsColorGroup(player, "brown"));
    }

    @Test
    void playerOwnsColorGroupReturnsFalseWhenPlayerOwnsOnlySomePropertiesInGroup() {
        Player player = new Player("Alice");

        StreetSquare brown1 = new StreetSquare(
            "street", "Mediterranean Avenue", 1, 60, 30,
            new int[] {2, 10, 30, 90, 160, 250}, "brown", 50
        );
        StreetSquare brown2 = new StreetSquare(
            "street", "Baltic Avenue", 3, 60, 30,
            new int[] {4, 20, 60, 180, 320, 450}, "brown", 50
        );

        player.addProperty(brown2);

        Board board = new Board(List.of((Square) brown1, brown2));
        GameState state = new GameState(board, List.of(), List.of(), 0, List.of(player));

        assertFalse(state.playerOwnsColorGroup(player, "brown"));
    }

    @Test
    void playerOwnsColorGroupReturnsTrueWhenPlayerOwnsOnlyAllPropertiesInGroup() {
        Player player = new Player("Alice");

        StreetSquare brown1 = new StreetSquare(
            "street", "Mediterranean Avenue", 1, 60, 30,
            new int[] {2, 10, 30, 90, 160, 250}, "brown", 50
        );
        StreetSquare brown2 = new StreetSquare(
            "street", "Baltic Avenue", 3, 60, 30,
            new int[] {4, 20, 60, 180, 320, 450}, "brown", 50
        );

        player.addProperty(brown1);
        player.addProperty(brown2);

        Board board = new Board(List.of((Square) brown1, brown2));
        GameState state = new GameState(board, List.of(), List.of(), 0, List.of(player));

        assertTrue(state.playerOwnsColorGroup(player, "brown"));
    }
}
