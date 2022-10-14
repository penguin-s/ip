package commands;
import exceptions.DukeException;

public class Command {
    public static void execute(){
        DukeException.unknownCommand();
    }
}
