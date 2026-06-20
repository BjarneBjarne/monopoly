package com.bjarnebjarne.model.game;

import java.util.List;

import com.bjarnebjarne.model.board.Board;
import com.bjarnebjarne.model.board.squares.PurchaseableSquare;
import com.bjarnebjarne.model.board.squares.Square;
import com.bjarnebjarne.model.board.squares.StreetSquare;
import com.bjarnebjarne.model.card.ChanceCard;
import com.bjarnebjarne.model.card.CommunityChestCard;
import com.bjarnebjarne.model.player.Player;

public class GameState {
    private List<Player> players;
    private int currentPlayerIndex;
    private Board board;
    private List<ChanceCard> chanceCards;
    private List<CommunityChestCard> communityChestCards;
    private RollResult lastRoll;

    public GameState(Board board, List<ChanceCard> chanceCards, List<CommunityChestCard> communityChestCards, int currentPlayerIndex, List<Player> players) {
        this.board = board;
        this.chanceCards = chanceCards;
        this.communityChestCards = communityChestCards;
        this.currentPlayerIndex = currentPlayerIndex;
        this.players = players;
        this.lastRoll = null;
    }
    
    public void sendToJail(Player player) {
        int jailPosition = board.findNearestByType("jail", player.getPosition()).getPosition();
        player.setPosition(jailPosition);
        player.setInJail(true);
    }

    public boolean playerOwnsColorGroup(Player player, String colorGroup) {
        int groupCount = 0;
        int ownedCount = 0;
        
        for (Square square : board.getSquares()) {
            if (square instanceof StreetSquare streetSquare &&
                streetSquare.getColorGroup().equals(colorGroup)) {
                groupCount++;
                if (streetSquare.getOwner() == player) {
                    ownedCount++;
                }
            }
        }

        return groupCount > 0 && ownedCount == groupCount;
    }

    public int numberPlayerOwns(Square referenceSquare) {
        int numberOwned = 0;
        Player referenceOwner = null;
        if (referenceSquare instanceof PurchaseableSquare ps) {
            referenceOwner = ps.getOwner();
        }
        if (referenceOwner == null) {
            return 0;
        }

        for (Square square : this.board.getSquares()) {
            if (square.getType().equals(referenceSquare.getType()) &&
                square instanceof PurchaseableSquare ps &&
                ps.getOwner() == referenceOwner) {
                numberOwned++;
            }
        }

        return numberOwned;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public Board getBoard() {
        return board;
    }

    public RollResult getLastRoll() {
        return lastRoll;
    }

    public void setLastRoll(RollResult lastRoll) {
        this.lastRoll = lastRoll;
    }
}
