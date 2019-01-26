package dungeon;

public class Player {
    private int x;
    private int y;
    private int moves;
    private Game game;

    public Player(Game game, int x, int y, int numberOfMoves) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.moves = numberOfMoves;
    }

    public void move(char c) {
        int newX = x;
        int newY = y;
        if (c == 'w') newY--;
        else if (c == 's') newY++;
        else if (c == 'a') newX--;
        else if (c == 'd') newX++;
        else {
            // throw new Error("Not an okay move");
        }

        if(game.check(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void decreaseNumberOfMovesLeft () {
        this.moves--;
    }

    public boolean noMovesLeft() {
        return moves == 0;
    }

    public int numberOfMoves() {
        return moves;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "@ " + x + " " + y;
    }
}
