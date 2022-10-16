package ui;

public class Messages {
    public static void helloMessage() {
        Ui.border();
        System.out.println(
                " Hello! I'm Duke\n"
                        + " What can I do for you?\n");
        Ui.border();
    }
    public static void byeMessage(){
        Ui.border();
        System.out.println("Bye. Hope to see you again soon!\n");
        Ui.border();
    }

    public static void helpMessage(){
        Ui.border();
        System.out.println("Here is a list of all available commands:\n");
    }

    public static void listMessage(){
        Ui.border();
        System.out.println("Here are the tasks in your list:\n");
    }

    public static void defaultAddMessage(){
        Ui.border();
        System.out.println("added: ");
    }
    public static void addMessage(){
        Ui.border();
        System.out.println("Got it. I've added this task:\n");
    }

    public static void defaultDeleteMessage(){
        Ui.border();
        System.out.println("Noted. I've removed this task:\n");
    }

    public static void markMessage(){
        Ui.border();
        System.out.println("Nice! I've marked this task as done:\n");
    }

    public static void unmarkMessage(){
        Ui.border();
        System.out.println("Ok, I've marked this task as not done yet:\n");
    }




}
