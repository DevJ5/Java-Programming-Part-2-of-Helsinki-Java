package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MindfulDictionary {
    private Map<String, String> dictionary = new HashMap<String, String>();
    private File file;
    private Scanner reader;

    public MindfulDictionary() {

    }

    public MindfulDictionary(String file) {
        this.file = new File(file);
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                dictionary.put(parts[0], parts[1]);
                dictionary.put(parts[1], parts[0]);
            }
            reader.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(file);
            List<String> alreadyInFile = new ArrayList<String>();

            for (String key : dictionary.keySet()) {
                if (!alreadyInFile.contains(key)) {
                    writer.write(key + ":" + dictionary.get(key) + "\n");
                    alreadyInFile.add(dictionary.get(key));
                }
            }
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void add(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, translation);
            dictionary.put(translation, word);
        }
    }

    public String translate(String word) {
        String translation = dictionary.get(word);
        return translation;
    }

    public void remove(String word) {
        String translation = dictionary.get(word);
        dictionary.remove(translation);
        dictionary.remove(word);
    }
}
