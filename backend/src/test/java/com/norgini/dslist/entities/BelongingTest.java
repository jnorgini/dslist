package com.norgini.dslist.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BelongingTest {

	@Test
	void testEqualsAndHashCode() {
		// Create two instances of GameList with the same ID and different names
		Long id1 = 1L;
		String name1 = "Game List 1";
		GameList list1 = new GameList(id1, name1);

		Long id2 = 1L;
		String name2 = "Game List 2";
		GameList list2 = new GameList(id2, name2);

		// Create a Game instance
		Long gameId = 1L;
		String title = "Title";
		Integer year = 2021;
		String genre = "Genre";
		String platforms = "Platforms";
		Double score = 9.5;
		String imgUrl = "image.jpg";
		String shortDescription = "Short Desc";
		String longDescription = "Long Desc";

		Game game = new Game();
		game.setId(gameId);
		game.setTitle(title);
		game.setYear(year);
		game.setGenre(genre);
		game.setPlatforms(platforms);
		game.setScore(score);
		game.setImgUrl(imgUrl);
		game.setShortDescription(shortDescription);
		game.setLongDescription(longDescription);

		// Create Belonging instances with the same GameList and Game but different
		// positions
		Belonging belonging1 = new Belonging();
		belonging1.setList(list1);
		belonging1.setGame(game);
		belonging1.setPosition(1);

		Belonging belonging2 = new Belonging();
		belonging2.setList(list2);
		belonging2.setGame(game);
		belonging2.setPosition(2);

		// Test equals() method
		Assertions.assertEquals(belonging1, belonging2);
		Assertions.assertEquals(belonging2, belonging1);

		// Test hashCode() method
		Assertions.assertEquals(belonging1.hashCode(), belonging2.hashCode());

		// Test getGame() method
		Assertions.assertEquals(game, belonging1.getGame());
		Assertions.assertEquals(game, belonging2.getGame());

		// Test getList() method
		Assertions.assertEquals(list1, belonging1.getList());
		Assertions.assertEquals(list2, belonging2.getList());

		// Test equals() method with self-reference and null comparison
		Assertions.assertTrue(belonging1.equals(belonging1));
		Assertions.assertFalse(belonging1.equals(null));

		// Test equals() method with self-reference, null comparison, and different
		// class
		Assertions.assertTrue(belonging1.equals(belonging1));
		Assertions.assertFalse(belonging1.equals(null));
		Assertions.assertFalse(belonging1.equals("some string"));

	}

	@Test
	void testPosition() {
		// Create a Belonging instance
		Belonging belonging = new Belonging();
		Integer position = 10;

		// Set the position
		belonging.setPosition(position);

		// Test getPosition() method
		Assertions.assertEquals(position, belonging.getPosition());

	}
}
