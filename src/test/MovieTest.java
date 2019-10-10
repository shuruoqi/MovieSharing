import model.Movie;
import model.RegularMovie;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    Movie testRegular;
    Movie testVip;

    @BeforeEach
    public void setUp() {
        testRegular = new RegularMovie("Regular", "720p", 1);
        testVip = new VipMovie("VIP", "1080p", 2);
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
}
