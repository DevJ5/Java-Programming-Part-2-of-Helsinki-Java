package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int length;
    private int height;
    private boolean vampiresMove;
    private List<Vampire> vampires = new ArrayList<Vampire>();
    private Player player;
    private boolean end;

    public Game(int length, int height, int numberOfVampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;

        Random r = new Random();

        for (int i = 0; i < numberOfVampires; i++) {
            int x = r.nextInt(length);
            int y = r.nextInt(height);
            vampires.add(new Vampire(this, x, y));
        }

        this.player = new Player(this, 0, 0, moves);
        this.vampiresMove = vampiresMove;
    }

    public boolean check(int newX, int newY) {
        return newX < length && newX >= 0 &&
                newY < height && newY >= 0;
    }

    public boolean finished() {
        return end;
    }

    public String situation() {
        StringBuilder sb = new StringBuilder();
        playersAndVampiresSituation(sb);
        createDungeon(sb);
        return sb.toString();
    }

    public void playersAndVampiresSituation(StringBuilder sb) {
        sb.append(player.numberOfMoves()).append("\n\n");
        sb.append(player.toString()).append("\n");
        for (Vampire vampire : vampires) {
            sb.append(vampire.toString()).append("\n");
        }
        sb.append("\n");
    }

    public void createDungeon(StringBuilder sb) {
        char[][] dungeon = new char[height][length];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < length; col++) {
                dungeon[row][col] = '.';
            }
        }

        for (Vampire vampire : vampires) {
            dungeon[vampire.getY()][vampire.getX()] = 'v';
        }

        dungeon[player.getY()][player.getX()] = '@';

        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[i].length; j++) {
                sb.append(dungeon[i][j]);
            }
            sb.append("\n");
        }
    }

    public void execute(String command) {
        for (char c : command.toCharArray()) {
            player.move(c);
            killVampires();
            if(vampiresMove) {
                for(Vampire vampire : vampires) {
                    vampire.move();
                }
            }
            killVampires();
        }
        player.decreaseNumberOfMovesLeft();
        if(player.noMovesLeft() || vampires.isEmpty()) end = true;
    }

    public void killVampires() {
        List<Vampire> deadVampires = new ArrayList<Vampire>();
        for (Vampire vampire : vampires) {
            if (player.getX() == vampire.getX() &&
                    player.getY() == vampire.getY()) {
                deadVampires.add(vampire);
            }
        }
        vampires.removeAll(deadVampires);
    }

    public boolean didPlayerWin() {
        return vampires.isEmpty();
    }
}
