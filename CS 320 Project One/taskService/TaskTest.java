package taskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Task Name", "Beebo beebo testing testing");
        assertNotNull(task.getTaskId());
        assertEquals(10, task.getTaskId().length());
        assertEquals("Task Name", task.getName());
        assertEquals("Beebo beebo testing testing", task.getDescription());
    }

    @Test
    public void testTaskInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Beebo beebo testing testing");
        });
    }

    @Test
    public void testTaskInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task Name", null);
        });
    }

    @Test
    public void testSetName() {
        Task task = new Task("Task Name", "Beebo beebo testing testing");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("Task Name", "Beebo beebo testing testing");
        task.setDescription("Beebo beebo testing testing set new");
        assertEquals("Beebo beebo testing testing set new", task.getDescription());
    }
}