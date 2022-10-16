package commands;

import exceptions.DukeException;
import tasks.TaskList;
import ui.Ui;

import static ui.Messages.listMessage;


public class CommandList extends Command {
    /**
     * Prints out tasks in the task list in numbered sequence
     * @param taskList
     */
    public static void execute(TaskList taskList) {
        if (taskList.taskCount > 0) {
            listMessage();
            for (int i = 0; i < taskList.taskCount; i++) {
                System.out.println(i + 1);
                System.out.println(". ");
                System.out.println(taskList.tasks.get(i).toString());
            }
            Ui.border();
            taskList.countTasks();
        } else {
            DukeException.noTasksInList();
        }
    }
}
