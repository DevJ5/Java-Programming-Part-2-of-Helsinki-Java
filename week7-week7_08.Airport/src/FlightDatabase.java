import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FlightDatabase {
    private HashMap<String, Plane> planes;
    private ArrayList<Flight> flights;
    private Scanner reader;

    public FlightDatabase(Scanner reader) {
        this.planes = new HashMap<String, Plane>();
        this.flights = new ArrayList<Flight>();
        this.reader = reader;
    }

    public void addPlane(String ID, int capacity) {
        this.planes.put(Utils.cleanString(ID), new Plane(ID, capacity));

    }

    public void addFlight(String ID, String departureCode, String destinationCode) {
        String cleanedID = Utils.cleanString(ID);
        if(this.planes.containsKey(cleanedID)) {
            Flight flight = new Flight(this.planes.get(cleanedID), departureCode, destinationCode);
            this.flights.add(flight);
        }
    }
}
