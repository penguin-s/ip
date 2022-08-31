public class Task {
    protected String description;
    protected boolean isMarked;

    public Task(String description, boolean isMarked) {
        this.description = description;
        this.isMarked = isMarked;
    }

    public String getStatusIcon() {
        return (isMarked ? "X" : " ");
    }
}
