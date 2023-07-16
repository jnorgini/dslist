package com.norgini.dslist.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.norgini.dslist.dto.GameDTO;
import com.norgini.dslist.dto.GameMinDTO;
import com.norgini.dslist.entities.Game;
import com.norgini.dslist.services.GameService;

@WebMvcTest(GameController.class)
public class GameControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GameService gameService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindAll() throws Exception {
		// Mocking the service response
		Game game1 = new Game(1L, "Game 1", 2022, "Action", "PC", 9.0, "image1.jpg", "Short description 1",
				"Long description 1");
		Game game2 = new Game(2L, "Game 2", 2023, "Adventure", "PS4", 8.5, "image2.jpg", "Short description 2",
				"Long description 2");
		List<Game> games = Arrays.asList(game1, game2);
		when(gameService.findAll()).thenReturn(convertToGameMinDTOList(games));

		// Performing the request
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/games")).andExpect(status().isOk()).andReturn();

		// Verifying the response
		String responseBody = result.getResponse().getContentAsString();
	}

	private List<GameMinDTO> convertToGameMinDTOList(List<Game> games) {
		return games.stream().map(GameMinDTO::new).toList();
	}

	@Test
	public void testFindById() throws Exception {
		// Mocking the service response
		Long gameId = 1L;
		Game game = new Game(gameId, "Game 1", 2022, "Action", "PC", 9.0, "image.jpg", "Short description",
				"Long description");
		when(gameService.findById(gameId)).thenReturn(new GameDTO(game));

		// Performing the request
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/games/{id}", gameId)).andExpect(status().isOk())
				.andReturn();

		// Verifying the response
		String responseBody = result.getResponse().getContentAsString();
		
	}
}