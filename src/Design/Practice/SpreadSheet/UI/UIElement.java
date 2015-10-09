package Design.Practice.SpreadSheet.UI;

import Design.Practice.SpreadSheet.DataModel.Content;
import LeetCode.Tree.IterativePostOrderTraversal;

import java.util.Iterator;
import java.util.List;

/**
 * Created by prashantgolash on 9/30/15.
 */

/*
All ui events
=============
    1) Copy a row event
    2) Paste a row event
    3) Copy cell
    4) Paste cell
    5) SelectRange
    6) CopyRange

    Confusion :
        b> who will listen to event and how event flow will happen
        c> What is exact structure of IRange
        d> from location we should be able to get the object (row, col and cell)
            // RenderContext should know the location and row \ column or cell
 */
public interface UIElement {
    public void setContent(Content c) throws Exception;
    public void updateContent(Content c) throws Exception;
    public Content getContent() throws Exception;
    public Iterator<UIElement> getIterator() throws Exception;
    public boolean isLeaf();
}