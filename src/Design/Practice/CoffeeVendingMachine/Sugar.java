package Design.Practice.CoffeeVendingMachine;

/**
 * Created by prashantgolash on 19/02/16.
 */
public class Sugar extends Ingredient {

    public Sugar(double quantity) {
        super(quantity);
    }

    @Override
    public String unit() {
        return "grams";
    }

    @Override
    public String toString() {
        return "sugar";
    }
}
