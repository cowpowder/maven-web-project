/**
 * 
 */
package com.sddevops.junit_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author keyongenesis - Republic Polytechnic
 *
 */
class SongCollectionTest {

	private SongCollection sc;
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private final int SONG_COLLECTION_SIZE = 4;
	private final int SONG_CAPACITY_LIMIT = 5;
	//if you want to run once per class - > like creating a database connection or start up of server then you might want to annotate with at before all
	
	/**
	 * @throws java.lang.Exception
	 */
	
	// Before each means - the method will run before and after every test case
	// this runs before every each test case! 
	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		sc = new SongCollection();
		s1 = new Song("0001","good 4 u","Olivia Rodrigo",3.59);
		s2 = new Song("0002","Peaches","Justin Bieber",3.18);
		s3 = new Song("0003","MONTERO","Lil Nas X",2.3);
		s4 = new Song("0004","bad guy","Billie Eilish",3.14);
		
		
		sc.addSong(s1);
		sc.addSong(s2);
		sc.addSong(s3);
		sc.addSong(s4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#SongCollection()}.
	 */
	@Test
	void testSongCollection() {
		// fail("Not yet implemented");
	    System.out.println("@Test: testSongCollection");
	    assertTrue(true);  // try true and false

	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#SongCollection(int)}.
	 */
	@Test
	void testSongCollectionInt() {
		// fail("Not yet implemented");
	    System.out.println("@Test: testSongCollectionInt");
	    assertTrue(true);  // try true and false
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#getSongs()}.
	 */
	@Test
	void testGetSongs() {
		// fail("Not yet implemented");
		List<Song> testSc = sc.getSongs();
		//Assert
		//Assert that the Song Collection is not empty after invoking getSongs function 
		//assertTrue(!testSc.isEmpty());
		assertFalse(testSc.isEmpty());
		// assert that Song collection size contains the correct number of songs inside
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE);
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#addSong(com.sddevops.junit_maven.eclipse.Song)}.
	 */
	@Test
	void testAddSong() {
		//fail("Not yet implemented");
		List<Song> testSc = sc.getSongs();
		//Assert that Song collection is equals to song collection size 4
		assertEquals(testSc.size(), SONG_COLLECTION_SIZE);
		//Act - Add song function to add 1 additional song
		sc.addSong(s1);
		// Assert that Song Collection is equals to song collection size 4 + 1
		// We assert that the initial song collection size is now 5
		assertEquals(sc.getSongs().size(), SONG_COLLECTION_SIZE+1);
		//means "a passed parameter must not be null": if it is null then the test case fails.
		assertNotNull(s1);
		//Assert that Song Collection cannot be more than 5 (max capacity) 
		assertEquals(sc.getSongs().size(),SONG_CAPACITY_LIMIT);
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#sortSongsByTitle()}.
	 */
	@Test
	void testSortSongsByTitle() {
		//fail("Not yet implemented");
		
		//Act 
		List<Song> testSc = sc.sortSongsByTitle();
		
		//Arrange 
		String newSongTitle1 = testSc.get(0).getTitle();
		String newSongTitle2 =  testSc.get(1).getTitle();
		String newSongTitle3 =  testSc.get(2).getTitle();
		String newSongTitle4 =  testSc.get(3).getTitle();
		
		//Assert that the Song list sorted from [A-Z] [a-z]
		assertEquals(newSongTitle1,"MONTERO");
		assertEquals(newSongTitle2,"Peaches");
		assertEquals(newSongTitle3,"bad guy");
		assertEquals(newSongTitle4,"good 4 u");
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#sortSongsBySongLength()}.
	 */
	@Test
	void testSortSongsBySongLength() {
		// fail("Not yet implemented");
		//Act 
		List<Song> testSc = sc.sortSongsBySongLength();
		
		//arrange 
		double newSongLength1 = testSc.get(0).getSongLength();
		double newSongLength2 = testSc.get(1).getSongLength();
		double newSongLength3 = testSc.get(2).getSongLength();
		double newSongLength4 = testSc.get(3).getSongLength();
		
		//Assert that the the song list is sorted from largest to shortest song length 
		assertTrue(Double.compare(newSongLength1, newSongLength2) > 0);
		assertTrue(Double.compare(newSongLength2, newSongLength3) > 0 );
		assertTrue(Double.compare(newSongLength3, newSongLength4) > 0);
	
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#findSongsById(java.lang.String)}.
	 */
	@Test
	void testFindSongsById() {
		// fail("Not yet implemented");
		//Act 
		Song validId = sc.findSongsById("0003");
		Song invalidId = sc.findSongsById("Invalid id");
				
		//assert we retrieve a valid song 
		assertNotNull(validId);
		//assert retrieve the accurate song based on Id 
		assertEquals(validId.getId(),"0003");
		//assert if we input invalid id : we get a null 
		assertNull(invalidId);
		
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#findSongByTitle(java.lang.String)}.
	 */
	@Test
	void testFindSongByTitle() {
		// fail("Not yet implemented");
		
		Song validSong = sc.findSongByTitle("MONTERO");
		Song invalidSong = sc.findSongByTitle("Invalid Song Title");
		
		//assert we retrieve a valid song 
		assertNotNull(validSong);
		//assert retrieve the accurate song based on Id 
		assertEquals(validSong.getId(),"0003");
		//assert if we input invalid id : we get a null 
		assertNull(invalidSong);
	}

}
