package Design.Practice.RedisCopy;

/**
 * Created by prashantgolash on 11/4/15.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
        public static void main(String[] args) {
            ArrayList<String> user_commands = new ArrayList<String>();
            DatabaseEngine database = new DatabaseEngine();
            String input = "";
            Scanner scan = new Scanner(System.in);

            //Receive all commands until END
            while (!input.equals("END")) {
                input = scan.nextLine();
                user_commands.add(input);
            }

            //Finished receiving input now process all commands.
            for (String c1 : user_commands)
                System.out.print(database.processCommand(c1));

        }

    }