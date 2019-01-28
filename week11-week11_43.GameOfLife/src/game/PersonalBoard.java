package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    public void initiateRandomCells(double var1) {
        boolean[][] board = getBoard();
        for(int x = 0; x < getWidth(); x++) {
            for(int y = 0; y < getHeight(); y++) {
                if(new Random().nextDouble() < var1) {
                    turnToLiving(x,y);
                }
            }
        }
    }

    public boolean isAlive(int var1, int var2) {
        try {
            return getBoard()[var1][var2];
        } catch (Exception e) {
            return false;
        }
    }

    public void turnToLiving(int var1, int var2) {
        try {
            getBoard()[var1][var2] = true;
        } catch (Exception e) {
        }
    }

    public void turnToDead(int var1, int var2) {
        try {
            getBoard()[var1][var2] = false;
        } catch (Exception e) {
        }
    }

    public int getNumberOfLivingNeighbours(int var1, int var2) {
        int result = 0;
        for(int x = var1 - 1; x <= var1 + 1; x++) {
            for(int y = var2 - 1; y <= var2 + 1; y++) {
                boolean sameCell = var1 == x && var2 == y;
                if(isAlive(x, y) && !sameCell) result++;
            }
        }

        return result;
    }

    public void manageCell(int var1, int var2, int var3) {
        if(isAlive(var1, var2)) {
            if(var3 < 2) getBoard()[var1][var2] = false;
            else if(var3 > 3) getBoard()[var1][var2] = false;
        } else {
            if(var3 == 3) getBoard()[var1][var2] = true;
        }
    }
}
