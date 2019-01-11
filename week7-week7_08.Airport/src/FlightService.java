import java.util.Scanner;

public class FlightService {
    private Scanner reader;

    public FlightService(Scanner reader){
        this.reader = reader;
    }

    public void start(){
        System.out.println("Flight service\n------------");
        System.out.println();
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
        System.out.print("> ");
        String command = reader.nextLine();

        while(true) {
            if (command.equals("x")) break;
            else if(command.equals("1")) {
                printPlanes();
            } else if(command.equals("2")) {

            } else if(command.equals("3")) {

            }
        }

        public void printPlanes(){

        }


    }
}
