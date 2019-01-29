package reference;

import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Person matti = new Person("Matti");
        Person pekka = new Person("Pekka");
        Person mikke = new Person("Mikke");
        Person thomas = new Person("Thomas");

        Map<Person, Integer> peopleIdentities = new HashMap<Person, Integer>();
        peopleIdentities.put(matti, 42);
        peopleIdentities.put(pekka, 134);
        peopleIdentities.put(mikke, 8);
        peopleIdentities.put(thomas, 82);

        List<Person> ppl = Arrays.asList(matti, pekka, mikke, thomas);
        System.out.println("People before sorting: " + ppl);

        Collections.sort(ppl, new PersonComparator(peopleIdentities));
        System.out.println("People after sorting: " + ppl);

    }
}
