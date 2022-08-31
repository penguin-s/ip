import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task("read book", true));
        taskList.add(new Task("return book", false));
        taskList.add(new Task("buy bread", false));

        String helloMessage = "____________________________________________________________ \n"
                + " Hello! I'm Duke\n"
                + " What can I do for you?\n"
                + "\n"
                + "____________________________________________________________\n";
        System.out.println(helloMessage);

        boolean isExit = false;
        Scanner userInput = new Scanner(System.in);
        while (!isExit) {
            String readInput;
            while ((readInput = userInput.nextLine()) != null) {
                if (readInput.equals("bye")) {
                    System.out.println("____________________________________________________________\n"
                            + "Bye. Hope to see you again soon!\n"
                            + "____________________________________________________________\n");
                    isExit = true;
                    break;
                } else if (readInput.equals("list")) {
                    if (!taskList.isEmpty()) {
                        System.out.println("____________________________________________________________\n");
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println((i + 1) + ". " + taskList.get(i).description);
                        }
                        System.out.println("____________________________________________________________\n");
                    } else if (taskList.isEmpty()) {
                        System.out.println("____________________________________________________________\n"
                                + "You have no tasks.\n"
                                + "____________________________________________________________\n");
                    }
                } else if (readInput.startsWith("mark")) {
                    String[] splitString = readInput.split("\\s+");
                    int taskNumber = Integer.parseInt(splitString[1]) - 1;
                    taskList.get(taskNumber).isMarked = true;
                    System.out.println("____________________________________________________________\n"
                            + "Nice! I've marked this task as done:\n"
                            + "[X] " + taskList.get(taskNumber).description
                            + "\n"
                            + "____________________________________________________________\n");
                } else if (readInput.startsWith("unmark")) {
                    String[] splitString = readInput.split("\\s+");
                    int taskNumber = Integer.parseInt(splitString[1]) - 1;
                    taskList.get(taskNumber).isMarked = false;
                    System.out.println("____________________________________________________________\n"
                            + "Ok, I've marked this task as not done yet:\n"
                            + "[ ] " + taskList.get(taskNumber).description
                            + "\n"
                            + "____________________________________________________________\n");
                } else {
                    taskList.add(new Task(readInput, false));
                    System.out.println("____________________________________________________________\n"
                            + "\n"
                            + "added: " + readInput
                            + "\n"
                            + "____________________________________________________________\n");
                }
            }
        }
    }
}