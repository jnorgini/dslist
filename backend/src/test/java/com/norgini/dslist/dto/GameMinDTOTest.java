package com.norgini.dslist.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.norgini.dslist.entities.Game;
import com.norgini.dslist.projections.GameMinProjection;

public class GameMinDTOTest {

    @Test
    public void testGameMinDTOWithProjection() {
        // Create a mock GameMinProjection for testing
        GameMinProjection projection = Mockito.mock(GameMinProjection.class);
        Mockito.when(projection.getId()).thenReturn(1L);
        Mockito.when(projection.getTitle()).thenReturn("Example Game");
        Mockito.when(projection.getGameYear()).thenReturn(2021);
        Mockito.when(projection.getImgUrl()).thenReturn("https://example.com/game.jpg");
        Mockito.when(projection.getShortDescription()).thenReturn("Short description of the game");

        // Create a GameMinDTO instance using the projection
        GameMinDTO gameMinDTO = new GameMinDTO(projection);

        // Assert that the GameMinDTO instance has the same values as the projection
        assertEquals(projection.getId(), gameMinDTO.getId());
        assertEquals(projection.getTitle(), gameMinDTO.getTitle());
        assertEquals(projection.getGameYear(), gameMinDTO.getYear());
        assertEquals(projection.getImgUrl(), gameMinDTO.getImgUrl());
        assertEquals(projection.getShortDescription(), gameMinDTO.getShortDescription());
    }

    @Test
    public void testGameMinDTOWithGameEntity() {
        // Create a Game entity for testing
        Game game = new Game();
        game.setId(1L);
        game.setTitle("Example Game");
        game.setYear(2021);
        game.setImgUrl("https://example.com/game.jpg");
        game.setShortDescription("Short description of the game");

        // Create a GameMinDTO instance using the Game entity
        GameMinDTO gameMinDTO = new GameMinDTO(game);

        // Assert that the GameMinDTO instance has the same values as the Game entity
        assertEquals(game.getId(), gameMinDTO.getId());
        assertEquals(game.getTitle(), gameMinDTO.getTitle());
        assertEquals(game.getYear(), gameMinDTO.getYear());
        assertEquals(game.getImgUrl(), gameMinDTO.getImgUrl());
        assertEquals(game.getShortDescription(), gameMinDTO.getShortDescription());
    }
}
