import ui.Movielist;
import model.RegularMovie;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Downloadlist;
import ui.Upload;
import ui.Watchlist;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovielistTest {
    Movielist testDList;
    Movielist testWList;
    Movielist testUpload;

    @BeforeEach
    public void setUp() {
        testDList = new Downloadlist();
        testWList = new Watchlist();
        testUpload = new Upload();
    }

    @Test
    public void testStartResult() {
        assertTrue(testDList.startResult("Yes"));
        assertFalse(testDList.startResult("No"));
        assertTrue(testWList.startResult("Yes"));
        assertFalse(testWList.startResult("No"));
        assertTrue(testUpload.startResult("Yes"));
        assertFalse(testUpload.startResult("No"));
    }

    @Test
    public void testAddToListResult() {
        assertTrue(testDList.startResult("Yes"));
        assertFalse(testDList.startResult("No"));
        assertTrue(testWList.startResult("Yes"));
        assertFalse(testWList.startResult("No"));
        assertTrue(testUpload.startResult("Yes"));
        assertFalse(testUpload.startResult("No"));
    }

    @Test
    public void testCheckRepetition() throws IOException {
        testDList.listSetUp();
        RegularMovie r = new RegularMovie("r","1080p",1);
        VipMovie v = new VipMovie("v","1080p",1);
        testDList.insertMovieToList(r);
        assertFalse(testDList.checkRepetition(v));
        assertTrue(testDList.checkRepetition(r));
    }
}
