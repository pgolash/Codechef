package Design.Practice.CoffeeVendingMachine;

/**
 * Created by prashantgolash on 19/02/16.
 */

/*
    visitor         [revise]
    bridge          [revise]
    mediator        [revise]
    state

    singleton
    builder
    iterator

    command         [revise]
    composite
    flyweight

    chain of responsibility
    facade
    observer
    factory
    abstract factory [revise]

 */

public abstract class Ingredient {
    private double initialQuantity;
    private double availabileQuantity;

    public Ingredient(double initialQuantity) {

    }

    public boolean isAvailable(double quantity) {
        return availabileQuantity - quantity >= 0;
    }

    public void getQuantity(double quantity) {
        availabileQuantity -= quantity;
    }

    public abstract String unit();
    public abstract String toString();
}
