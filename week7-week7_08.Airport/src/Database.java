import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    // Add planes and flights.
    private HashMap<String, Plane> planesCollection;
    private ArrayList<Flight> flightsCollection;

    public Database() {
        this.planesCollection = new HashMap<String, Plane>();
        this.flightsCollection = new ArrayList<Flight>();
    }

    public void addPlane(Plane plane) {
        planesCollection.put(plane.getID(), plane);
    }

    public void addFlight(Flight flight) {
        flightsCollection.add(flight);
    }

    public Map<String, Plane> getAllPlanes() {
        return planesCollection;
    }

    public Plane getPlane(String id){
        return planesCollection.get(id);
    }

    public List<Flight> getAllFlights() {
        return flightsCollection;
    }
}
