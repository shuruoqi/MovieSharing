import model.Load;
import model.Movie;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadTest {
    Load testLoad = new Load();
    ArrayList<Movie> movies;

    @Test
    void testLoad() throws IOException {
        movies = testLoad.load("./data/LoadTestFile.txt");

        assertEquals("Movie1", movies.get(0).getName());
        assertEquals("Public", movies.get(0).getType());
        assertEquals("1080p", movies.get(0).getQuality());
        assertEquals(1.0, movies.get(0).getSize());
        assertEquals("Movie2", movies.get(1).getName());
        assertEquals("VIP", movies.get(1).getType());
        assertEquals("720p", movies.get(1).getQuality());
        assertEquals(2.0, movies.get(1).getSize());
    }
}