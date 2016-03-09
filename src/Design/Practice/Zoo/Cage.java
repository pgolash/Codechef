package Design.Practice.Zoo;

import java.util.List;

/**
 * Created by prashantgolash on 20/02/16.
 */
public class Cage extends Habitat {
    private List<Animal> animals;

    public Cage(int size, List<Animal> animals) {
        super(size);
        this.animals = animals;
    }

    @Override
    public Medium getMedium() {
        return Medium.AIR;
    }
}