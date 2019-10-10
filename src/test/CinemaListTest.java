import ui.CinemaList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaListTest {
    CinemaList testCinemaList;

    @BeforeEach
    public void setUp() throws IOException {
        testCinemaList = new CinemaList();

        testCinemaList.load();
    }


    @Test
    public void testGetList() {
        assertEquals("Thor", testCinemaList.getList().get(0).getName());
        assertEquals("Spiderman", testCinemaList.getList().get(1).getName());
        assertEquals("Ironman", testCinemaList.getList().get(2).getName());
        assertEquals("Captain America", testCinemaList.getList().get(3).getName());
    }
}
