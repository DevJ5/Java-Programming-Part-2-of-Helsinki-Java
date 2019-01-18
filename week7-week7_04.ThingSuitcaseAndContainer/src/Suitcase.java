import java.util.ArrayList;

public class Suitcase {
    private int maxWeight;
    private ArrayList<Thing> things = new ArrayList<Thing>();

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addThing(Thing thing) {
        if(totalWeight() + thing.getWeight() <= maxWeight) {
            things.add(thing);
        }
    }

    public int totalWeight(){
        int total = 0;
        for (Thing thing : things) {
            total += thing.getWeight();
        }

        return total;
    }

    public Thing heaviestThing(){
        if(things.size() == 0) return null;

        Thing heaviest = things.get(0);
        for (int i = 1; i < things.size(); i++) {
            if(things.get(i).getWeight() > heaviest.getWeight()) heaviest = things.get(i);
        }

        return heaviest;
    }

    @Override
    public String toString() {
        if(things.size() == 0) return "empty 0 (kg)";
        String strSingleOrPlural =  things.size() == 1 ? " thing " : " things ";
        return things.size() + strSingleOrPlural + "(" + totalWeight() + "kg)";
    }

    public void printThings(){
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }
}
