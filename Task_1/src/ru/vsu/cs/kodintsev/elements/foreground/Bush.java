package ru.vsu.cs.kodintsev.elements.foreground;

import java.awt.*;

public class Bush {
    private int x;
    private int y;
    private int r;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bush(int r, int x, int y) {
        this.r = r;
        this.x = x;
        this.y = y;
    }

    public static void drawBush(Graphics2D g, int x, int y, int r) {
            g.setPaint(Color.decode("#7c7b5f"));
            g.fillOval(x,y,2 * r, 2 * r);
            g.fillOval(x + 100,y + 25,2 * r, 2 * r);
            g.fillOval(x + 200,y + 50,2 * r, 2 * r);
            g.fillOval(x - 100,y + 10,2 * r, 2 * r);
            g.fillOval(x - 200,y + 25,2 * r, 2 * r);
            g.setPaint(Color.decode("#6b6a54"));
            g.fillOval(x + 100,y + 45,2 * r, 2 * r);
            g.fillOval(x + 200,y + 60,2 * r, 2 * r);
            g.fillOval(x - 100,y + 20,2 * r, 2 * r);
            g.fillOval(x - 300,y + 30,2 * r, 2 * r);
            g.setPaint(Color.decode("#585744"));
            g.fillOval(x + 100,y + 55,2 * r, 2 * r);
            g.fillOval(x + 200,y + 90,2 * r, 2 * r);
            g.fillOval(x - 100,y + 40,2 * r, 2 * r);
            g.fillOval(x - 300,y + 55,2 * r, 2 * r);
    }
}
