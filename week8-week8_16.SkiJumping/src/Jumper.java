import java.util.ArrayList;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int points;
    private ArrayList<Integer> lengths;

    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.lengths = new ArrayList<Integer>();
    }

    public void addPoints(int amount) {
        points += amount;
    }

    public void addLength(int length) {
        lengths.add(length);
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Integer> getLengths() {
        return lengths;
    }

    @Override
    public int compareTo(Jumper o) {
        return points - o.points;
    }

    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }
}
