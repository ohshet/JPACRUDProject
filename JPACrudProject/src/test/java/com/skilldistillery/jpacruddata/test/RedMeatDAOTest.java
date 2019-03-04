package com.skilldistillery.jpacruddata.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpacruddata.dao.RedMeatDAO;
import com.skilldistillery.jpacruddata.dao.RedMeatDAOImpl;
import com.skilldistillery.jpacruddata.entities.RedMeat;

class RedMeatDAOTest {

	private RedMeatDAO dao;
	private RedMeat redmeat;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		dao = new RedMeatDAOImpl();

	}

	@AfterEach
	void tearDown() throws Exception {
	}

//		@Test
//		void test_create_new_redmeat() {
//		redmeat = new RedMeat("Test Title", "Test Characters", "Test Text", "Test URL");
//		dao.create(redmeat);
//			assertTrue(redmeat.getId() != 0);
//			System.out.println(redmeat);
//			assertEquals("Test Title", redmeat.getTitle());
//			assertEquals("Test Characters", redmeat.getCharacters());
//			assertEquals("Test Text", redmeat.getText());
//			assertEquals("Test URL", redmeat.getImgUrl());
//		}

//		@Test
//		void test_modify_redmeat() {
//			RedMeat newRedMeat = new RedMeat("Mod Test Title", "Mod Test Characters", "Mod Test Text", "Mod Test URL");
//			RedMeat retrievedRedMeat = dao.update(2, newRedMeat);
//			assertEquals(2, retrievedRedMeat.getId());
//			assertEquals("Mod Test Title", retrievedRedMeat.getTitle());
//			assertEquals("Mod Test Characters", retrievedRedMeat.getCharacters());
//			assertEquals("Mod Test Text", retrievedRedMeat.getText());
//			assertEquals("Mod Test URL", retrievedRedMeat.getImgUrl());
//		}
//		
//		@Test
//		void test_destroy_redmeat() {
//			assertTrue(dao.destroy(2));
//
//		}

//	@Test
//	void test_search_by_id() {
//		List<RedMeat> meatList = null;
//		meatList = dao.searchId(1);
//		assertTrue(meatList.get(0).getId() == 1);
//	}

//	@Test
//	void test_search_by_title() {
//		List<RedMeat> meatList = null;
//		meatList = dao.searchTitle("Test");
//		assertTrue(meatList.size() == 7);
//		meatList = dao.searchTitle("test 4");
//		assertTrue(meatList.get(0).getId() == 7);
//
//	}
	
//	@Test
//	void test_search_by_Character() {
//		List<RedMeat> meatList = null;
//		meatList = dao.searchCharacter("test");
//		assertTrue(meatList.size() == 2);
//		meatList = dao.searchCharacter("chars 4");
//		assertTrue(meatList.get(0).getId() == 7);
//
//	}
	
	@Test
	void test_search_by_Text() {
		List<RedMeat> meatList = null;
		meatList = dao.searchText("text");
		assertTrue(meatList.size() == 7);
		meatList = dao.searchText("text 4");
		assertTrue(meatList.get(0).getId() == 5);

	}

}
