import java.util.ArrayList;

public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases =  new ArrayList<Suitcase>();

    public Container (int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        if(calculateWeight() + suitcase.totalWeight() <= maxWeight) suitcases.add(suitcase);
    }

    public int calculateWeight(){
        int total = 0;
        for(Suitcase suitcase : suitcases) {
            total += suitcase.totalWeight();
        }
        return total;
    }

    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }

    @Override
    public String toString() {
        return suitcases.size() + " suitcases (" + calculateWeight() + " kg)";
    }
}
