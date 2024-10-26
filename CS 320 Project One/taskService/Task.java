package taskService;

import java.util.UUID;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    public Task(String name, String description) {
        this.taskId = generateUniqueId();
        
        // use setters for constructor for validation purposes
        setName(name);
        setDescription(description);
    }

    // uuid used for id generation
    private String generateUniqueId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name is invalid.");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description is invalid.");
        }
        this.description = description;
    }
}