import model.CinemaList;
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
        assertEquals("Spiderman", testCinemaList.getList().get(0).getName());
        assertEquals("Thor", testCinemaList.getList().get(1).getName());

    }
}
