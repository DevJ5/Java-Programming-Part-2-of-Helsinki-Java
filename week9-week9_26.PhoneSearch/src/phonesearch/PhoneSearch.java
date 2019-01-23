package phonesearch;

import phonesearch.logic.NumberAndAddressService;
import phonesearch.logic.Person;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PhoneSearch {
    private Scanner reader;
    private Map<String, String> commands;
    private NumberAndAddressService service;

    public PhoneSearch (Scanner reader) {
        this.reader = reader;
        this.service = new NumberAndAddressService();
        this.commands = new TreeMap<String, String>();

        commands.put("1", "1 add a number");
        commands.put("2", "2 search for a number");
        commands.put("3", "3 search for a person by phone number");
        commands.put("4", "4 add an address");
        commands.put("5", "5 search for personal information");
        commands.put("6", "6 delete personal information");
        commands.put("7", "7 filtered listing");
        commands.put("x", "x quit");
    }

    public void start() {
        System.out.println("phone search");
        printInstructions();

        while(true) {
            System.out.println();
            System.out.print("command: ");
            String command = reader.nextLine();

            if(!commands.keySet().contains(command)) {
                System.out.println("invalid command");
                printInstructions();
            }

            if(command.equals("x")) break;
            else if(command.equals("1")) addNumber();
            else if(command.equals("2")) getNumbers();
            else if(command.equals("3")) getName();
            else if(command.equals("4")) addAddress();
            else if(command.equals("5")) getPersonalInfo();
            else if(command.equals("6")) deleteInfo();
            else if(command.equals("7")) list();
        }
    }

    public void printInstructions() {
        for (String command : commands.values()) {
            System.out.println(" " + command);
        }
    }

    public void addNumber () {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();

        service.addPhoneNumber(name, number);
    }

    public void getNumbers () {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        Set<String> numbers = service.getPhoneNumbers(name);

        if(numbers.isEmpty()) {
            System.out.println("  not found");
            return;
        }

        for (String number : numbers) {
            System.out.println(" " + number);
        }
    }

    public void getName() {
        System.out.print("number: ");
        String number = reader.nextLine();

        String name = service.getName(number);
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
        service.addAddress(name, street, city);
    }

    public void getPersonalInfo() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        Person person =  service.searchByName(name);
        if(person == null) System.out.println("  not found");
        else printInfo(person);
    }

    public void printInfo(Person person) {
        printAddress(person);
        printPhoneNumbers(person);
    }

    public void printPhoneNumbers(Person person) {
        Set<String> phoneNumbers = person.getPhoneNumbers();
        if(phoneNumbers.isEmpty()) System.out.println("  phone number not found");
        else {
            System.out.println("  phone numbers:");
            for (String number : phoneNumbers) {
                System.out.println("   " + number);
            }
        }
    }

    public void printAddress(Person person) {
        String street = person.getStreet();
        String city =  person.getCity();
        if(street == null ||  city == null) System.out.println("  address unknown");
        else System.out.println("  address: " + street + " " + city);
    }

    public void deleteInfo() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        service.removePerson(name);
    }

    public void list() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        Set<Person> people = service.filteredSearch(keyword);
        if(people.isEmpty()) System.out.println(" keyword not found");
        else {
            for(Person person : people) {
                System.out.println();
                System.out.println(" " + person.getName());
                printInfo(person);
            }
        }
    }
}
