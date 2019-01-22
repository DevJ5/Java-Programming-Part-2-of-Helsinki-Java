package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> translations;

    public PersonalMultipleEntryDictionary() {
        this.translations = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if(!translations.containsKey(word)) {
            translations.put(word, new HashSet<String>());
        }

        translations.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        return translations.get(word);
    }

    @Override
    public void remove(String word) {
        translations.remove(word);
    }
}
