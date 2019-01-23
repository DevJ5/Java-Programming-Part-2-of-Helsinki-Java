import java.util.HashSet;
import java.util.Set;

public class Person {
    private String name;
    private String address;
    private Set<String> phoneNumbers = new HashSet<String>();

    public Person(String name) {
        this(name, "address unknown");
    }

    public Person (String name, String address) {
        this.name = name;
        this.address = address;
        this.phoneNumbers = new HashSet<String>();
    }



    public void addPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String toString() {
        return name + " " + address + " " + phoneNumbers;
    }

//    public boolean equals(Object o) {
//        if(o == null) return false;
//        if(getClass() != (o.getClass())) return false;
//
//        Person.java compared = (Person.java) o;
//
//        if(name == null || !name.equals(compared.getName())) return false;
//
//        return true;
//    }
//
//    public int hashCode() {
//        return this.name.hashCode();
//    }
//
//    public int compareTo (Person.java o) {
//        return name.compareToIgnoreCase(o.getName());
//    }

}


