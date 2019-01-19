import java.util.ArrayList;
import java.util.Collections;

public class Database {
    private ArrayList<Jumper> jumpers = new ArrayList<Jumper>();

    public void addJumper(Jumper jumper) {
        jumpers.add(jumper);
    }

    public void sort() {
        Collections.sort(jumpers);
    }

    public ArrayList<Jumper> getJumpers() {
        return jumpers;
    }
}
