import model.CinemaList;
import model.Observer;
import model.Subject;
import ui.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectTest {
    Subject testCinemaList;
    Observer user1;
    Observer user2;

    @BeforeEach
    public void setUp() {
        testCinemaList = new CinemaList();
        user1 = new User("user1");
        user2 = new User("user2");
        testCinemaList.addObserver(user1);
    }

    @Test
    public void testAddObserver() {
        assertEquals("user1" , testCinemaList.getObservers().get(0).getName());
        testCinemaList.addObserver(user2);
        assertEquals("user2" , testCinemaList.getObservers().get(1).getName());
    }

    @Test
    public void testRemoveObserver() {
        testCinemaList.addObserver(user2);
        testCinemaList.removeObserver(user1);
        assertEquals("user2" , testCinemaList.getObservers().get(0).getName());
    }
}


