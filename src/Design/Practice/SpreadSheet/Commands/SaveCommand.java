package Design.Practice.SpreadSheet.Commands;

import Design.Practice.SpreadSheet.Commands.ICommand;
import Design.Practice.SpreadSheet.UI.UIElement;

/**
 * Created by prashantgolash on 9/26/15.
 */
public class SaveCommand implements ICommand {
    public boolean execute(UIElement elem) {
        // Store previous cells and data
        // Clipboard data = SelectionRange.data;
        // Serialize the data
        // open file stream
        // dump the data
        System.out.println("Execute copy command");
        return true;
    }

    public boolean undo(UIElement elem) {
        // nothing to be done
        return true;
    }

    public String toString() {
        return "Save command";
    }

}
