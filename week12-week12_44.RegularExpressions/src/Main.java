import java.util.Scanner;

public class Main {

    public static boolean isAWeekDay(String string) {
        return string.matches("(mon|tue|wed|thu|fri|sat|sun)");
    }

    public static boolean allVowels(String string) {
        return string.matches("[aeiouäö]*");
    }

    public static boolean clockTime(String string) {
        // return string.matches("([0-2][0-3]|[10-23]):(0[0-9]|[10-60]):(0[0-9]|[10-60])");
        return string.matches("(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        while(true) {
            System.out.print("enter id: ");
            String id = reader.nextLine();
            System.out.println(clockTime(id));
        }

    }
}