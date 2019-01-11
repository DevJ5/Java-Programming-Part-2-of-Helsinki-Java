import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement:\n" +
                "  quit - quit the text user interface");

        while(true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if(command.equals("add")) {
                System.out.print("In Finnish: ");
                String word = reader.nextLine();
                System.out.print("Translation: ");
                String translated = reader.nextLine();
                this.dictionary.add(word, translated);
            } else if(command.equals("translate")){
                System.out.print("Give a word: ");
                String word = reader.nextLine();
                String translatedWord = this.dictionary.translate(word);
                System.out.print("Translation " + translatedWord);
            } else {
                System.out.println("Unknown statement");
            }
        }
    }
}
