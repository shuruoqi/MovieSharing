import exception.ReputationException;
import exception.UpcomingException;
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
    public void setUp() throws ReputationException, UpcomingException {
        testSave = new Save();
        testMovie1 = new PublicMovie();
        testWatchList = new WatchList();
        testGenre1 = new Genre("Genre1");
        testGenre2 = new Genre("Genre2");

        testMovie1.setName("Movie1");
        testMovie1.setDate(2001);
        testMovie1.addGenre(testGenre1);
        testMovie1.addGenre(testGenre2);

        testMovie2 = new UpcomingMovie();
        testMovie2.setName("Movie2");
        testMovie2.setDate(2002);
        testMovie2.addGenre(testGenre1);
        testWatchList.add(testMovie1);
        testWatchList.add(testMovie2);
        testMovie1.addGenre(testGenre1);
    }

    @Test
    public void testSave() throws IOException {
        testSave.save(testWatchList.getList(),"./data/SaveTestFile.txt");
        List<String> lines = Files.readAllLines(Paths.get("./data/SaveTestFile.txt"));
        assertEquals("Movie1,Public,2001,Genre1 Genre2",lines.get(0));
        assertEquals("Movie2,Upcoming,2002,Genre1",lines.get(1));
    }

}
