package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox (int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    private int calculateWeight () {
        int total = 0;
        for (Thing thing : things) {
            total += thing.getWeight();
        }

        return total;
    }

    public void add(Thing thing) {
        if(calculateWeight() + thing.getWeight() <= maxWeight) things.add(thing);
    }

    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }

    public void printThings () {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

}
