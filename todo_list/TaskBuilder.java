package todo_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskBuilder {

    private String title; // Titre de la tâche
    private String description; // Description de la tâche
    private boolean done; // Indique si la tâche est terminée ou non
    private User creator; // Utilisateur qui a créé la tâche


    public TaskBuilder setCreator(User creator, String title, String description) {
        this.creator = creator;
        return this;
    }

    public Task createTask() { // Factory method to create tasks
        Task task = new Task();
        task.setDescription(description); // Automatically add to the list
        return task;
    }
    private List<Task> tasks = new ArrayList<>();

    public class Task {

        private String description; // Add relevant fields (e.g., description, id, priority)
        private int id; // Example: Add an ID
        private static int nextId = 1; // Static ID generator

        public Task(String description) { // Constructor to initialize task
            this.description = description;
            this.id = nextId++; // Assign unique ID
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) { // Override equals for proper comparison
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return id == task.id; // Compare based on ID (or other relevant fields)
        }

        @Override
        public int hashCode() {
            return Objects.hash(id); // Consistent with equals
        }


        @Override
        public String toString() { // Good for debugging and display
            return "Task{id=" + id + ", description='" + description + '\'' + '}';
        }
    }



    public Task findTask(Task task) { // Find and return the task (or null if not found)
        for (Task t : tasks) {
            if (t.equals(task)) { // Use equals() for object comparison
                return t;
            }
        }
        return null; // Return null if not found
    }


    public void removeTask(Task task) {
        tasks.remove(task); // Use the List's remove method
    }

    public List<Task> getAllTasks() { // Method to get all tasks
        return new ArrayList<>(tasks); // Return a copy to prevent direct modification
    }

    public static void main(String[] args) {
        TaskBuilder builder = new TaskBuilder();
        Task task1 = builder.createTask("Grocery Shopping");
        Task task2 = builder.createTask("Pay Bills");

        System.out.println(builder.getAllTasks());

        Task taskToFind = new TaskBuilder().new Task("Grocery Shopping"); // Create a task to find (needs equals() override)
        Task foundTask = builder.findTask(taskToFind);

        if (foundTask != null) {
            System.out.println("Found task: " + foundTask);
        } else {
            System.out.println("Task not found.");
        }

        builder.removeTask(task1);
        System.out.println(builder.getAllTasks());
    }
}