import model.Genre;
import model.Movie;
import model.PublicMovie;
import model.UpcomingMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    Movie testPublic;
    Movie testUpcoming;

    @BeforeEach
    public void setUp() {
        testPublic = new PublicMovie();
        testPublic.setName("Public");
        testPublic.setDate("2001-01-01");
        testPublic.addGenre(new Genre("Genre1"));
        testUpcoming = new UpcomingMovie();
        testUpcoming.setName("Upcoming");
        testUpcoming.setDate("2002-02-02");
    }

    @Test
    public void testSetName() {
        assertEquals("Public", testPublic.getName());
        testPublic.setName("P");
        assertEquals("P", testPublic.getName());
        assertEquals("Upcoming", testUpcoming.getName());
        testUpcoming.setName("U");
        assertEquals("U", testUpcoming.getName());
    }

    @Test
    public void testGetName(){
        assertEquals("Public", testPublic.getName());
        assertEquals("Upcoming", testUpcoming.getName());
    }

    @Test
    public void testSetDate() {
        assertEquals("2001-01-01", testPublic.getDate());
        testPublic.setDate("2011-11-11");
        assertEquals("2011-11-11", testPublic.getDate());
        assertEquals("2002-02-02", testUpcoming.getDate());
        testUpcoming.setDate("2012-12-12");
        assertEquals("2012-12-12", testUpcoming.getDate());
    }

    @Test
    public void testGetDate(){
        assertEquals("2001-01-01", testPublic.getDate());
        assertEquals("2002-02-02", testUpcoming.getDate());
    }

    @Test
    public void testAddGenre() {
        testUpcoming.addGenre(new Genre("Genre1"));
        assertEquals("Genre1" , testUpcoming.getGenres().get(0).getName());
    }

    @Test
    public void testGetGenre() {
        assertEquals("Genre1" , testPublic.getGenres().get(0).getName());
    }
}
