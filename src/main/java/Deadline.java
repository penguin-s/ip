public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Prints out a message when the user adds a deadline to the task list
     */
    @Override
    public void taskMessage() {
        System.out.println("____________________________________________________________\n"
                + "Got it. I've added this task:"
                + "\n"
                + this);
    }
}
