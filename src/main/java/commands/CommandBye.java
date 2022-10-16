package commands;

import ui.Console;
import static ui.Messages.byeMessage;

public class CommandBye extends Command{
    public static void execute(){
        byeMessage();
        Console.exitDuke();
    }
}
