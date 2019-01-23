package phonesearch.logic;

import java.util.*;

public class NumberAndAddressService {
    private Map<String, Person> personsByName;
    private Map<String, Person> personsByPhoneNumber;

    public NumberAndAddressService() {
        this.personsByName = new TreeMap<String, Person>();
        this.personsByPhoneNumber = new TreeMap<String, Person>();
    }

    public void addPhoneNumber(String name, String number) {
        Person person = searchAndCreateIfDoesntExist(name);

        person.addPhoneNumber(number);
        personsByPhoneNumber.put(number, person);
    }

    public Set<String> getPhoneNumbers (String name) {
        Person person = personsByName.get(name);
        if(person == null) return new HashSet<String>();

        return person.getPhoneNumbers();
    }

    public String getName (String phoneNumber) {
        Person person  = personsByPhoneNumber.get(phoneNumber);
        if(person == null) return null;
        return person.getName();
    }

    public void addAddress (String name, String street, String city) {
        Person person = searchAndCreateIfDoesntExist(name);
        person.setAddress(street, city);
    }

    private Person searchAndCreateIfDoesntExist(String name) {
        Person person = searchByName(name);
        if (person == null) {
            person = new Person(name);
            personsByName.put(name, person);
        }
        return person;
    }

    public Person searchByName(String name) {
        // personsByName.get(name);
        for (Person h : personsByName.values()) {
            if (h.getName().equals(name)) {
                return h;
            }
        }
        return null;
    }

    public void removePerson(String name) {
        Person person = personsByName.get(name);
        if(person == null) return;

        Set<String> phoneNumbers = person.getPhoneNumbers();
        personsByName.remove(name);

        for(String phoneNumber : phoneNumbers) {
            personsByPhoneNumber.remove(phoneNumber);
        }
    }

    public Set<Person> filteredSearch(String keyword) {
        Set<Person> matchingPersons = new TreeSet<Person>();
        for(String key : personsByName.keySet()) {
            if(key.contains(keyword)) matchingPersons.add(personsByName.get(key));
        }

        Collection<Person> people = personsByName.values();
        for(Person person : people) {
            if(person.getCity() != null && person.getCity().contains(keyword)) matchingPersons.add(person);
            else if(person.getStreet() != null && person.getStreet().contains(keyword)) matchingPersons.add(person);
        }
        return matchingPersons;

    }
}
