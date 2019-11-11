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
        assertEquals("2001-01-01", movies.get(0).getDate());
        assertEquals("Genre1 Genre2", movies.get(0).getAllGenresName());
        assertEquals("Movie2", movies.get(1).getName());
        assertEquals("Upcoming", movies.get(1).getType());
        assertEquals("2002-02-02", movies.get(1).getDate());
        assertEquals("Genre1", movies.get(1).getAllGenresName());
    }
}