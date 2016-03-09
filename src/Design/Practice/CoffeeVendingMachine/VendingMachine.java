package Design.Practice.CoffeeVendingMachine;

/**
 * Created by prashantgolash on 19/02/16.
 */
public class VendingMachine {
    private State _state;
    private Mixer mixer;
    private Dispenser dispenser;

    public Dispenser getDispenser() {
        return null;
    }

    public Mixer getMixer() {
        return null;
    }

    public void nextStep() {
        _state.doExecution(this);
    }

    public void setState(State newState) {
        _state = newState;
    }

    public void operate() {
        while (true) {

        }
    }
}
