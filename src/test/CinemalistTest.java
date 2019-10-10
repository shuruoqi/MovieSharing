import model.Cinemalist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CinemalistTest {
    Cinemalist testCinemalist;

    @BeforeEach
    public void setUp(){
        testCinemalist = new Cinemalist();
    }

    @Test
    public void testListSetUp() throws IOException {
        testCinemalist.listSetUp();
        assertEquals("Thor", testCinemalist.cinemaList.get(0).getName());
        assertEquals("Spiderman", testCinemalist.cinemaList.get(1).getName());
        assertEquals("Ironman", testCinemalist.cinemaList.get(2).getName());
        assertEquals("Captain America", testCinemalist.cinemaList.get(3).getName());
    }

    @Test
    public void testGetList() throws IOException {
        testCinemalist.listSetUp();
        assertEquals("Thor", testCinemalist.getList().get(0).getName());
        assertEquals("Spiderman", testCinemalist.getList().get(1).getName());
        assertEquals("Ironman", testCinemalist.getList().get(2).getName());
        assertEquals("Captain America", testCinemalist.getList().get(3).getName());
    }

    @Test
    public void testChooseTypeResult() {
        assertEquals("regular",testCinemalist.chooseTypeResult("regular").getType());
        assertEquals("VIP",testCinemalist.chooseTypeResult("VIP").getType());
    }

    @Test
    public void testContinueToChooseMovieResult(){
        assertTrue(testCinemalist.continueToChooseMovieResult("Yes"));
        assertFalse(testCinemalist.continueToChooseMovieResult("No"));
    }
}
