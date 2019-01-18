import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Panel {
    private Scanner reader;
    private Database db;

    public Panel() {
        this.reader = new Scanner(System.in);
        this.db = new Database();
    }

    public void start() {
        AirportPanel airportPanel = new AirportPanel();
        airportPanel.start();

        FlightServicePanel flightServicePanel = new FlightServicePanel();
        flightServicePanel.start();
    }

    private class AirportPanel {
        private void start() {
            System.out.println("Airport panel\n--------------------");
            System.out.println();
            while(true) {
                System.out.println("Choose operation:");
                System.out.println("[1] Add airplane\n[2] Add flight\n[x] Exit");
                System.out.print("> ");
                String input = reader.nextLine();
                if (input.equals("x")) break;

                handleInput(input);
            }
        }

        private void handleInput(String input) {
            if(input.equals("1")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                System.out.print("Give plane capacity: ");
                int capacity = Integer.parseInt(reader.nextLine());
                db.addPlane(new Plane(id, capacity));
            }

            if(input.equals("2")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                System.out.print("Give departure airport code: ");
                String departureCode = reader.nextLine();
                System.out.print("Give destination airport code: ");
                String destinationCode = reader.nextLine();

                Plane plane = db.getPlane(id);
                db.addFlight(new Flight(plane, departureCode, destinationCode));

            }
        }
    }

    private class FlightServicePanel {
        public void start() {
            System.out.println("Flight service\n------------");
            System.out.println();
            while(true) {
                System.out.println("Choose operation:");
                System.out.println("[1] Print planes\n[2] Print flights\n[3] Print plane info\n[x] Quit");
                System.out.print("> ");
                String input = reader.nextLine();
                if (input.equals("x")) break;

                handleInput(input);
            }
        }

        public void handleInput(String input){
            if(input.equals("1")) {
                Map<String, Plane> planes = db.getAllPlanes();
                for (String key : planes.keySet()) {
                    System.out.println(planes.get(key));
                }
            }

            if(input.equals("2")) {
                List<Flight> flights = db.getAllFlights();
                for (Flight flight : flights) {
                    System.out.println(flight);
                }
            }

            if(input.equals("3")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                System.out.println(db.getPlane(id));
            }
        }
    }

}
