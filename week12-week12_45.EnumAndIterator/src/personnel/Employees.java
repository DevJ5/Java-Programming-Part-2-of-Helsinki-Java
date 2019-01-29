package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> people;

    public Employees(){
        this.people = new ArrayList<Person>();
    }

    public void add(Person person) {
        people.add(person);
    }

    public void add(List<Person> persons) {
        people.addAll(persons);
    }

    public void print() {
        Iterator<Person> iterator = people.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> iterator = people.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getEducation().equals(education))
            System.out.println(person);
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = people.iterator();
        while(iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
