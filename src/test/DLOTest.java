import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Downloadlist;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DLOTest {
    Downloadlist.DLOperation testDLO;

    @BeforeEach
    public void setUp() {
        testDLO = new Downloadlist.DLOperation();
    }

    @Test
    public void testStart() throws IOException {
        testDLO.operationSetUp();
        testDLO.start();
        assertEquals("Thor", testDLO.downloadlist.downloadList.get(0).getName());
    }
}
