package Design.Practice.SpreadSheet.Commands;

import java.io.Serializable;

/**
 * Created by prashantgolash on 9/26/15.
 */

// command that we support right now
    // save the sheet, edit a cell, copy a cell content from one to another
    // applying formula to a cell, changing font of a cell(s)
    // table control which would change the sheet's content
public interface ICommand extends Serializable {
    public boolean execute();
    public boolean undo();
    public String toString();
}
