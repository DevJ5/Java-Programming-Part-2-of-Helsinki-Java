import java.util.Scanner;

public class UI {
    private Scanner reader;
    private Database db;

    public UI(Scanner reader, Database db) {
        this.reader = reader;
        this.db = db;
    }

    public void start() {
        System.out.println("phone search\navailabe operations: ");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");

        while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();

            if (command.equals("x")) break;
            handleCommand(command);
        }
    }

    public void handleCommand(String command) {
        if (command.equals("1")) addPhoneNumber();
        else if (command.equals("2")) searchNumber();
        else if(command.equals("3")) searchName();
        else if(command.equals("4")) addAddress();
        else if(command.equals("5")) showInfo();
        else if(command.equals("6")) deletePerson();
    }

    public void addPhoneNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String phoneNumber = reader.nextLine();

        // Add phone number to persons Map.
        Person person = db.getPersonByName(name);
        if (person == null) {
            Person newPerson = new Person(name);
            newPerson.addPhoneNumber(phoneNumber);
            db.addPerson(newPerson);
        } else {
            person.addPhoneNumber(phoneNumber);
        }

        // Add phone number to phone numbers Map.
        db.addPhoneNumber(phoneNumber, name);
    }

    public void searchNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();

        Person person = db.getPersonByName(name);

        if (person == null || person.getPhoneNumbers().size() == 0) System.out.println("  not found");

        else {
            for (String phoneNumber : person.getPhoneNumbers()) {
                System.out.println(" " + phoneNumber);
            }
        }
    }

    public void searchName() {
        System.out.print("number: ");
        String phoneNumber = reader.nextLine();

        String name = db.getNameByNumber(phoneNumber);

        if(name == null) System.out.println(" not found");
        else System.out.println(name);
    }

    public void addAddress () {
        System.out.print("whose address: ");
        String name = reader.nextLine();

        System.out.print("street: ");
        String street = reader.nextLine();

        System.out.print("city: ");
        String city = reader.nextLine();

        String address = street + " " + city;

        Person person = db.getPersonByName(name);
        if(person == null) db.addPerson(new Person(name, address));
        else person.setAddress(street + " " + city);
    }

    public void showInfo () {
        System.out.print("whose information: ");
        String name = reader.nextLine();

        Person person = db.getPersonByName(name);
        if(person == null) System.out.println("  not found");
        else {
            System.out.println("address: " + person.getAddress());
            if(person.getPhoneNumbers().size() == 0) System.out.println("phone number not found");
            else {
                for(String phoneNumber : person.getPhoneNumbers()) {
                    System.out.println(phoneNumber);
                }
            }
        }

    }

    public void deletePerson() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        db.removePerson(name);
    }
}
