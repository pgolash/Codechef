package Design.Practice.SpreadSheet.UI;

import Design.Practice.SpreadSheet.DataModel.Content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * Created by prashantgolash on 9/26/15.
 */
public class Cell implements UIElement {

    private JTextField _dataField;

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
        return true;
    }
}