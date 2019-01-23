package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> setOfStrings;
    private int numberOfDuplicates;

    public PersonalDuplicateRemover() {
        this.setOfStrings =  new HashSet<String>();
        this.numberOfDuplicates = 0;
    }

    @Override
    public void add(String characterString) {
        boolean added = setOfStrings.add(characterString);
        if(!added) numberOfDuplicates++;
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return numberOfDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return setOfStrings;
    }

    @Override
    public void empty() {
        numberOfDuplicates = 0;
        setOfStrings.clear();
    }
}
