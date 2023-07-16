package com.norgini.dslist.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import com.norgini.dslist.entities.Game;

public class GameDTOTest {

    @Test
    public void testGameDTO() {
        // Create a Game entity for testing
        Game game = new Game();
        game.setId(1L);
        game.setTitle("Example Game");
        game.setYear(2021);
        game.setGenre("Action");
        game.setPlatforms("PC, Xbox, PlayStation");
        game.setScore(8.5);
        game.setImgUrl("https://example.com/game.jpg");
        game.setShortDescription("Short description of the game");
        game.setLongDescription("Long description of the game");

        // Create a GameDTO instance using the Game entity
        GameDTO gameDTO = new GameDTO(game);

        // Assert that the GameDTO instance has the same values as the Game entity
        assertEquals(game.getId(), gameDTO.getId());
        assertEquals(game.getTitle(), gameDTO.getTitle());
        assertEquals(game.getYear(), gameDTO.getYear());
        assertEquals(game.getGenre(), gameDTO.getGenre());
        assertEquals(game.getPlatforms(), gameDTO.getPlatforms());
        assertEquals(game.getScore(), gameDTO.getScore());
        assertEquals(game.getImgUrl(), gameDTO.getImgUrl());
        assertEquals(game.getShortDescription(), gameDTO.getShortDescription());
        assertEquals(game.getLongDescription(), gameDTO.getLongDescription());
    }
}
