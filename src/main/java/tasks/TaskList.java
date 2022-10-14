package tasks;

import java.util.ArrayList;

import exceptions.DukeException;
import ui.Ui;

public class TaskList {

    /**
     * Prints out tasks in the task list in numbered sequence
     * @param taskList
     */
    public static void listTasks(ArrayList<Task> taskList) {
        if (!taskList.isEmpty()) {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i).toString());
            }
            Ui.border();
        } else {
            DukeException.noTasksInList();
        }
    }
    /**
     * Counts the number of tasks in the given task list and prints it out
     * @param taskList
     */
    public static void taskCount(ArrayList<Task> taskList) {
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
        Ui.border();
    }
}
