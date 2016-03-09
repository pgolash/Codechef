package Design.Practice.Zoo;

/**
 * Created by prashantgolash on 21/02/16.
 */
public abstract class Habitat {

    private int size;

    public Habitat(int size) {
        this.size = size;
    }

    public abstract Medium getMedium();
    public int getSize() {
        return size;
    }
}
