package ru.vsu.cs.kodintsev.elements.background;

import java.awt.*;

public class Tree {
    private int x;
    private int y;
    private int height;
    private Color c;

    public Tree(Color c, int height, int x, int y) {
        this.c = c;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public void draw(Graphics2D g) {
        g.setPaint(c);
        int[] xPoints = {x, x + 100, x + 50};
        int[] yPoints = {y, y, y - height};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
