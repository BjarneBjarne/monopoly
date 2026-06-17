package com.bjarnebjarne.model.board;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.bjarnebjarne.model.board.squares.Square;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BoardLoader {
    public static Board load(String boardFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<SquareConfig> configs = mapper.readValue(
            BoardLoader.class.getResourceAsStream(boardFile),
            new TypeReference<List<SquareConfig>>() {}
        );
        List<Square> squaresList = configs.stream()
            .map(SquareFactory::create)
            .collect(Collectors.toList());
        return new Board(squaresList);
    }
}
