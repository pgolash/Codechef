package Design.Practice.SpreadSheet.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prashantgolash on 9/26/15.
 */
public class Cell implements ActionListener {
    private JTextField _dataField;

    public void actionPerformed(ActionEvent event) {
        // event can be

    }

    public void setText(String text) {
        _dataField.setText(text);
    }

    public String getText() {
        return _dataField.getText();
    }

}
