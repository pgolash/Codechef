package Design.Practice.SpreadSheet.Commands;

import Design.Practice.SpreadSheet.Commands.ICommand;

/**
 * Created by prashantgolash on 9/26/15.
 */
public class PasteCommand implements ICommand {
    public boolean execute() {
        // Store previous cells and data
        // Clipboard data = SelectionRange.data;
        System.out.println("Execute copy command");
        return true;
    }

    public boolean undo() {
        // execute previous stored data
        return true;
    }

    public String toString() {
        return "Paste command";
    }

}
