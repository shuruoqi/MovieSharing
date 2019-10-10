import model.Movie;
import model.PublicMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.WatchList;

import static org.junit.jupiter.api.Assertions.*;

public class WatchListTest {
    WatchList testWatchList;
    Movie testMovie1;
    Movie testMovie2;

    @BeforeEach
    public void setUp() {
        testWatchList = new WatchList();
        testMovie1 = new PublicMovie();

        testMovie1.setName("name1");
        testMovie1.setQuality("720p");
        testMovie1.setSize(2);
        testMovie2 = new PublicMovie();
        testMovie2.setName("name2");
        testMovie2.setQuality("1080p");
        testMovie2.setSize(12);
        testWatchList.movies.add(testMovie1);
    }

    @Test
    public void testGetList() {
        assertEquals(1, testWatchList.getList().size());
        assertEquals("name1", testWatchList.getList().get(0).getName());
    }

    @Test
    public void testCheckRepetition() {
        assertTrue(testWatchList.checkRepetition(testMovie1));
        assertFalse(testWatchList.checkRepetition(testMovie2));
    }
}
