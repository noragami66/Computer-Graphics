package ru.vsu.cs.kodintsev.elements.middle;

import java.awt.*;

public class Church {
    private int x;
    private int y;

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

    public Church(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void drawChurch(Graphics2D g, int x, int y) {
        g.setPaint(Color.decode("#4a4a4a")); // внешняя стена
        int[] xWallPoints = {x, x + 150, x + 150, x};
        int[] yWallPoints = {y, y, y - 100, y - 100};
        g.fillPolygon(xWallPoints, yWallPoints, 4);
        g.setPaint(Color.decode("#636363")); // крыша первого этажа
        int[] xRoofPoints = {x, x + 150, x + 125, x - 25};
        int[] yRoofPoints = {y - 100, y - 100, y - 135, y - 135};
        g.fillPolygon(xRoofPoints, yRoofPoints, 4);
        g.setPaint(Color.decode("#4a4a4a")); // верхняя внешняя стена
        int[] xTopWallPoints = {x - 25, x + 35, x + 35, x - 25};
        int[] yTopWallPoints = {y - 135, y - 135, y - 190, y - 190};
        g.fillPolygon(xTopWallPoints, yTopWallPoints, 4);
        g.setPaint(Color.decode("#636363")); // крыша второго этажа
        int[] xTopRoofPoints = {x + 35, x - 25, x - 50, x + 10};
        int[] yTopRoofPoints = {y - 190, y - 190, y - 225, y - 225};
        g.fillPolygon(xTopRoofPoints, yTopRoofPoints, 4);
        g.setPaint(Color.decode("#373737")); // сторона в тени
        int[] xDarkSidePoints = {x,x,x-25,x-25,x-50,x-75,x-75,x-100,x-100};
        int[] yDarkSidePoints = {y,y-100,y-135,y-190,y-225,y-190,y-135,y-100,y};
        g.fillPolygon(xDarkSidePoints, yDarkSidePoints, 9);
    }
}
