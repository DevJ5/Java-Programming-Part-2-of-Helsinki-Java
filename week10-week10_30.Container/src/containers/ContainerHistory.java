package containers;

import java.util.ArrayList;
import java.util.Collections;

public class ContainerHistory {
    private ArrayList<Double> containerHistory;

    public ContainerHistory () {
        this.containerHistory = new ArrayList<Double>();
    }

    public void add(double situation) {
        containerHistory.add(situation);
    }

    public void reset() {
        containerHistory.clear();
    }

    public double maxValue() {
        if(containerHistory.isEmpty()) return 0;
        return Collections.max(containerHistory);
    }

    public double minValue() {
        if(containerHistory.isEmpty()) return 0;
        return Collections.min(containerHistory);
    }

    public double average() {
        if(containerHistory.isEmpty()) return 0;
        double total = 0;

        for (Double aDouble : containerHistory) {
            total += aDouble;
        }

        double average = total / containerHistory.size();

        return average;
    }

    public double greatestFluctuation() {
        if(containerHistory.size() <= 1) return 0;

        double greatestSoFar = 0;
        for (int i = 0; i < containerHistory.size() - 1; i++) {
            double fluctuation = Math.abs(containerHistory.get(i) - containerHistory.get(i + 1));
            if(greatestSoFar < fluctuation) greatestSoFar = fluctuation;
        }

        return greatestSoFar;
    }

    public double variance () {
        if(containerHistory.size() <= 1) return 0;
        double avg =  average();

        double sumOfQuadrants = 0;

        for (Double aDouble : containerHistory) {
            sumOfQuadrants += Math.pow((aDouble - avg), 2);
        }

        double variance = sumOfQuadrants / (containerHistory.size() - 1);
        return variance;
    }

    @Override
    public String toString() {
        return containerHistory.toString();
    }
}
