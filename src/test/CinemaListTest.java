import exception.ReputationException;
import exception.UpcomingException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaListTest {
    CinemaList testCinemaList;
    ArrayList<Movie> movies;
    Movie testMovie1;
    Movie testMovie2;
    Movie testMovie3;

    @BeforeEach
    public void setUp() throws IOException, ReputationException, UpcomingException {
        testCinemaList = new CinemaList();
        testMovie1 = new PublicMovie();
        testMovie1.setName("name1");
        testMovie1.setDate("2001-01-01");
        testMovie2 = new UpcomingMovie();
        testMovie2.setName("name2");
        testMovie2.setDate("2002-02-02");
        testMovie3 = new PublicMovie();
        testMovie3.setName("name3");
        testMovie3.setDate("2003-03-03");
        testCinemaList.add(testMovie1);
    }

    @Test
    public void testGetList() {
        assertEquals(1, testCinemaList.getList().size());
        assertEquals("name1", testCinemaList.getList().get(0).getName());
    }

    @Test
    public void testLoad() throws IOException {
        Load loadCL = new Load();
        testCinemaList.load();
        movies = loadCL.load("./data/LoadTestFile.txt");
        assertEquals("Movie1", movies.get(0).getName());
        assertEquals("Public", movies.get(0).getType());
        assertEquals("2001-01-01", movies.get(0).getDate());
    }
}
