import java.util.Scanner;

public class Calculator {
    private Reader reader;
    private int amountOfOperations;

    public Calculator() {
        this.reader = new Reader();
    }

    public void start(){
        while(true) {
            System.out.print("command: ");
            String command = reader.readString();

            if(command.equals("end")) break;

            handleCommand(command);
        }

        statistics();
    }

    private void handleCommand(String command) {
        if(command.equals("sum")) {
            sum();
            amountOfOperations++;
        }
        if(command.equals("difference")) {
            difference();
            amountOfOperations++;
        }
        if(command.equals("product")){
            product();
            amountOfOperations++;
        }
    }

    private void sum() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("sum of the values " + (value1 + value2));
    }

    private void difference() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("difference of the values " + (value1 - value2));
    }

    private void product() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("product of the values " + (value1 * value2));
    }

    private void statistics(){
        System.out.println("Calculations done: " + amountOfOperations);
    }
}
