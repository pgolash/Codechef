package Design.Practice.SpreadSheet.UI;

import Design.Practice.SpreadSheet.DataModel.Content;
import Design.Practice.SpreadSheet.DataModel.Range;

import java.util.Iterator;

/**
 * Created by prashantgolash on 10/8/15.
 */
public class SelectionRange implements UIElement {

    class MyIterator implements Iterator<UIElement> {
        public boolean hasNext() {
            // first it returns the row idx
            // next it returns the col idx
            return true;
        }

        public UIElement next() {
            return matrix[0][0];
        }
    }

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

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    private int startX;
    private int startY;
    private int numRows;
    private int numCols;
    private Cell[][] matrix;

    SelectionRange(Range r, Cell[][] matrix) {
        this.startX = r.getStartX();
        this.startY = r.getStartY();
        this.numRows = r.getNumRows();
        this.numCols = r.getNumCols();

        matrix = new Cell[numRows][numCols];

        this.matrix = matrix;
    }

    public void setContent(Content c) throws Exception{
        throw new Exception("no updated");
    }

    public void updateContent(Content c) throws Exception{
        throw new Exception("no updated");
    }

    public Content getContent() throws Exception {
        throw new Exception("no updated");
    }

    public Iterator<UIElement> getIterator() throws Exception {
        throw new Exception("not implemented");
    }

    public boolean isLeaf() {
        return false;
    }
}