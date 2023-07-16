package com.norgini.dslist.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.norgini.dslist.dto.GameDTO;
import com.norgini.dslist.dto.GameMinDTO;
import com.norgini.dslist.entities.Game;
import com.norgini.dslist.projections.GameMinProjection;
import com.norgini.dslist.repositories.GameRepository;

class GameServiceTest {

	@Mock
	private GameRepository gameRepository;

	@InjectMocks
	private GameService gameService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		// Arrange
		Long gameId = 1L;
		Game game = new Game();
		game.setId(gameId);
		when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

		// Act
		GameDTO result = gameService.findById(gameId);

		// Assert
		assertEquals(gameId, result.getId());
		verify(gameRepository, times(1)).findById(gameId);
	}

	@Test
	void testFindAll() {
		// Arrange
		List<Game> games = Arrays.asList(new Game(), new Game());
		when(gameRepository.findAll()).thenReturn(games);

		// Act
		List<GameMinDTO> result = gameService.findAll();

		// Assert
		assertEquals(games.size(), result.size());
		verify(gameRepository, times(1)).findAll();
	}

	@Test
	void testFindByList() {
		// Arrange
		Long listId = 1L;
		List<GameMinProjection> gameProjections = Arrays.asList(mock(GameMinProjection.class),
				mock(GameMinProjection.class));
		when(gameRepository.searchByList(listId)).thenReturn(gameProjections);

		// Act
		List<GameMinDTO> result = gameService.findByList(listId);

		// Assert
		assertEquals(gameProjections.size(), result.size());
		verify(gameRepository, times(1)).searchByList(listId);
	}
}