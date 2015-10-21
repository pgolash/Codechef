package Design.Practice.SpreadSheet.Commands;

import Design.Practice.SpreadSheet.UI.UIElement;

/**
 * Created by prashantgolash on 10/6/15.
 */
public class FormatCommand implements ICommand {

    public boolean execute(UIElement element) {
        // Store previous cells and data
        // Clipboard data = SelectionRange.data;
        System.out.println("Execute format command");
        return true;
    }

    public boolean undo(UIElement element) {
        // execute previous stored data
        return true;
    }

    public String toString() {
        return "Format command";
    }

}
