import model.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenreTest {
    Genre testGenre1;

    @BeforeEach
    public void setUp() {
        testGenre1 = new Genre("Genre1");

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
}
