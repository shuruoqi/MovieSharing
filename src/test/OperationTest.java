import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {
    Operation testOperation;

    @BeforeEach
    public void setUp(){
        testOperation = new Operation();
    }

    @Test
    public void testOperationSetUp(){
        testOperation.operationSetUp();
        assertEquals("Spiderman",testOperation.movieList.get(0).getName());
        assertEquals("Ironman", testOperation.movieList.get(1).getName());
        assertEquals("Captain America", testOperation.movieList.get(2).getName());
        assertEquals("Thor", testOperation.movieList.get(3).getName());
        assertEquals(4,testOperation.movieList.size());
    }

}
