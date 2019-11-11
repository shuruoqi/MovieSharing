import model.PublicMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PublicMovieTest {
    PublicMovie testMovie;

    @BeforeEach
    public void setUp(){
        testMovie = new PublicMovie();

        testMovie.setName("name");
        testMovie.setDate("2001-01-01");
    }

    @Test
    public void testGetName(){
        assertEquals("name", testMovie.getName());
    }

    @Test
    public void testSetName(){
        assertEquals("name", testMovie.getName());
        testMovie.setName("name2");
        assertEquals("name2", testMovie.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("Public",testMovie.getType());
    }

    @Test
    public void testGetDate(){
        assertEquals("2001-01-01", testMovie.getDate());
    }

    @Test
    public void testSetDate(){
        assertEquals("2001-01-01", testMovie.getDate());
        testMovie.setDate("2002-02-02");
        assertEquals("2002-02-02", testMovie.getDate());
    }
}
