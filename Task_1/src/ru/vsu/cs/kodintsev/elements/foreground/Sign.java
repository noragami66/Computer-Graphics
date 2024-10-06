package ru.vsu.cs.kodintsev.elements.foreground;

import java.awt.*;

public class Sign {
    private int x;
    private int y;
    private int height;
    private int width;
    private String text;

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Sign(int x, int y, int height, int width, String text) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.text = text;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.decode("#362624"));
        g.fillRect(x + width/2,y,width/2,height);
        g.setColor(Color.decode("#483C32"));
        g.fillRect(x,y,width + width/2,height/2);
        g.setColor(Color.decode("#AE9B8B"));
        g.drawString(text,x + width/2,y + height/4);
    }
}
