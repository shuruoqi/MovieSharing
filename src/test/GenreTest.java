import model.Genre;
import model.Movie;
import model.PublicMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreTest {
    Genre testGenre1;
    Movie testMovie1;

    @BeforeEach
    public void setUp() {
        testGenre1 = new Genre("Genre1");
        testMovie1 = new PublicMovie();
        testMovie1.setName("movie1");
        testMovie1.setDate(2001);
        testGenre1.addMovie(testMovie1);
    }

    @Test
    public void testGetName() {
        assertEquals("Genre1", testGenre1.getName());
    }

    @Test
    public void testSetName() {
        assertEquals("Genre1", testGenre1.getName());
        testGenre1.setName("G1");
        assertEquals("G1", testGenre1.getName());
    }

    @Test
    public void testGetMovies() {
        assertEquals(1, testGenre1.getMovies().size());
        assertEquals("movie1", testGenre1.getMovies().get(0).getName());
    }

    @Test
    public void testHashCode() {
        assertEquals(2129335117, testGenre1.hashCode());
    }
}
