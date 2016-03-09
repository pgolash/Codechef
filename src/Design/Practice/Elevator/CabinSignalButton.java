package Design.Practice.Elevator;

/**
 * Created by prashantgolash on 30/01/16.
 */
public class CabinSignalButton extends SignalButton {
    private int floorNumber;
    private boolean isPressed;

    public CabinSignalButton(boolean isPressed) {
        isPressed = false;
    }

    public void setPressed() {
        isPressed = true;
        controller.queueRequest(new GenericRequest(this));
    }

    public void setUnPressed() {

    }


}
