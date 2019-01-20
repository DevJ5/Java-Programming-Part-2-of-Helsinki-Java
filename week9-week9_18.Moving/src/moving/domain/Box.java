package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {
    private int maximumCapacity;
    private List<Thing> things = new ArrayList<Thing>();

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getVolume() {
        int total = 0;
        for (Thing thing : things) {
            total += thing.getVolume();
        }

        return total;
    }

    public boolean addThing(Thing thing) {
        if(getVolume() + thing.getVolume() <= maximumCapacity) {
            things.add(thing);
            return true;
        }

        return false;
    }

}
