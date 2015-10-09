package Design.Practice.SpreadSheet.UI;

import Design.Practice.SpreadSheet.DataModel.Content;
import Design.Practice.SpreadSheet.DataModel.Range;

import java.util.Iterator;

/**
 * Created by prashantgolash on 10/8/15.
 */
public class SelectionRange implements UIElement {

    private int startX;
    private int startY;
    private int numRows;
    private int numCols;

    SelectionRange(Range r) {
        this.startX = r.getStartX();
        this.startY = r.getStartY();
        this.numRows = r.getNumRows();
        this.numCols = r.getNumCols();
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