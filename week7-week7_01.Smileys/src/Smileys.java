import java.util.Scanner;

public class Smileys {

    public static void printSmileyLine(int length) {
        int i = 0;
        while (i < length) {
            System.out.print(":)");
            i++;
        }
    }

    public static void printCharacterLine(String input, int spaces) {
        if (spaces == 1) System.out.print(":) " + input + " " + ":)");
        if (spaces == 2) System.out.print(":) " + input + "  " + ":)");
    }

    public static void main(String[] args) {
        // Test your method at least with the following
        // printWithSmileys("Method");
        // printWithSmileys("Beerbottle");
        // printWithSmileys("Interface")
        // Aantal karakters / 2 + 3 bij even. Aantal Math.ceil((double)karakters / 2 + 3 bij odd.

        Scanner reader = new Scanner(System.in);
        System.out.println("What would you like to surround with smileys?");
        String input = reader.nextLine();
        int length = input.length();

        if (length % 2 == 0) {
            printSmileyLine(length / 2 + 3);
            System.out.println("");
            printCharacterLine(input, 1);
            System.out.println("");
            printSmileyLine(length / 2 + 3);
        }

        if (length % 2 != 0) {
            printSmileyLine((int) Math.ceil((double) length / 2) + 3);
            System.out.println("");
            printCharacterLine(input, 2);
            System.out.println("");
            printSmileyLine((int) Math.ceil((double) length / 2) + 3);
        }
    }
}



