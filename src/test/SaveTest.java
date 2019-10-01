import model.Movie;
import model.Save;
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
        testMovie1 = new Movie("Movie1" , 1000, 1);
        testMovie2 = new Movie("Movie2" , 2000, 2);
        testWatchlist = new Watchlist();
        testWatchlist.watchListSetUp();
        testWatchlist.watchList.add(testMovie1);
        testWatchlist.watchList.add(testMovie2);
    }

    @Test
    public void testSave() throws IOException {
        testSave.save(testWatchlist.watchList,"SaveTestFile.txt");
        List<String> lines = Files.readAllLines(Paths.get("SaveTestFile.txt"));
        assertEquals(lines.get(0), "Movie1,1000,1");
        assertEquals(lines.get(1), "Movie2,2000,2");
    }

}
