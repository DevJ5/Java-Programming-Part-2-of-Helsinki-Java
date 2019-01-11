import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        Scanner reader = new Scanner(System.in);
        FlightDatabase db = new FlightDatabase(reader);

        AirportPanel airportPanel = new AirportPanel(reader, db);
        airportPanel.start();


//        FlightService flightServiceUI = new FlightService(reader);
//        flightServiceUI.start();
    }
}
