package commands;

import tasks.Task;
import tasks.TaskList;

public class CommandTodo extends Command{
    public void execute(Task task){
        TaskList.addTask();


    }

}
