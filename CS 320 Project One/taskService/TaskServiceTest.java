package taskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("Task Name", "Beebo beebo testing testing");
        taskService.addTask(task);
        assertEquals("Task Name", taskService.getTask(task.getTaskId()).getName());
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("Task Name", "Beebo beebo testing testing");
        taskService.addTask(task);
        taskService.deleteTask(task.getTaskId());
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.getTask(task.getTaskId());
        });
    }

    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService();
        Task task = new Task("Task Name", "Beebo beebo testing testing");
        taskService.addTask(task);
        taskService.updateTaskName(task.getTaskId(), "Updated Task");
        assertEquals("Updated Task", taskService.getTask(task.getTaskId()).getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService();
        Task task = new Task("Task Name", "Beebo beebo testing testing");
        taskService.addTask(task);
        taskService.updateTaskDescription(task.getTaskId(), "Beebo beebo testing testing update");
        assertEquals("Beebo beebo testing testing update", taskService.getTask(task.getTaskId()).getDescription());
    }

    @Test
    public void testAddTaskWithSameId() {
        TaskService taskService = new TaskService();
        Task task1 = new Task("Task One", "Beebo beebo testing testing one");
        Task task2 = new Task("Task Two", "Beebo beebo testing testing two");
        taskService.addTask(task1);
        taskService.addTask(task2);

        assertNotEquals(task1.getTaskId(), task2.getTaskId(), "Task IDs should be unique.");
    }
}