import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Cinemalist;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CLOTest {
    Cinemalist.CLOperation testCLO;

    @BeforeEach
    public void setUp() {
        testCLO = new Cinemalist.CLOperation();
    }

    @Test
    public void testOperationSetUp() throws IOException {
        testCLO.operationSetUp();
        assertEquals("Thor", testCLO.cinemalist.cinemaList.get(0).getName());
        assertEquals("Spiderman", testCLO.cinemalist.cinemaList.get(1).getName());
        assertEquals("Ironman", testCLO.cinemalist.cinemaList.get(2).getName());
        assertEquals("Captain America", testCLO.cinemalist.cinemaList.get(3).getName());
    }
}
