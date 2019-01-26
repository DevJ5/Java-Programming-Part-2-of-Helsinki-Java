
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File newFile = new File(file);
        Scanner reader = new Scanner(newFile);

        List<String> stringList = new ArrayList<String>();

        while(reader.hasNextLine()) {
            stringList.add(reader.nextLine());
        }

        return stringList;
    }

    public void save(String file, String text) throws IOException {
        File newFile = new File(file);
        FileWriter writer = new FileWriter(newFile);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        File newFile = new File(file);
        FileWriter writer = new FileWriter(newFile);
        for (String text : texts) {
            writer.write(text + "\n");
        }
        writer.close();
    }
}
