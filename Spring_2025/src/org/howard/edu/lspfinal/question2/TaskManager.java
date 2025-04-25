
package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * References:
 * Java Hash Map Implementation: https://www.w3schools.com/java/java_hashmap.asp
 * Java Custom Exception Handling: https://www.baeldung.com/java-new-custom-exception
 * GPT-4o
 */

/**
 * Manages tasks for a team, allowing addition, retrieval, update, and listing
 * grouped by status.
 */
public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * 
     * @param name     Unique name of the task.
     * @param priority Task priority (lower number = higher priority).
     * @param status   Initial status ("TODO", "IN_PROGRESS", or "DONE").
     * @throws DuplicateTaskException if a task with the same name already exists.
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its unique name.
     * 
     * @param name Name of the task.
     * @return the task object.
     * @throws TaskNotFoundException if no such task is found.
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name   Name of the task to update.
     * @param status New status ("TODO", "IN_PROGRESS", or "DONE").
     * @throws TaskNotFoundException if the task does not exist.
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name); // throws TaskNotFoundException if not found
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new LinkedHashMap<>();
        grouped.put("TODO", new ArrayList<>());
        grouped.put("IN_PROGRESS", new ArrayList<>());
        grouped.put("DONE", new ArrayList<>());

        for (Task task : tasks.values()) {
            grouped.get(task.getStatus()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (Map.Entry<String, List<Task>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Task task : entry.getValue()) {
                System.out.println("  " + task);
            }
        }
    }
}
