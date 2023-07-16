package com.norgini.dslist.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameListTest {

	@Test
	public void testGettersAndSetters() {
		Long id = 1L;
		String name = "My List";

		GameList list = new GameList();
		list.setId(id);
		list.setName(name);

		// Test getter methods
		Assertions.assertEquals(id, list.getId());
		Assertions.assertEquals(name, list.getName());
	}

	@Test
	public void testEqualsAndHashCode() {
		GameList list1 = new GameList(1L, "My List");
		GameList list2 = new GameList(1L, "My List");
		GameList list3 = new GameList(2L, "Another List");

		// Test equals() method
		Assertions.assertTrue(list1.equals(list1));
		Assertions.assertTrue(list1.equals(list2));
		Assertions.assertFalse(list1.equals(list3));
		Assertions.assertFalse(list1.equals(null));
		Assertions.assertFalse(list1.equals("My List"));

		// Test hashCode() method
		Assertions.assertEquals(list1.hashCode(), list2.hashCode());
		Assertions.assertNotEquals(list1.hashCode(), list3.hashCode());
	}
}