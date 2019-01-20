package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private File file;
    private ArrayList<String> words;
    private final String vowels = "aeoiuyäö";

    public WordInspection(File file) throws FileNotFoundException {
        this.file = file;
        this.words = readFile();
    }

    private ArrayList<String> readFile() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        ArrayList<String> words = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            line = line.trim();
            if (!line.isEmpty()) words.add(line);
        }

        return words;
    }

    public int wordCount() throws FileNotFoundException {
        return words.size();
    }

    public List<String> wordsContainingZ() throws FileNotFoundException {
        List<String> wordsWithZ = new ArrayList<String>();

        for (String word :  words) {
            if (word.contains("z")) wordsWithZ.add(word);
        }

        return wordsWithZ;
    }

    public List<String> wordsEndingInL() throws FileNotFoundException {
        List<String> wordsEndingL = new ArrayList<String>();

        for (String word : words) {
            if (word.endsWith("l")) wordsEndingL.add(word);
        }

        return wordsEndingL;
    }

    public List<String> palindromes() {
        List<String> palindromeList = new ArrayList<String>();

        for (String word : words) {
            Boolean bool = true;
            for (int i = 0; i < word.length() / 2; i++) {
                System.out.println(word);
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    bool = false;
                    break;
                }
            }

            if (bool) palindromeList.add(word);
        }

        return palindromeList;
    }

    public List<String> wordsWhichContainAllVowels() {
        ArrayList<String> wordsWithAllVowels = new ArrayList<String>();

        for (String word : words) {
            if(containsVowel(word)) wordsWithAllVowels.add(word);
        }

        return wordsWithAllVowels;
    }

    public boolean containsVowel(String word) {
        for (int i = 0; i < vowels.length(); i++) {
            if(!word.contains(String.valueOf(vowels.charAt(i)))) return false;
        }
        return true;
    }


}

