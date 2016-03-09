package Design.Practice.CoffeeVendingMachine;

/**
 * Created by prashantgolash on 19/02/16.
 */
public class Coffee extends Ingredient {

    public Coffee(int quantity){super(quantity);}
    @Override
    public String unit() {
        return "litres";
    }

    @Override
    public String toString() {
        return "milk";
    }


}
