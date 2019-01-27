package dictionary;

public class Main {
    public static void main(String[] args) throws Exception {
        // Test your dictionary here
        MindfulDictionary dict = new MindfulDictionary();
        dict.add("apina", "monkey");
        dict.add("tietokone", "computer");
        System.out.println(dict.translate("monkey"));
    }
}
