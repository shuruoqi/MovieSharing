import ui.MovieList;
import model.PublicMovie;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.DownloadList;
import ui.WatchList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieListTest {
    MovieList testDList;
    MovieList testWList;
    MovieList testUpload;

    @BeforeEach
    public void setUp() {
        testDList = new DownloadList();
        testWList = new WatchList();
    }

    @Test
    public void testCheckRepetition(){
        PublicMovie r = new PublicMovie();
        r.setName("r");
        r.setQuality("1080p");
        r.setSize(1);
        VipMovie v = new VipMovie();
        v.setName("v");
        v.setQuality("1080p");
        v.setSize(1);
        testDList.add(r);
        assertFalse(testDList.checkRepetition(v));
        assertTrue(testDList.checkRepetition(r));
    }
}
