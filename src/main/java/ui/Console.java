package ui;

import commands.*;
import exceptions.DukeException;
import tasks.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Console {
    @SuppressWarnings("Field may be final")
    private static boolean isExit = false;

    public static void exitDuke(){
        isExit = true;
    }

    /**
     * Reads command name from user input by parsing the input
     * @param readInput Takes input from user
     * @return String Command
     */
    public void runCommand(Parser parsedInput) {
        switch (parsedInput.name) {
        case "bye":
            CommandBye.execute();
            break;
        case "help":
            CommandHelp.execute();
            break;
        case "list":
            CommandList.execute();
            break;
        case "todo":
            CommandTodo.execute();
            break;
        case "deadline":
            CommandDeadline.execute();
            break;
        case "event":
            CommandEvent.execute();
            break;
        case "mark":
            CommandMark.execute();
            break;
        case "unmark":
            CommandUnmark.execute();
            break;
        case "delete":
            CommandDelete.execute();
            break;
        case "save":
            CommandSave.execute();
            break;
        default:
            DukeException.unknownCommand();
        }
    }

    public static String runDuke() {
        Scanner userInput = new Scanner(System.in);
        while (!isExit) {
            String readInput;
            while ((readInput = userInput.nextLine()) != null) {
                Parser command = new Parser(readInput);
                runCommand(command);
    }
                switch (command) {
                case "bye":
                    System.out.println(border
                            +
                            + border);
                    isExit = true;
                    break;
                case "list":
                    if (!taskList.isEmpty()) {
                        System.out.println(border);
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println((i + 1) + ". " + taskList.get(i).toString());
                        }
                        System.out.println(border);
                    } else {
                        DukeException.noTasksInList();
                    }
                    break;
                case "mark":
                    getTaskFromNumber(readInput, taskList).setMarked();
                    break;
                case "unmark":
                    getTaskFromNumber(readInput, taskList).setUnmarked();
                    break;
                case "todo":
                    if (getTaskNameFromInput(readInput) != null) {
                        Todo newTodo = new Todo(getTaskNameFromInput(readInput));
                        taskList.add(newTodo);
                        newTodo.taskMessage();
                        taskCountMessage(taskList);
                    }
                    break;
                case "deadline":
                    if (getTaskNameFromInput(readInput) != null) {
                        String by = findTaskDateTime(readInput);
                        Deadline newDeadline = new Deadline(getTaskNameFromInput(readInput), by);
                        taskList.add(newDeadline);
                        newDeadline.taskMessage();
                        taskCountMessage(taskList);
                    }
                    break;
                case "event":
                    if (getTaskNameFromInput(readInput) != null) {
                        String at = findTaskDateTime(readInput);
                        Event newEvent = new Event(getTaskNameFromInput(readInput), at);
                        taskList.add(newEvent);
                        newEvent.taskMessage();
                        taskCountMessage(taskList);
                    }
                    break;
                case "save":
                    try{
                        FileOutputStream fos = new FileOutputStream("duke_data");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(taskList);
                        oos.flush();
                        oos.close();
                        System.out.println(border);
                        System.out.println("Your tasks have been saved.");
                        System.out.println(border);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        DukeException.saveError();
                    }
                    break;
                case "delete":
                    try{
                        Task selectedTask = getTaskFromNumber(readInput, taskList);
                        selectedTask.deleteMessage();
                        taskList.remove(selectedTask);
                        taskCountMessage(taskList);
                    }
                    catch(Exception e){
                        DukeException.taskNotFound();
                    }
                    break;
                default:

                }
            }
        }
    }



