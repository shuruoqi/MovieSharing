import model.DownloadList;
import model.Movie;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DownloadListTest {
    DownloadList testDownloadList;
    Movie testMovie1;
    Movie testMovie2;

    @BeforeEach
    public void setUp() {
        testDownloadList = new DownloadList();
        testMovie1 = new VipMovie();
        testMovie1.setName("name1");
        testMovie1.setQuality("720p");
        testMovie1.setSize(2);
        testMovie2 = new VipMovie();
        testMovie2.setName("name2");
        testMovie2.setQuality("1080p");
        testMovie2.setSize(12);
        testDownloadList.add(testMovie1);
    }

    @Test
    public void testGetList() {
        assertEquals(1, testDownloadList.getList().size());
        assertEquals("name1", testDownloadList.getList().get(0).getName());
    }

    @Test
    public void testCheckRepetition() {
        assertTrue(testDownloadList.checkRepetition(testMovie1));
        assertFalse(testDownloadList.checkRepetition(testMovie2));
    }
}
