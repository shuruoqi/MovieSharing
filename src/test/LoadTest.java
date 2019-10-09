import model.Load;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadTest {
    Load testLoad = new Load();

    @Test
    public void testLoad() throws IOException {
        testLoad.load("./data/LoadTestFile.txt");
        assertEquals("Movie1", testLoad.movies.get(0).getName());
        assertEquals("regular", testLoad.movies.get(0).getType());
        assertEquals("1080p", testLoad.movies.get(0).getQuality());
        assertEquals(1.0, testLoad.movies.get(0).getSize());
        assertEquals("Movie2", testLoad.movies.get(1).getName());
        assertEquals("VIP", testLoad.movies.get(1).getType());
        assertEquals("720p", testLoad.movies.get(1).getQuality());
        assertEquals(2.0, testLoad.movies.get(1).getSize());
    }
}