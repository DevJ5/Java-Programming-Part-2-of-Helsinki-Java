package reference.comparator;

import reference.domain.Person;

import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }

    public int compare(Person person1, Person person2) {
        return peopleIdentities.get(person2) - peopleIdentities.get(person1);
    }

}
