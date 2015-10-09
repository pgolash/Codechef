package Design.Practice.SpreadSheet.Commands;

/**
 * Created by prashantgolash on 9/27/15.
 */

// how selection range will be implemented

public class SelectionRange {
    private int cellStart;
    private int cellEnd;

    SelectionRange(int start, int end) {
        this.cellEnd = end;
        this.cellStart = start;
    }
}
