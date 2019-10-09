import model.Cinemalist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CinemalistTest {
    Cinemalist testCinemalist;

    @BeforeEach
    public void setUp(){
        testCinemalist = new Cinemalist();
    }

    @Test
    public void testOperationSetUp() throws IOException {
        testCinemalist.listSetUp();
        assertEquals("Thor", testCinemalist.cinemaList.get(0).getName());
        assertEquals("Spiderman", testCinemalist.cinemaList.get(1).getName());
        assertEquals("Ironman", testCinemalist.cinemaList.get(2).getName());
        assertEquals("Captain America", testCinemalist.cinemaList.get(3).getName());
    }
}
