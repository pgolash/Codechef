package Design.Practice.SpreadSheet.Commands;

import Design.Practice.SpreadSheet.Commands.ICommand;
import Design.Practice.SpreadSheet.UI.UIElement;

/**
 * Created by prashantgolash on 9/26/15.
 */
public class PasteCommand implements ICommand {
    public boolean execute(UIElement element) {
        // Store previous cells and data
        // Clipboard data = SelectionRange.data;
        System.out.println("Execute paste command");
        return true;
    }

    public boolean undo(UIElement element) {
        // execute previous stored data
        return true;
    }

    public String toString() {
        return "Paste command";
    }
}