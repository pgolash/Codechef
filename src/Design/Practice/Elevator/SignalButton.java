package Design.Practice.Elevator;

/**
 * Created by prashantgolash on 30/01/16.
 */
public abstract class SignalButton {
    protected ElevatorController controller;
    protected boolean isPressed;

    public SignalButton(ElevatorController _controller) {

    }

    public SignalButton() {

    }

    public abstract void setPressed();

    public abstract void setUnPressed();
}
