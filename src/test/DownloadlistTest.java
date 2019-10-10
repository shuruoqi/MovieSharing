import model.Downloadlist;
import model.Movie;
import model.RegularMovie;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Watchlist;

import static org.junit.jupiter.api.Assertions.*;

public class DownloadlistTest {
    Downloadlist testDownloadlist;
    Movie testMovie1;
    Movie testMovie2;

    @BeforeEach
    public void setUp() {
        testDownloadlist = new Downloadlist();
        testMovie1 = new VipMovie("name1","720p",2);
        testMovie2 = new VipMovie("name2","1080p",12);
        testDownloadlist.listSetUp();
        testDownloadlist.downloadList.add(testMovie1);
    }

    @Test
    public void testGetList() {
        assertEquals(1,testDownloadlist.downloadList.size());
        assertEquals("name1", testDownloadlist.downloadList.get(0).getName());
    }

    @Test
    public void testContinueToChooseMovieResult() {
        assertTrue(testDownloadlist.continueToChooseMovieResult("Yes"));
        assertFalse(testDownloadlist.continueToChooseMovieResult("No"));
    }

    @Test
    public void testAddToListResult() {
        assertTrue(testDownloadlist.addToListResult("Yes"));
        assertFalse(testDownloadlist.addToListResult("No"));
    }

    @Test
    public void testCheckRepetition() {
        assertTrue(testDownloadlist.checkRepetition(testMovie1));
        assertFalse(testDownloadlist.checkRepetition(testMovie2));
    }
}
