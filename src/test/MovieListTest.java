import exception.ReputationException;
import exception.VipException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieListTest {
    WatchList testWatchloadList;
    Movie testMovie1;
    Movie testMovie2;
    Movie testMovie3;

    @BeforeEach
    public void setUp() throws ReputationException, VipException {
        testWatchloadList = new WatchList();
        testMovie1 = new PublicMovie();
        testMovie1.setName("name1");
        testMovie1.setQuality("720p");
        testMovie1.setSize(2);
        testMovie2 = new VipMovie();
        testMovie2.setName("name2");
        testMovie2.setQuality("1080p");
        testMovie2.setSize(12);
        testMovie3 = new PublicMovie();
        testMovie3.setName("name3");
        testMovie3.setQuality("720p");
        testMovie3.setSize(2);
        testWatchloadList.add(testMovie1);
    }

    @Test
    public void testDelete() {
        testWatchloadList.delete("name1");
        assertEquals(0, testWatchloadList.getList().size());
    }

    @Test
    public void testGetMovie() {
        assertEquals("name1",testWatchloadList.getMovie("name1").getName());
        assertEquals(null,testWatchloadList.getMovie("name2"));
    }

    @Test
    public void testCheckRepetition() {
        assertTrue(testWatchloadList.checkRepetition(testMovie1));
        assertFalse(testWatchloadList.checkRepetition(testMovie3));
    }

    @Test
    //Expecting ReputationException
    public void testReputationException() {
        try {
            testWatchloadList.add(testMovie1);
            fail("Exception was not thrown!");
        } catch (VipException e) {
            //e.printStackTrace();
            fail("Wrong Exception thrown : VipException");
        } catch (ReputationException e) {
            //expected
        }
    }
}
