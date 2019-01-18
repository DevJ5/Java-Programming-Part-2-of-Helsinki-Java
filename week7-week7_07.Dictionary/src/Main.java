
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        TextUserInterface UI = new TextUserInterface(new Scanner(System.in), d);

        UI.start();
    }
}
