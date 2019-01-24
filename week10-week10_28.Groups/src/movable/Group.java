package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private List<Movable> organisms;

    public Group () {
        this.organisms = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable) {
        organisms.add(movable);
    }

    public void move(int dx, int dy) {
        for (Movable organism : organisms) {
            organism.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable organism : organisms) {
            sb.append(organism.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
