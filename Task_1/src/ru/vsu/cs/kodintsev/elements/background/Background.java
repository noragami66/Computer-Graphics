package ru.vsu.cs.kodintsev.elements.background;

import java.awt.*;

public class Background {
    private int width;
    private int height;
    private Color c;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Background(int width, int height, Color c) {
        this.width = width;
        this.height = height;
        this.c = c;
    }

    public static void drawBackground(Graphics2D g,int width, int height, Color c1, Color c2) {
        g.setPaint(c1);
        g.fillRect(0,0,width,height);
        g.setPaint(c2);
        g.fillRect(0,(int)(height / 1.65),width,(int)(height / 1.65));
    }
}
