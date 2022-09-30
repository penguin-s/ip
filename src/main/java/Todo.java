public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Prints out a message when the user adds a todo to the task list
     */
    @Override
    public void taskMessage() {
        System.out.println("____________________________________________________________\n"
                + "Got it. I've added this task:"
                + "\n"
                + this);
    }
}

