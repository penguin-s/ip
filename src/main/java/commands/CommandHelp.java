package commands;

import static ui.Messages.helpMessage;

public class CommandHelp extends Command {
    protected static String[] commands = {
            "todo [Name]",
            "deadline [Name] /by [Date and Time]",
            "event [Name] /at [Date and Time],",
            "list",
            "delete [Task List Number]",
            "mark [Task List Number]",
            "unmark [Task List Number]",
            "save",
            "bye"
    };

    public static void execute() {
        helpMessage();
        for(String command : commands){
            System.out.println(command + "\n");
        }
    }
}
