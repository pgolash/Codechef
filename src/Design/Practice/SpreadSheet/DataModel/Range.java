package Design.Practice.SpreadSheet.DataModel;

/**
 * Created by prashantgolash on 10/8/15.
 */
public class Range {
    private int startX;
    private int startY;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    private int numCols;
    private int numRows;

    Range(int startX, int startY, int numCols, int numRows) {
        this.startX = startX;
        this.startY = startY;
        this.numCols = numCols;
        this.numRows = numRows;
    }


}
