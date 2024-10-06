package ru.vsu.cs.kodintsev.elements.background;

import java.awt.*;

public class Moon {
    private int x;
    private int y;
    private int r;
    private Color c;

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

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

    public Moon(Color c, int r, int x, int y) {
        this.c = c;
        this.r = r;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setPaint(c);
        g.fillOval(x,y,2 * r, 2 * r);
    }
}
