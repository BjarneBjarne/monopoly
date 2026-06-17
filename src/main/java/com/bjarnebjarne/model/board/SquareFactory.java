package com.bjarnebjarne.model.board;

import com.bjarnebjarne.model.board.squares.CardSquare;
import com.bjarnebjarne.model.board.squares.FreeParkingSquare;
import com.bjarnebjarne.model.board.squares.GoSquare;
import com.bjarnebjarne.model.board.squares.GoToJailSquare;
import com.bjarnebjarne.model.board.squares.JailSquare;
import com.bjarnebjarne.model.board.squares.RailroadSquare;
import com.bjarnebjarne.model.board.squares.Square;
import com.bjarnebjarne.model.board.squares.StreetSquare;
import com.bjarnebjarne.model.board.squares.TaxSquare;
import com.bjarnebjarne.model.board.squares.UtilitySquare;

public class SquareFactory {
    public static Square create(SquareConfig config) {
        return switch (config.type) {
            case "go" -> new GoSquare(config.type, config.name, config.position);
            case "street" -> new StreetSquare(config.type, config.name, config.position, config.price, config.mortgage, config.rent, config.colorGroup, config.houseCost);
            case "card" -> new CardSquare(config.type, config.name, config.position, config.deckType);
            case "tax" -> new TaxSquare(config.type, config.name, config.position, config.taxAmount);
            case "railroad" -> new RailroadSquare(config.type, config.name, config.position, config.price, config.mortgage, config.rent);
            case "jail" -> new JailSquare(config.type, config.name, config.position);
            case "utility" -> new UtilitySquare(config.type, config.name, config.position, config.price, config.mortgage, config.rent);
            case "freeparking" -> new FreeParkingSquare(config.type, config.name, config.position);
            case "gotojail" -> new GoToJailSquare(config.type, config.name, config.position);
            default -> throw new IllegalStateException("Unknown type: " + (config.type));
        };
    }
}
