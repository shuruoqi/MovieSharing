import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VipMovieTest {
    VipMovie testMovie;

    @BeforeEach
    public void setUp(){
        testMovie = new VipMovie("name","1080p",2);
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
        assertEquals("VIP",testMovie.getType());
    }

    @Test
    public void testGetSize(){
        assertEquals(2, testMovie.getSize());
    }

    @Test
    public void testSetSize(){
        assertEquals(2, testMovie.getSize());
        testMovie.setSize(3);
        assertEquals(3, testMovie.getSize());
    }

    @Test
    public void testGetQuality(){
        assertEquals("1080p", testMovie.getQuality());
    }

    @Test
    public void testSetQuality(){
        assertEquals("1080p", testMovie.getQuality());
        testMovie.setQuality("720p");
        assertEquals("720p", testMovie.getQuality());
    }
}
