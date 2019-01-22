package dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        PersonalMultipleEntryDictionary dict = new PersonalMultipleEntryDictionary();
        dict.add("kuusi", "six");
        dict.add("kuusi", "spruce");
        System.out.println(dict.translate("kuusi"));
        dict.remove("kuusi");
        System.out.println(dict.translate("kuusi"));
    }
}
