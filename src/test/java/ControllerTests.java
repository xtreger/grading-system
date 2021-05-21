import controller.Controller;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class ControllerTests {
    private final Controller controller = new Controller();

    @Test
    public void testAddRubricWithNullTitle() {
        assertNull(controller.addRubric(null));
    }

    @Test
    public void testAddRubricWithValidTitle() {
        assertEquals("Sample Title", controller.addRubric("Sample Title").getTitle());
    }
}
