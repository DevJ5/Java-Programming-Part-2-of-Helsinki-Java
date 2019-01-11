import java.util.ArrayList;

public class Suitcase {
    private int maxWeight;
    private ArrayList<Thing> things;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if(thing.getWeight() + totalWeight() <= maxWeight) this.things.add(thing);
    }

    public int totalWeight(){
        int weight = 0;
        for(Thing thing : things) {
            weight += thing.getWeight();
        }

        return weight;
    }

    public void printThings(){
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public Thing heaviestThing(){
        if(things.size() == 0) return null;
        Thing heaviestSoFar = things.get(0);

        for (Thing thing : things) {
            if(heaviestSoFar.getWeight() < thing.getWeight()) heaviestSoFar = thing;
        }

        return heaviestSoFar;
    }

    @Override
    public String toString() {
        if(things.size() == 0) return "empty (0kg)";
        if(things.size() == 1)
            return things.size() + " thing (" + this.totalWeight() + " kg";

        return things.size() + " things (" + this.totalWeight() + " kg";
    }
}
