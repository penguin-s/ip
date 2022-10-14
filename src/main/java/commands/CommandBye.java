package commands;

import ui.Console;
import static ui.Messages.byeMessage;

public class CommandBye extends Command{
    public CommandBye(String name) {
        super(name);
    }

    public static void execute(){
        byeMessage();
        Console.exitDuke();
    }
}
