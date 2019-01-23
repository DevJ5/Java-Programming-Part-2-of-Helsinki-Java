import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, Person> persons; // search by name.
    private Map<String, String> phoneNumbers; // search by phone number.

    public Database(){
        this.persons = new HashMap<String, Person>();
        this.phoneNumbers = new HashMap<String, String>();
    }

    public Person getPersonByName(String name) {
        return persons.get(name);
    }

    public void addPerson(Person person) {
        persons.put(person.getName(), person);
    }

    public void addPhoneNumber(String number, String name) {
        phoneNumbers.put(number, name);
    }

    public String getNameByNumber(String name) {
        return phoneNumbers.get(name);
    }

    public void removePerson(String name) {
        persons.remove(name);
    }

}
