package Design.Practice.CoffeeVendingMachine;

/**
 * Created by prashantgolash on 19/02/16.
 */
public class DispensingState implements State {

    @Override
    public void doExecution(VendingMachine machine) {
        machine.getDispenser().dispense();
    }
}
