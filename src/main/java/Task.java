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

    public String getStatusIcon() {
        return (isMarked ? "X" : " ");
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void taskMessage() {
        System.out.println("____________________________________________________________\n"
                + "\n"
                + "added: " + description
                + "\n");
    }
    public void deleteMessage(){
        System.out.println("____________________________________________________________\n"
                + "\n"
                + "Noted. I've removed this task:"
                + "\n"
                + this);
    }

    public void setMarked() {
        isMarked = true;
        System.out.println("____________________________________________________________\n"
                + "Nice! I've marked this task as done:\n"
                + this
                + "\n"
                + "____________________________________________________________\n");
    }

    public void setUnmarked() {
        isMarked = false;
        System.out.println("____________________________________________________________\n"
                + "Ok, I've marked this task as not done yet:\n"
                + this
                + "\n"
                + "____________________________________________________________\n");
    }

}
