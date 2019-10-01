import model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Watchlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WatchlistTest {
    Watchlist testWatchlist;
    Movie testMovie;

    @BeforeEach
    public void setUp() {
        testWatchlist = new Watchlist();
        testMovie = new Movie("name",800,2);
        testWatchlist.watchListSetUp();
        testWatchlist.watchList.add(testMovie);
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
}
