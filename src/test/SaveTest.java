import model.Movie;
import model.RegularMovie;
import model.Save;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Watchlist;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveTest {
    Save testSave;
    Movie testMovie1;
    Movie testMovie2;
    Watchlist testWatchlist;

    @BeforeEach
    public void setUp() throws IOException{
        testSave = new Save();
        testMovie1 = new RegularMovie("Movie1" , "720p", 1.0);
        testMovie2 = new VipMovie("Movie2" , "1080p", 2.0);
        testWatchlist = new Watchlist();
        testWatchlist.listSetUp();
        testWatchlist.watchList.add(testMovie1);
        testWatchlist.watchList.add(testMovie2);
    }

    @Test
    public void testSave() throws IOException {
        testSave.save(testWatchlist.watchList,"./data/SaveTestFile.txt");
        List<String> lines = Files.readAllLines(Paths.get("./data/SaveTestFile.txt"));
        assertEquals(lines.get(0), "Movie1,regular,720p,1.0");
        assertEquals(lines.get(1), "Movie2,VIP,1080p,2.0");
    }

}
