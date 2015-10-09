package Design.Practice.SpreadSheet.UI;

import Design.Practice.SpreadSheet.DataModel.Content;
import LeetCode.Arrays.ExcelToColumnNumber;
import LeetCode.Tree.IterativePostOrderTraversal;

import java.util.Iterator;
import java.util.List;

/**
 * Created by prashantgolash on 9/30/15.
 */
public class Column implements UIElement {

    private List<UIElement> _elements;

    public void setContent(Content c) throws Exception{
        throw new Exception("no updated");
    }

    public void updateContent(Content c) throws Exception{
        throw new Exception("no updated");
    }

    public Content getContent() throws Exception {
        throw new Exception("no updated");
    }

    public Iterator<UIElement> getIterator() {
        return _elements.iterator();
    }

    public boolean isLeaf() {
        return false;
    }

}
