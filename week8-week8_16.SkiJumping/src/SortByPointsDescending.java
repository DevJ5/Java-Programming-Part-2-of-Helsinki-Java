import java.util.Comparator;

public class SortByPointsDescending implements Comparator<Jumper> {
    public int compare(Jumper jumper1, Jumper jumper2) {
        return jumper2.getPoints() - jumper1.getPoints();
    }
}
