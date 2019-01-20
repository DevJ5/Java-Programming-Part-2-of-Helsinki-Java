package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analysis {
    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws FileNotFoundException{
        String content = readFile();
        return content.split("\n").length;
    }

    public int characters() throws FileNotFoundException{
        String content = readFile();
        return content.length();
    }

    public String readFile() throws FileNotFoundException{
        Scanner reader = new Scanner(file);

        String string = "";
        while(reader.hasNextLine()) {
            string += reader.nextLine();
            string += "\n";
        }

        return string;
    }
}
