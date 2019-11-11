import ui.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    User user1;
    User user2;

    @BeforeEach
    public void setUp() {
        user1 = new User("user1");
        user2 = new User("user2");
    }

    @Test
    public void testGetName() {
        assertEquals("user1" , user1.getName());
        assertEquals("user2" , user2.getName());
    }
}
