import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    Movie testMovie;

    @BeforeEach
    public void setUp(){
        testMovie = new Movie("name",800,2);
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
    public void testGetPrice(){
        assertEquals(2, testMovie.getPrice());
    }

    @Test
    public void testSetPrice(){
        assertEquals(2, testMovie.getPrice());
        testMovie.setPrice(3);
        assertEquals(3, testMovie.getPrice());
    }

    @Test
    public void testGetShowtime(){
        assertEquals(800, testMovie.getShowTime());
    }

    @Test
    public void testShowtime(){
        assertEquals(800, testMovie.getShowTime());
        testMovie.setShowTime(1100);
        assertEquals(1100, testMovie.getShowTime());
    }

}
