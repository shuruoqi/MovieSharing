import exception.ReputationException;
import exception.VipException;
import model.Movie;
import model.PublicMovie;
import model.Save;
import model.VipMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.MovieList;
import model.WatchList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveTest {
    private Save testSave;
    private Movie testMovie1;
    private Movie testMovie2;
    MovieList testWatchList;

    @BeforeEach
    public void setUp() throws ReputationException, VipException {
        testSave = new Save();
        testMovie1 = new PublicMovie();
        testWatchList = new WatchList();

        testMovie1.setName("Movie1");
        testMovie1.setQuality("720p");
        testMovie1.setSize(1.0);
        testMovie2 = new VipMovie();
        testMovie2.setName("Movie2");
        testMovie2.setQuality("1080p");
        testMovie2.setSize(2.0);
        testWatchList.add(testMovie1);
        testWatchList.add(testMovie2);
    }

    @Test
    public void testSave() throws IOException {
        testSave.save(testWatchList.getList(),"./data/SaveTestFile.txt");
        List<String> lines = Files.readAllLines(Paths.get("./data/SaveTestFile.txt"));
        assertEquals(lines.get(0), "Movie1,Public,720p,1.0");
        assertEquals(lines.get(1), "Movie2,VIP,1080p,2.0");
    }

}
