package ru.vsu.cs.kodintsev.elements.background;

import java.awt.*;

public class Background {
    private int width;
    private int height;
    private Color c;
    private Color c2;


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

    public Background(int width, int height, Color c, Color c2) {
        this.width = width;
        this.height = height;
        this.c = c;
        this.c2 = c2;
    }

    public void draw(Graphics2D g) {
        g.setPaint(c);
        g.fillRect(0,0,width,height);
        g.setPaint(c2);
        g.fillRect(0,(int)(height / 1.65),width,(int)(height / 1.65));
    }
}
