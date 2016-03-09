package Design.Practice.Elevator;

/**
 * Created by prashantgolash on 30/01/16.
 */
public class FloorSignalButton extends SignalButton{
    private Direction direction;

    public void setPressed() {
        isPressed = true;
        controller.queueRequest(new GenericRequest(this));
    }

    public void setUnPressed() {
        isPressed = false;
    }
}
