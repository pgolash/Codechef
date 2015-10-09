package Design.Practice.SpreadSheet.DataModel;

/**
 * Created by prashantgolash on 10/6/15.
 */
public class Formula extends Content {

    @Override
    public String evaluate(String data) {
        // Parse function
        // call function
        // Using reflection evaluate each function and corresponding parameter
        return "parsed data from formula";
    }

    public Range getRange(String data) {
        return null;
    }

    public Formula getFormula(String formula) {
        return null;
    }
}
