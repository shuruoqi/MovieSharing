import model.Load;
import org.junit.jupiter.api.Test;
import ui.Watchlist;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadTest {
    Load testLoad = new Load();

    @Test
    public void testLoad() throws IOException {
        testLoad.load("./data/LoadTestFile.txt");
        assertEquals("Movie1", testLoad.movies.get(0).getName());
        assertEquals(1000, testLoad.movies.get(0).getShowTime());
        assertEquals(1, testLoad.movies.get(0).getPrice());
        assertEquals("Movie2", testLoad.movies.get(1).getName());
        assertEquals(2000, testLoad.movies.get(1).getShowTime());
        assertEquals(2, testLoad.movies.get(1).getPrice());
    }
}