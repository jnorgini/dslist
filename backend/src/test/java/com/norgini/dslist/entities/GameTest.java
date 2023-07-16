package com.norgini.dslist.entities;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	public void testGettersAndSetters() {
		Long id = 1L;
		String title = "Title";
		Integer year = 2021;
		String genre = "Genre";
		String platforms = "Platforms";
		Double score = 9.5;
		String imgUrl = "image.jpg";
		String shortDescription = "Short Desc";
		String longDescription = "Long Desc";

		Game game = new Game();
		game.setId(id);
		game.setTitle(title);
		game.setYear(year);
		game.setGenre(genre);
		game.setPlatforms(platforms);
		game.setScore(score);
		game.setImgUrl(imgUrl);
		game.setShortDescription(shortDescription);
		game.setLongDescription(longDescription);

		// Test getter methods
		Assertions.assertEquals(id, game.getId());
		Assertions.assertEquals(title, game.getTitle());
		Assertions.assertEquals(year, game.getYear());
		Assertions.assertEquals(genre, game.getGenre());
		Assertions.assertEquals(platforms, game.getPlatforms());
		Assertions.assertEquals(score, game.getScore());
		Assertions.assertEquals(imgUrl, game.getImgUrl());
		Assertions.assertEquals(shortDescription, game.getShortDescription());
		Assertions.assertEquals(longDescription, game.getLongDescription());
	}

	@Test
	public void testEqualsAndHashCode() {
		Game game1 = new Game(1L, "Title", 2021, "Genre", "Platforms", 9.5, "image.jpg", "Short Desc", "Long Desc");

		Long id = 1L;

		int expectedHashCode = Objects.hash(id);
		Assertions.assertEquals(expectedHashCode, game1.hashCode());

		// Test when comparing with itself
		Assertions.assertTrue(game1.equals(game1));

		// Test when comparing with null
		Assertions.assertFalse(game1.equals(null));

		// Test when comparing with an object of a different class
		Assertions.assertFalse(game1.equals("game1"));

		// Test when comparing with an object of the same class and same id
		Game game2 = new Game(1L, "Title", 2021, "Genre", "Platforms", 9.5, "image.jpg", "Short Desc", "Long Desc");
		Assertions.assertTrue(game1.equals(game2));

		// Test when comparing with an object of the same class but different id
		Game game3 = new Game(2L, "Title", 2021, "Genre", "Platforms", 9.5, "image.jpg", "Short Desc", "Long Desc");
		Assertions.assertFalse(game1.equals(game3));
	}
}