import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Simulator {
    private Scanner reader;
    private Database db;
    private int rounds;

    public Simulator(Scanner reader, Database db) {
        this.reader = reader;
        this.db = db;
        this.rounds = 0;

    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        // Ask for a name and add it to the database. If empty string is given proceed to jump phase.
        while(true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if(name.equals("")) break;

            db.addJumper(new Jumper(name));
        }

        // Start the jump if the command is jump, otherwise quit.
        System.out.println("The tournament begins!\n");
        while(true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: \n");
            String command = stringCleaner(reader.nextLine());
            if (!command.equals("jump")) break;

            jump();
        }

        printResults();

    }

    private void jump() {
        // Write out the jumping order for the round
        rounds++;
        System.out.println("Round " + rounds + "\n");
        System.out.println("Jumping order:");
        db.sort();
        ArrayList<Jumper> jumpers = db.getJumpers();

        for (int i = 0; i < jumpers.size(); i++) {
            System.out.println("  " + (i+1) + ". " + jumpers.get(i));
        }

        System.out.println();

        // Calculate the points for each jumper
        System.out.println("Results of round " + rounds);
        for (int i = 0; i < jumpers.size(); i++) {
            System.out.println("  " + jumpers.get(i).getName());

            int randomLength = (int) (Math.random() * (120 - 60)) + 60;
            jumpers.get(i).addLength(randomLength);
            System.out.println("    " + "length: " + randomLength);

            int[] votes = new int[5];
            for(int v = 0; v < votes.length; v++) {
                int randomVote = (int)(Math.random() * (20 - 10)) + 10;
                votes[v] = randomVote;
            }

            System.out.println("    " + "judge votes: " + Arrays.toString(votes));

            Arrays.sort(votes);
            jumpers.get(i).addPoints(randomLength + votes[1] + votes[2] + votes[3]);
        }
    }

    private void printResults() {
        System.out.println("Thanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");

        ArrayList<Jumper> jumpers = db.getJumpers();
        Collections.sort(jumpers, new SortByPointsDescending());
        for(int i = 0; i < jumpers.size(); i++) {
            System.out.println((i+1) + "           " + jumpers.get(i));
            System.out.print("            " + "jump lengths: ");
            ArrayList lengths = jumpers.get(i).getLengths();
            for(int l = 0; l < lengths.size(); l++) {
                if(l == lengths.size() - 1) {
                    System.out.print(lengths.get(l) + " m\n");
                } else {
                    System.out.print(lengths.get(l) + " m, ");
                }
            }
        }
    }

    private String stringCleaner(String input) {
        return input.trim().toLowerCase();
    }
}
