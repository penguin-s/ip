package tasks;

import java.util.ArrayList;

import exceptions.DukeException;
import ui.Ui;

public class TaskList {
    public final ArrayList<Task> tasks = new ArrayList<>();
    public final int taskCount;

    public TaskList() {
        this.taskCount = tasks.size();
    }

    public void addTask(Task task, Tasklist taskList){
        taskList.add(task);
    }

    /**
     * Counts the number of tasks in the given task list and prints it out
     * @param taskList
     */
    public void countTasks() {
        System.out.println("Now you have " );
        System.out.println(taskCount);
        System.out.println(" tasks in the list.");
        Ui.border();
    }
}
