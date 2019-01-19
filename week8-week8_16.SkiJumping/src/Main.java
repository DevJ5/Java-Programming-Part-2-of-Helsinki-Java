import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Simulator asks for jumper names.
        Simulator Ui = new Simulator(new Scanner(System.in), new Database());
        Ui.start();

        // If the input is empty, we move to jumping phase.
        // Jumpers jump one by one, jumper with least points jumps first, jumper with most points jumps last.
        // There is a total points variable that sums up the points from the rounds.
        // Jump points are decided according to the length and judge decision. Math random 60-120.
        // 5 judges vote 10-20, only the middle three are counted. First and last are not.
        // There are as many rounds as the user wants.
        // When the quit command is given, we print the results.
        // The results include the jumper, their points and the length of the jumps.
        // The results are sorted by most points first.

    }
}
