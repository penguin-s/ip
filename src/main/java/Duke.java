import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String helloMessage = "____________________________________________________________ \n"
                + " Hello! I'm Duke\n"
                + " What can I do for you?\n"
                + "\n"
                + "____________________________________________________________\n";
        System.out.println(helloMessage);

        boolean isExit = false;
        Scanner userInput = new Scanner(System.in);
        while (!isExit) {
            String readInput;
            while((readInput = userInput.nextLine()) != null) {
                System.out.println("____________________________________________________________"
                        + "\n"
                        + readInput
                        + "\n"
                        + "____________________________________________________________\n");
                if(readInput.equals("bye")){
                    System.out.println("____________________________________________________________\n"
                        + "Bye. Hope to see you again soon!\n"
                        + "____________________________________________________________\n");
                    isExit = true;
                    break;
                }
            }
        }
    }
}