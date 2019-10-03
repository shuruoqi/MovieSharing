import model.Movie;
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
        testMovie1 = new Movie("name",800,2);
        testMovie2 = new Movie("name2",900,12);
        testWatchlist.watchListSetUp();
        testWatchlist.watchList.add(testMovie1);
    }

    @Test
    public void testGetWatchList() {
        assertEquals(1,testWatchlist.watchList.size());
        assertEquals("name", testWatchlist.watchList.get(0).getName());
    }

    @Test
    public void testAddToWatchlistResult() {
        assertEquals(true,testWatchlist.addToWatchlistResult("Yes"));
        assertEquals(false,testWatchlist.addToWatchlistResult("No"));
    }

    @Test
    public void testDeleteFromWatchlistResult() {
        assertEquals(true, testWatchlist.deleteFromWatchlistResult("Yes"));
        assertEquals(false, testWatchlist.deleteFromWatchlistResult("No"));
    }

    @Test
    public void testCheckRepetition() {
        assertTrue(testWatchlist.checkRepetition(testMovie1));
        assertFalse(testWatchlist.checkRepetition(testMovie2));
    }
}
