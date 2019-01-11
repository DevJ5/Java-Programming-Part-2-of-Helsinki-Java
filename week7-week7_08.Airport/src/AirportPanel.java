import java.util.Scanner;

public class AirportPanel {
    private FlightDatabase db;
    private Scanner reader;

    public AirportPanel(Scanner reader, FlightDatabase db){
        this.db = db;
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
                System.out.print("Give plane ID: ");
                String ID = reader.nextLine();
                System.out.println("Give plane capacity: ");
                int capacity = Integer.parseInt(reader.nextLine());
                db.addPlane(ID, capacity);
            } else if(command.equals("2")) {
                System.out.print("Give plane ID: ");
                String ID = reader.nextLine();
                System.out.print("Give departure airport code: ");
                String departureCode = reader.nextLine();
                System.out.print("Give destination airport code: ");
                String destinationCode = reader.nextLine();
                db.addFlight(ID, departureCode, destinationCode);
                db.addFlight();
            } else if(command.equals("x")) {
                break;
            }
        }
    }
}
