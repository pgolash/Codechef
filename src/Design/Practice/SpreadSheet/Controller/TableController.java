package Design.Practice.SpreadSheet.Controller;

import Design.Practice.SpreadSheet.Commands.ICommand;
import Design.Practice.SpreadSheet.DataModel.Range;
import Design.Practice.SpreadSheet.UI.UIElement;
import javafx.scene.control.Tab;

/**
 * Created by prashantgolash on 9/27/15.
 */
public class TableController {
    // All event handling pipeline will be done by TableController component
    // event queue will be there and events will be pushed onto that queue
    // Table controller will dealing with render context to get UIElement at given location
    // according to event. TableController will pass UIElement to commands to get treated properly
    private RenderContext _context = null;

    TableController(RenderContext context) {
        _context = context;
    }

    public void process(String command) {
        ICommand c = getCommand(command);
        Range r = getRange(command);
        UIElement element = _context.getUIElement(r);
        c.execute(element);
    }

    public ICommand getCommand(String command) {
        return null;
    }

    public Range getRange(String command) {
        return null;
    }



}
