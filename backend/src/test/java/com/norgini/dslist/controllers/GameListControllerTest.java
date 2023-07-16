package com.norgini.dslist.controllers;

import static org.mockito.Mockito.mock;
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

import com.norgini.dslist.dto.GameListDTO;
import com.norgini.dslist.dto.GameMinDTO;
import com.norgini.dslist.entities.GameList;
import com.norgini.dslist.services.GameListService;
import com.norgini.dslist.services.GameService;

@WebMvcTest(GameListController.class)
public class GameListControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GameListService gameListService;

	@MockBean
	private GameService gameService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindAll() throws Exception {
		// Mocking the service response
		GameListDTO list1 = new GameListDTO(new GameList(1L, "List 1"));
		GameListDTO list2 = new GameListDTO(new GameList(2L, "List 2"));
		List<GameListDTO> gameLists = Arrays.asList(list1, list2);
		when(gameListService.findAll()).thenReturn(gameLists);

		// Performing the request
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/lists")).andExpect(status().isOk()).andReturn();

		// Verifying the response
		String responseBody = result.getResponse().getContentAsString();
	}

	@Test
	public void testFindByList() throws Exception {
		// Mocking the service response
		Long listId = 1L;
		GameMinDTO game1 = mock(GameMinDTO.class);
		GameMinDTO game2 = mock(GameMinDTO.class);
		List<GameMinDTO> gameMinDTOs = Arrays.asList(game1, game2);
		when(gameService.findByList(listId)).thenReturn(gameMinDTOs);

		// Performing the request
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/lists/{listId}/games", listId))
				.andExpect(status().isOk()).andReturn();

		// Verifying the response
		String responseBody = result.getResponse().getContentAsString();
	}
}