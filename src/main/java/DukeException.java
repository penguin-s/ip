public class DukeException {

    protected Exception e;
    protected static String border = "____________________________________________________________\n";

    public DukeException(Exception e) {
        this.e = e;
    }

    public static void unknownCommand() {
        System.out.println(border
                + "OOPS!!! I'm sorry, but I don't know what that means :-("
                + "\n"
                + border);
    }

    public static String noTaskDescription(String taskType) {
        return (border
                + "OOPS!!! I'm sorry, but the description of a" + taskType + " cannot be empty."
                + "\n"
                + border);
    }

    public static void noTasksInList() {
        System.out.println(border
                + "You have no tasks.\n"
                + border);
    }
    public static void taskNotFound(){
        System.out.println(border
                + "OOPS!! I'm sorry, but that task does not exist."
                + border);
    }
}
