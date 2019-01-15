import java.util.ArrayList;

public class Box implements ToBeStored{
    private final double maxWeight;
    private ArrayList<ToBeStored> things;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.things =  new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored thing) {
        if(weight() + thing.weight() <= maxWeight) things.add(thing);
    }

    public double weight() {
        double total = 0;
        for (ToBeStored thing : things) {
            total += thing.weight();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Box: " + things.size() + " things, total weight " + weight() + " kg";
    }
}
