public class Task {
    protected String description;
    protected boolean isMarked;

    public Task(String description) {
        this.description = description;
        this.isMarked = false;
    }

    public Task(boolean isMarked) {
        this.isMarked = isMarked;
    }

    /**
     * Returns marked status of task as an icon (either X or blank)
     * @return String statusIcon
     */
    public String getStatusIcon() {
        return (isMarked ? "X" : " ");
    }

    /**
     * Returns a string of the marked status of a task and its description
     * @return
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Prints out a message when the user adds a task to the task list
     */
    public void taskMessage() {
        System.out.println("____________________________________________________________\n"
                + "\n"
                + "added: " + description
                + "\n");
    }

    /**
     * Prints out a message when the user removes a task from the task list
     */
    public void deleteMessage(){
        System.out.println("____________________________________________________________\n"
                + "\n"
                + "Noted. I've removed this task:"
                + "\n"
                + this);
    }

    /**
     * Sets the task to Marked and prints out a message saying that the task has been marked
     */
    public void setMarked() {
        isMarked = true;
        System.out.println("____________________________________________________________\n"
                + "Nice! I've marked this task as done:\n"
                + this
                + "\n"
                + "____________________________________________________________\n");
    }

    /**
     * Sets the task to Unmarked and prints out a message saying that the task has been unmarked
     */
    public void setUnmarked() {
        isMarked = false;
        System.out.println("____________________________________________________________\n"
                + "Ok, I've marked this task as not done yet:\n"
                + this
                + "\n"
                + "____________________________________________________________\n");
    }

}
