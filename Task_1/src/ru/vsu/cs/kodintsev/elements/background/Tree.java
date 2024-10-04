package ru.vsu.cs.kodintsev.elements.background;

import java.awt.*;
import java.util.List;

public class Tree {
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

    public Tree(Color c, int height, int x, int y) {
        this.c = c;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;
    private int height;
    private Color c;

    public static void drawTree(Graphics2D g, int x, int y, int height, Color c) {
        g.setPaint(c);
        int[] xPoints = {x, x + 100, x + 50};
        int[] yPoints = {y, y, y - height};
        g.fillPolygon(xPoints, yPoints, 3);
    }
    public static void drawTrees(Graphics2D g, List<Tree> trees) {
        for (Tree tree : trees) {
            drawTree(g, tree.getX(), tree.getY(), tree.getHeight(),tree.getC());
        }
    }
}
