package ru.vsu.cs.kodintsev.elements.background;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Star {
    private int sX;
    private int sY;
    private Color c;
    private static final Random rnd = new Random();


    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getsX() {
        return sX;
    }

    public void setsX(int sX) {
        this.sX = sX;
    }

    public int getsY() {
        return sY;
    }

    public void setsY(int sY) {
        this.sY = sY;
    }

    public Star(Color c, int sX, int sY) {
        this.c = c;
        this.sX = sX;
        this.sY = sY;
    }

    public void twinkle() {
        int brightness = rnd.nextInt(155) + 100;
        this.c = new Color(brightness, brightness, brightness);
    }

    public static void drawStar(Graphics2D g, int sX, int sY, Color c) {
        g.setPaint(c);
        g.drawLine(sX, sY + 10, sX + 20, sY + 10);
        g.drawLine(sX + 10, sY, sX + 10, sY + 20);
    }

    public static void drawStars(Graphics2D g, List<Star> stars) {
        for (Star star : stars) {
            drawStar(g, star.getsX(), star.getsY(), star.getC());
        }
    }
}