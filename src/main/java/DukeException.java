public class DukeException {

    protected Exception e;
    protected static String border = "____________________________________________________________\n";

    public DukeException(Exception e) {
        this.e = e;
    }

    /**
     * Prints out an error message when the user inputs an unknown command
     */
    public static void unknownCommand() {
        System.out.println(border
                + "OOPS!!! I'm sorry, but I don't know what that means :-("
                + "\n"
                + border);
    }

    /**
     * Returns a string to be printed out when the user does not supply a description for the task to be added
     * @param taskType
     * @return String errorMessage
     */
    public static String noTaskDescription(String taskType) {
        return (border
                + "OOPS!!! I'm sorry, but the description of a" + taskType + " cannot be empty."
                + "\n"
                + border);
    }

    /**
     * Prints out a message when the task list is empty
     */
    public static void noTasksInList() {
        System.out.println(border
                + "You have no tasks.\n"
                + border);
    }

    /**
     * Prints out an error message when the task input by the user is not present in the task list
     */
    public static void taskNotFound(){
        System.out.println(border
                + "OOPS!! I'm sorry, but that task does not exist."
                + border);
    }

    public static void saveError(){
        System.out.println(border
                + "OOPS!! I'm sorry, but there was a problem saving your tasks."
                + border);
    }
}
