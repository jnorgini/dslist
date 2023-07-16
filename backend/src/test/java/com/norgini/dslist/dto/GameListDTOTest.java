package com.norgini.dslist.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.norgini.dslist.entities.GameList;

public class GameListDTOTest {

    @Test
    public void testGameListDTO() {
        // Create a GameList entity for testing
        GameList gameList = new GameList();
        gameList.setId(1L);
        gameList.setName("My Game List");

        // Create a GameListDTO instance using the GameList entity
        GameListDTO gameListDTO = new GameListDTO(gameList);

        // Assert that the GameListDTO instance has the same values as the GameList entity
        assertEquals(gameList.getId(), gameListDTO.getId());
        assertEquals(gameList.getName(), gameListDTO.getName());
    }
}
