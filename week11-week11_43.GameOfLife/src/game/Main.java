package game;

import gameoflife.GameOfLifeBoard;

public class Main {

    public static void main(String[] args) {
        // Every cell dies if they have less than two living neighbours.
        // Every living cell keeps on living during the following iteration if they have two or three living neighbours.
        // Every living cell dies if they have more than three living neighbours.
        // Every dead cell is turned back to life if they have exactly three living neighbours.
        PersonalBoard board = new PersonalBoard(7, 5);

        board.turnToLiving(0, 1);
        board.turnToLiving(1, 0);
        board.turnToLiving(1, 2);
        board.turnToLiving(2, 2);
        board.turnToLiving(2, 1);

        System.out.println("Neighbours alive (0,0): " + board.getNumberOfLivingNeighbours(0, 0));
        System.out.println("Neighbours alive (1,1): " + board.getNumberOfLivingNeighbours(1, 1));
    }
}
