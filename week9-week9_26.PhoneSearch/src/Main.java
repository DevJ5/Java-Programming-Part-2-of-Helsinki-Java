import phonesearch.PhoneSearch;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Goal: An application that manages people and their phone numbers/addresses.
        // 1. It should add a phone number to a person.
        // 2. It should search for a phone number by entering a person.
        // 3. It should search for a name by entering a phone number.
        // 4. It should be able to add an address to a person.
        // 5. It should search for a persons information (both address and phone number).
        // 6. It should be able to remove a person's information.
        // 7. It should have a search by keyword functionality. This can be any characters that correspond with either name or address.
//        UI ui = new UI(new Scanner(System.in), new Database());
//        ui.start();

        Scanner reader = new Scanner(System.in);

        PhoneSearch search = new PhoneSearch(reader);

        search.start();

    }
}
