import java.util.*;

public class RingingCentre {
    private Map<Bird, List<String>> placesObserved;

    public RingingCentre () {
        this.placesObserved = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        bird = searchAndCreateIfNotExists(bird);
        placesObserved.get(bird).add(place);
    }

    public Bird searchAndCreateIfNotExists(Bird bird) {
        if(!placesObserved.containsKey(bird)) {
            List<String> places = new ArrayList<String>();
            placesObserved.put(bird, places);
        }

        return bird;
    }

    public void observations(Bird bird) {
        bird = searchAndCreateIfNotExists(bird);
        List<String> places = placesObserved.get(bird);
        System.out.println(bird.getLatinName() + " (" + bird.getRingingYear() + ") observations: " + places.size());
        for(String place : places) {
            System.out.println(place);
        }
    }
}
