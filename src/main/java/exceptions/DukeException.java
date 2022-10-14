package exceptions;

import ui.Ui;

public class DukeException {

    protected Exception e;

    public DukeException(Exception e) {
        this.e = e;
    }

    /**
     * Prints out an error message when the user inputs an unknown command
     */
    public static void unknownCommand() {
        Ui.border();
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-("
                + "\n");
        Ui.border();
    }

    /**
     * Returns a string to be printed out when the user does not supply a description for the task to be added
     * @param taskType
     * @return String errorMessage
     */
    public static void noTaskDescription(String taskType) {
        Ui.border();
        System.out.println("OOPS!!! I'm sorry, but the description of a" + taskType + " cannot be empty."
                + "\n");
        Ui.border();
    }

    /**
     * Prints out a message when the task list is empty
     */
    public static void noTasksInList() {
        Ui.border();
        System.out.println("You have no tasks.\n");
        Ui.border();
    }

    /**
     * Prints out an error message when the task input by the user is not present in the task list
     */
    public static void taskNotFound(){
        Ui.border();
        System.out.println("OOPS!! I'm sorry, but that task does not exist.");
        Ui.border();
    }

    public static void saveError(){
        Ui.border();
        System.out.println("OOPS!! I'm sorry, but there was a problem saving your tasks.");
        Ui.border();
    }
}
