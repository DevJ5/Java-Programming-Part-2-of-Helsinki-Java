import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AirportPanel {
    private HashMap<String, Plane> planes;
    private ArrayList<Flight> flights;
    private Scanner reader;

    public AirportPanel(Scanner reader){
        this.planes = new HashMap<String, Plane>();
        this.flights = new ArrayList<Flight>();
        this.reader = reader;
    }

    public void start(){
        while(true) {
            System.out.println("Airport panel\n --------------------");
            System.out.println("Choose operation: ");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String command = reader.nextLine();
            if(command.equals("1")) {
                addAirplane();
            } else if(command.equals("2")) {
                addFlight();
            } else if(command.equals("x")) {
                break;
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.println("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        Plane plane = new Plane(ID, capacity);
        this.planes.put(cleanString(ID), plane);
    }

    private void addFlight(){
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String depCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String desCode = reader.nextLine();
        Flight flight = new Flight(this.planes.get(cleanString(ID)), depCode, desCode);
        System.out.println(flight);
        this.flights.add(flight);
    }

    private String cleanString(String str) {
       return str.trim().toLowerCase();
    }

}
