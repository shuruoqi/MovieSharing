import model.Movie;
import model.RegularMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Watchlist;

import static org.junit.jupiter.api.Assertions.*;

public class WatchlistTest {
    Watchlist testWatchlist;
    Movie testMovie1;
    Movie testMovie2;

    @BeforeEach
    public void setUp() {
        testWatchlist = new Watchlist();
        testMovie1 = new RegularMovie("name1","720p",2);
        testMovie2 = new RegularMovie("name2","1080p",12);
        testWatchlist.listSetUp();
        testWatchlist.watchList.add(testMovie1);
    }

    @Test
    public void testGetList() {
        assertEquals(1,testWatchlist.watchList.size());
        assertEquals("name1", testWatchlist.watchList.get(0).getName());
    }

    @Test
    public void testAddToListResult() {
        assertTrue(testWatchlist.addToListResult("Yes"));
        assertFalse(testWatchlist.addToListResult("No"));
    }

    @Test
    public void testDeleteFromListResult() {
        assertTrue(testWatchlist.deleteFromWatchlistResult("Yes"));
        assertFalse(testWatchlist.deleteFromWatchlistResult("No"));
    }

    @Test
    public void testCheckRepetition() {
        assertTrue(testWatchlist.checkRepetition(testMovie1));
        assertFalse(testWatchlist.checkRepetition(testMovie2));
    }
}
