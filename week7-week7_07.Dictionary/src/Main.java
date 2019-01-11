
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = "add\n" +  "something\n" + "sumzthing\n" + "translate\n" + "something\n" + "quit";
        Scanner reader = new Scanner(input);
        Dictionary dict = new Dictionary();
        TextUserInterface UI = new TextUserInterface(reader, dict);

        UI.start();

    }
}
