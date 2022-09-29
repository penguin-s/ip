import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static String border = "____________________________________________________________\n";

    public static Task getTaskFromNumber(String readInput, ArrayList<Task> taskList) {
        String[] splitString = readInput.split("\\s+");
        int taskNumber = Integer.parseInt(splitString[1]) - 1;
        return taskList.get(taskNumber);
    }

    public static String readCommand(String readInput) {
        String[] splitString = readInput.split("\\s+");
        return splitString[0];
    }

    public static String getTaskNameFromInput(String readInput) {
        String[] splitString = readInput.split("\\s+");
        String taskType = splitString[0];
        if (splitString.length > 1) {
            if (taskType.equals("todo")) {
                return readInput.substring(taskType.length() + 1);
            } else {
                return readInput.substring(taskType.length() + 1, readInput.indexOf("/") - 1);
            }
        } else {
            return DukeException.noTaskDescription(taskType);
        }
    }

    public static String findTaskDateTime(String readInput) {
        String afterSlash = readInput.substring(readInput.indexOf("/"));
        String[] splitString = afterSlash.split("\\s+");
        return afterSlash.substring(splitString[0].length() + 1);
    }

    public static void taskCountMessage(ArrayList<Task> taskList) {
        System.out.println("Now you have " + taskList.size() + " tasks in the list."
                + "\n"
                + border);
    }

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        // Fillers
        taskList.add(new Todo("read book"));
        taskList.add(new Deadline("return book", "June 6th"));
        taskList.add(new Event("project meeting", "Aug 6th 2-4pm"));
        taskList.add(new Todo("join sports club"));
        taskList.get(0).isMarked = true;

        String helloMessage = border
                + " Hello! I'm Duke\n"
                + " What can I do for you?\n"
                + "\n"
                + border;
        System.out.println(helloMessage);

        boolean isExit = false;
        Scanner userInput = new Scanner(System.in);

        while (!isExit) {
            String readInput;
            while ((readInput = userInput.nextLine()) != null) {
                String command = readCommand(readInput);
                switch (command) {
                case "bye":
                    System.out.println(border
                            + "Bye. Hope to see you again soon!\n"
                            + border);
                    isExit = true;
                    break;
                case "list":
                    if (!taskList.isEmpty()) {
                        System.out.println(border);
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
                    DukeException.unknownCommand();
                }
            }
        }
    }
}