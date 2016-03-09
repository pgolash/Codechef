package Design.Practice.CoffeeVendingMachine;

/**
 * Created by prashantgolash on 19/02/16.
 */
public class Milk extends Ingredient {

    public Milk(double quanity) {
        super(quanity);
    }

    @Override
    public String unit() {
        return "litres";
    }

    @Override
    public String toString() {
        return "milk";
    }

}
