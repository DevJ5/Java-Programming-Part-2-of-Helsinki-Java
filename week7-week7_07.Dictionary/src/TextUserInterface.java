import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement:\n\tquit - quit the text user interface");

        while(true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();

            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }

            handleCommand(command);
        }
    }

    private void handleCommand(String command) {
        command =  stringCleaner(command);
        if(command.equals("add")) add();
        if(command.equals("translate")) translate();
    }

    private void add() {
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();

        dictionary.add(word, translation);
    }

    private void translate() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();

        String translation = dictionary.translate(word);

        System.out.println("Translation: " + translation);

    }

    private String stringCleaner(String str) {
        return str.trim().toLowerCase();
    }
}
