import model.Genre;
import model.Movie;
import model.PublicMovie;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    Movie testRegular;
    Movie testVip;

    @BeforeEach
    public void setUp() {
        testRegular = new PublicMovie();
        testRegular.setName("Regular");
        testRegular.setQuality("720p");
        testRegular.setSize(1);
        testRegular.addGenre(new Genre("Genre1"));
        testVip = new VipMovie();
        testVip.setName("VIP");
        testVip.setQuality("1080p");
        testVip.setSize(2);
    }

    @Test
    public void testSetName() {
        assertEquals("Regular", testRegular.getName());
        testRegular.setName("R");
        assertEquals("R", testRegular.getName());
        assertEquals("VIP", testVip.getName());
        testVip.setName("V");
        assertEquals("V", testVip.getName());
    }

    @Test
    public void testGetName(){
        assertEquals("Regular", testRegular.getName());
        assertEquals("VIP", testVip.getName());
    }

    @Test
    public void testSetSize() {
        assertEquals(1, testRegular.getSize());
        testRegular.setSize(1.1);
        assertEquals(1.1, testRegular.getSize());
        assertEquals(2, testVip.getSize());
        testVip.setSize(2.2);
        assertEquals(2.2, testVip.getSize());
    }

    @Test
    public void testGetSize(){
        assertEquals(1, testRegular.getSize());
        assertEquals(2, testVip.getSize());
    }

    @Test
    public void testSetQuality() {
        assertEquals("720p", testRegular.getQuality());
        testRegular.setQuality("1080p");
        assertEquals("1080p", testRegular.getQuality());
        assertEquals("1080p", testVip.getQuality());
        testVip.setQuality("720p");
        assertEquals("720p", testVip.getQuality());
    }

    @Test
    public void testGetQuality() {
        assertEquals("720p", testRegular.getQuality());
        assertEquals("1080p", testVip.getQuality());
    }

    @Test
    public void testPrintAllGenres() {

    }
}
