package com.norgini.dslist.services;

import com.norgini.dslist.dto.GameListDTO;
import com.norgini.dslist.entities.GameList;
import com.norgini.dslist.projections.GameMinProjection;
import com.norgini.dslist.repositories.GameListRepository;
import com.norgini.dslist.repositories.GameRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GameListServiceTest {

	@Mock
	private GameListRepository gameListRepository;

	@Mock
	private GameRepository gameRepository;

	@InjectMocks
	private GameListService gameListService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindAll() {
		// Mock data
		GameList gameList1 = new GameList();
		gameList1.setId(1L);
		gameList1.setName("List 1");

		GameList gameList2 = new GameList();
		gameList2.setId(2L);
		gameList2.setName("List 2");

		List<GameList> gameLists = Arrays.asList(gameList1, gameList2);

		// Mock the repository behavior
		when(gameListRepository.findAll()).thenReturn(gameLists);

		// Perform the service method
		List<GameListDTO> result = gameListService.findAll();

		// Verify the results
		assertEquals(2, result.size());
		assertEquals("List 1", result.get(0).getName());
		assertEquals("List 2", result.get(1).getName());

		// Verify that the repository method was called
		verify(gameListRepository, times(1)).findAll();
	}

	@Test
	public void testMove() {
		// Mock data
		Long listId = 1L;
		int sourceIndex = 0;
		int destinationIndex = 2;

		GameMinProjection game1 = mock(GameMinProjection.class);
		when(game1.getId()).thenReturn(1L);
		when(game1.getPosition()).thenReturn(0);

		GameMinProjection game2 = mock(GameMinProjection.class);
		when(game2.getId()).thenReturn(2L);
		when(game2.getPosition()).thenReturn(1);

		GameMinProjection game3 = mock(GameMinProjection.class);
		when(game3.getId()).thenReturn(3L);
		when(game3.getPosition()).thenReturn(2);

		List<GameMinProjection> games = new ArrayList<>(Arrays.asList(game1, game2, game3));

		// Mock the repository behavior
		when(gameRepository.searchByList(listId)).thenReturn(games);

		// Perform the service method
		gameListService.move(listId, sourceIndex, destinationIndex);

		// Verify the positions after the move
		assertEquals(1, games.get(0).getPosition());
		assertEquals(2, games.get(1).getPosition());
		assertEquals(0, games.get(2).getPosition());

		// Verify that the repository method was called
		verify(gameRepository, times(1)).searchByList(eq(listId));
		verify(gameListRepository, times(3)).updateBelongingPosition(eq(listId), anyLong(), anyInt());

		// Verify the min and max values
		int min = Math.min(sourceIndex, destinationIndex);
		int max = Math.max(sourceIndex, destinationIndex);
		assertEquals(min, sourceIndex);
		assertEquals(max, destinationIndex);

	}
}
