import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.WLOperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WLOperationTest {
    WLOperation testWLOperation;

    @BeforeEach
    public void setUp(){
        testWLOperation = new WLOperation();
    }

    @Test
    public void testOperationSetUp(){
        testWLOperation.operationSetUp();
        assertEquals("Spiderman", testWLOperation.cinemaList.get(0).getName());
        assertEquals("Ironman", testWLOperation.cinemaList.get(1).getName());
        assertEquals("Captain America", testWLOperation.cinemaList.get(2).getName());
        assertEquals("Thor", testWLOperation.cinemaList.get(3).getName());
        assertEquals(4, testWLOperation.cinemaList.size());
    }
}
