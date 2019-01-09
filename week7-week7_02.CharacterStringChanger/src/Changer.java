import java.util.*;

public class Changer {
    private ArrayList<Change> changeArrayList;

    public Changer(){
        this.changeArrayList = new ArrayList<Change>();
    }

    public void addChange(Change change) {
        this.changeArrayList.add(change);
    }

    public String change(String characterString) {
        String newString = characterString;
        for (Change change : changeArrayList) {
            newString = change.change(newString);
        }
        return newString;
    }
}

