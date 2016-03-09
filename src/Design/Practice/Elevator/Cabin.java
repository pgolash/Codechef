package Design.Practice.Elevator;

import java.util.List;

/**
 * Created by prashantgolash on 30/01/16.
 */
public class Cabin {
    private List<SignalButton> buttons;
    private int numFloors;
    private CabinMovementCommand currentCommand;


    public Cabin(List<FloorSignalButton> buttons, int numFloors) {

    }

    public void interruptWithNewCurrentCommand(CabinMovementCommand c) {
        currentCommand = c;
    }

}
