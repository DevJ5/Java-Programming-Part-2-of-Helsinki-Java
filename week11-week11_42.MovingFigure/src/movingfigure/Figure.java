package movingfigure;

import java.awt.*;

public abstract class Figure {
    private int x;
    private int y;

    public Figure() {
        this(0,0);
    }

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public abstract void draw(Graphics graphics);
}