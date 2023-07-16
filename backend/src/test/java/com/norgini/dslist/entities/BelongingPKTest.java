package com.norgini.dslist.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BelongingPKTest {

	@Test
	void testEqualsAndHashCode() {

		Long gameId1 = 1L;
		String title1 = "Game 1";
		Integer year1 = 2021;
		String genre1 = "Genre 1";
		String platforms1 = "Platforms 1";
		Double score1 = 9.5;
		String imgUrl1 = "image1.jpg";
		String shortDescription1 = "Short Desc 1";
		String longDescription1 = "Long Desc 1";

		Game game1 = new Game();
		game1.setId(gameId1);
		game1.setTitle(title1);
		game1.setYear(year1);
		game1.setGenre(genre1);
		game1.setPlatforms(platforms1);
		game1.setScore(score1);
		game1.setImgUrl(imgUrl1);
		game1.setShortDescription(shortDescription1);
		game1.setLongDescription(longDescription1);

		Long gameId2 = 2L;
		String title2 = "Game 2";
		Integer year2 = 2022;
		String genre2 = "Genre 2";
		String platforms2 = "Platforms 2";
		Double score2 = 8.0;
		String imgUrl2 = "image2.jpg";
		String shortDescription2 = "Short Desc 2";
		String longDescription2 = "Long Desc 2";

		Game game2 = new Game();
		game2.setId(gameId2);
		game2.setTitle(title2);
		game2.setYear(year2);
		game2.setGenre(genre2);
		game2.setPlatforms(platforms2);
		game2.setScore(score2);
		game2.setImgUrl(imgUrl2);
		game2.setShortDescription(shortDescription2);
		game2.setLongDescription(longDescription2);

		// Create two instances of GameList
		Long listId1 = 1L;
		String name1 = "Game List 1";
		GameList list1 = new GameList(listId1, name1);

		Long listId2 = 2L;
		String name2 = "Game List 2";
		GameList list2 = new GameList(listId2, name2);

		// Create BelongingPK instances with different Game and GameList
		BelongingPK pk1 = new BelongingPK();
		pk1.setGame(game1);
		pk1.setList(list1);

		BelongingPK pk2 = new BelongingPK();
		pk2.setGame(game2);
		pk2.setList(list2);

		// Create another instance of BelongingPK with the same Game and GameList as pk1
		BelongingPK pk3 = new BelongingPK();
		pk3.setGame(game1);
		pk3.setList(list1);

		// Test equals() method
		Assertions.assertTrue(pk1.equals(pk1)); // Same instance
		Assertions.assertFalse(pk1.equals(null)); // null comparison
		Assertions.assertFalse(pk1.equals("some string")); // different class comparison
		Assertions.assertTrue(pk1.equals(pk3)); // Same Game and GameList
		Assertions.assertFalse(pk1.equals(pk2)); // Different Game and GameList

		// Test hashCode() method
		Assertions.assertEquals(pk1.hashCode(), pk3.hashCode()); // Same Game and GameList, so hash codes should be
																	// equal
		Assertions.assertNotEquals(pk1.hashCode(), pk2.hashCode()); // Different Game and GameList, so hash codes should
																	// be different

	}
}
