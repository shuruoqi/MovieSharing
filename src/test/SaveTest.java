import exception.ReputationException;
import exception.VipException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveTest {
    private Save testSave;
    private Movie testMovie1;
    private Movie testMovie2;
    private Genre testGenre1;
    private Genre testGenre2;
    MovieList testWatchList;

    @BeforeEach
    public void setUp() throws ReputationException, VipException {
        testSave = new Save();
        testMovie1 = new PublicMovie();
        testWatchList = new WatchList();
        testGenre1 = new Genre("Genre1");
        testGenre2 = new Genre("Genre2");

        testMovie1.setName("Movie1");
        testMovie1.setQuality("720p");
        testMovie1.setSize(1.0);
        testMovie1.addGenre(testGenre1);
        testMovie1.addGenre(testGenre2);

        testMovie2 = new VipMovie();
        testMovie2.setName("Movie2");
        testMovie2.setQuality("1080p");
        testMovie2.setSize(2.0);
        testMovie2.addGenre(testGenre1);
        testWatchList.add(testMovie1);
        testWatchList.add(testMovie2);
        testMovie1.addGenre(testGenre1);
    }

    @Test
    public void testSave() throws IOException {
        testSave.save(testWatchList.getList(),"./data/SaveTestFile.txt");
        List<String> lines = Files.readAllLines(Paths.get("./data/SaveTestFile.txt"));
        assertEquals("Movie1,Public,720p,1.0,Genre1 Genre2",lines.get(0));
        assertEquals("Movie2,VIP,1080p,2.0,Genre1",lines.get(1));
    }

}
