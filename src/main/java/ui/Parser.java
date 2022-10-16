package ui;

import exceptions.DukeException;
import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

import java.util.Objects;

public class Parser {
    protected String name;
    protected int taskNumber;
    protected String dateTime;
    protected String taskType;
    protected static String[] taskCommands = {"todo", "deadline", "event"};
    protected String[] numberCommands = {"delete", "mark", "unmark"};

    /**
     * Extracts task attributes from user input by tokenizing and parsing the input
     *
     * @param readInput Takes input from user
     * @return String taskName
     */
    public Parser(String readInput) {
        String[] splitString = readInput.split("\\s+");
        for(String command : taskCommands){
            //If the first token is a task command
            if(splitString[0].equals(command)){
                this.taskType = splitString[0];
                if(this.taskType.equals("todo")) {
                    this.name = readInput.substring(taskType.length() + 1);
                }
                else if(this.taskType.equals("deadline") || this.taskType.equals("event")){
                    String afterSlash = readInput.substring(readInput.indexOf("/"));
                    String[] slashString = afterSlash.split("\\s+");
                    this.dateTime = afterSlash.substring(slashString[0].length() + 1);
                }
                else {
                    DukeException.noTaskDescription(taskType);
                }
            }
            else{
                this.name = splitString[0];
            }
        }
        // If the first token is not a task command
        for(String command : numberCommands){
            assert this.name != null;
            if(this.name.equals(command)){
                this.taskNumber = Integer.parseInt(splitString[1]) - 1;
            } else {
                DukeException.unknownCommand();
            }
        }
    }

    public Task toTask(){
        if(taskType.equals("deadline")){
            return new Deadline(this.name, this.dateTime);
        }
        else if(taskType.equals("event")){
            return new Event(this.name, this.dateTime);
        }
        else{
            return new Todo(this.name);
        }
    }
}

