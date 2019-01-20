import java.io.File;
import java.util.Scanner;

public class Printer {
    private File file;

    public Printer(String fileName) throws Exception {
        this.file = new File(fileName);

    }

    public void printLinesWhichContain(String word) {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                if (s.contains(word)) System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("File does not exist.");
        }
    }
}
