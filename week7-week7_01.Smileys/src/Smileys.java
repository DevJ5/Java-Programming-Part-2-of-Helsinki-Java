
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        System.out.println(botAndTopLine(characterString));
        System.out.println(middleLine(characterString));
        System.out.println(botAndTopLine(characterString));
    }

    private static String botAndTopLine(String characterString){
        int length =  characterString.length();
        int i;
        i = length % 2 == 1 ? length / 2 + 4 : length / 2 + 3;

        StringBuilder sb = new StringBuilder();

        while(i > 0) {
            sb.append(":)");
            i--;
        }
        return sb.toString();
    }

    private static String middleLine(String characterString) {
        StringBuilder sb = new StringBuilder();
        sb.append(":) ");
        sb.append(characterString);
        sb.append(" ");
        if(characterString.length() % 2 == 1) sb.append(" ");
        sb.append(":)");

        return sb.toString();
    }

}
