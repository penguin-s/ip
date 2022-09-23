public class Event extends Task{

    protected String at;

    public Event(String description, String at){
        super(description);
        this.at = at;
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public void taskMessage(){
        System.out.println("____________________________________________________________\n"
                + "Got it. I've added this task:"
                + "\n"
                + this);
    }
}
