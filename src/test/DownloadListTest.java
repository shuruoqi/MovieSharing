import exception.ReputationException;
import exception.VipException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DownloadListTest {
    DownloadList testDownloadList;
    ArrayList<Movie> movies;
    Movie testMovie1;
    Movie testMovie2;
    Movie testMovie3;

    @BeforeEach
    public void setUp() throws ReputationException, VipException {
        testDownloadList = new DownloadList();
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
        testDownloadList.add(testMovie1);
    }


    @Test
    public void testAdd() throws ReputationException, VipException {
        testDownloadList.add(testMovie3);
        assertEquals("name3",testDownloadList.getList().get(1).getName());
    }

    @Test
    public void testLoad() throws IOException {
        Load loadDL = new Load();
        testDownloadList.load();
        movies = loadDL.load("./data/LoadTestFile.txt");
        assertEquals("Movie1", movies.get(0).getName());
        assertEquals("Public", movies.get(0).getType());
        assertEquals("1080p", movies.get(0).getQuality());
        assertEquals(1.0, movies.get(0).getSize());
    }

    @Test
    public void testGetList() {
        assertEquals(1, testDownloadList.getList().size());
        assertEquals("name1", testDownloadList.getList().get(0).getName());
    }

    @Test
    public void testCheckRepetition() {
        assertTrue(testDownloadList.checkRepetition(testMovie1));
        assertFalse(testDownloadList.checkRepetition(testMovie3));
    }

    @Test
    //Expecting ReputationException
    public void testReputationException() {
        try {
            testDownloadList.add(testMovie1);
            fail("Exception was not thrown!");
        } catch (VipException e) {
            //e.printStackTrace();
            fail("Wrong Exception thrown : VipException");
        } catch (ReputationException e) {
            //expected
        }
    }

    @Test
    //Expecting VipException
    public void testVipException() {
        try {
            testDownloadList.add(testMovie2);
            fail("Exception was not thrown!");
        } catch (VipException e) {
            //expected
        } catch (ReputationException e) {
            fail("Wrong Exception thrown : ReputationException");
        }
    }
}
