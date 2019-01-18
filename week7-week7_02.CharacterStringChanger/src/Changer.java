import java.util.ArrayList;

public class Changer {
    private ArrayList<Change> changes;

    public Changer() {
        this.changes = new ArrayList<Change>();
    }

    public void addChange(Change change) {
        changes.add(change);
    }

    public String change(String characterString) {
        String copiedString = characterString;

        for (Change change : changes) {
            copiedString = change.change(copiedString);
        }

        return copiedString;
    }
}
