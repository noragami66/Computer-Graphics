package ru.vsu.cs.kodintsev.elements.middle;

import java.awt.*;

public class Church {
    private int x;
    private int y;

    public Church(int x, int y) {
        this.x = x;
        this.y = y;
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
        // Внешняя стена
        g.setPaint(Color.decode("#4a4a4a"));
        int[] xWallPoints = {x, x + 160, x + 160, x};
        int[] yWallPoints = {y, y, y - 100, y - 100};
        g.fillPolygon(xWallPoints, yWallPoints, 4);

        // Крыша первого этажа
        g.setPaint(Color.decode("#636363"));
        int[] xRoofPoints = {x, x + 160, x + 135, x - 25};
        int[] yRoofPoints = {y - 100, y - 100, y - 135, y - 135};
        g.fillPolygon(xRoofPoints, yRoofPoints, 4);

//        // Черепица на крыше первого этажа
//        g.setPaint(Color.decode("#4d4d4d"));
//        int roofWidth1 = 150;
//        int arcWidth1 = 20;
//        int arcHeight1 = 10;
//        int startX1 = x - 24;
//        int startY1 = y - 140;
//
//        for (int j = 0; j < 6; j++) {
//            for (int i = 0; i < roofWidth1; i += arcWidth1) {
//                g.drawArc(startX1 + i, startY1, arcWidth1, arcHeight1, 0, -180);
//            }
//            startX1 += 4;
//            startY1 += 6;
//        }

        // Верхняя внешняя стена
        g.setPaint(Color.decode("#4a4a4a"));
        int[] xTopWallPoints = {x - 25, x + 35, x + 35, x - 25};
        int[] yTopWallPoints = {y - 135, y - 135, y - 190, y - 190};
        g.fillPolygon(xTopWallPoints, yTopWallPoints, 4);

        // Крыша второго этажа
        g.setPaint(Color.decode("#636363"));
        int[] xTopRoofPoints = {x + 35, x - 25, x - 50, x + 10};
        int[] yTopRoofPoints = {y - 190, y - 190, y - 225, y - 225};
        g.fillPolygon(xTopRoofPoints, yTopRoofPoints, 4);

//        // Черепица на крыше второго этажа
//        g.setPaint(Color.decode("#4d4d4d"));
//        int roofWidth2 = 60;
//        int arcWidth2 = 20;
//        int arcHeight2 = 10;
//        int startX2 = x - 48;
//        int startY2 = y - 230;
//
//        for (int j = 0; j < 6; j++) {
//            for (int i = 0; i < roofWidth2; i += arcWidth2) {
//                g.drawArc(startX2 + i, startY2, arcWidth2, arcHeight2, 0, -180);
//            }
//            startX2 += 4;
//            startY2 += 6;
//        }

        // Сторона в тени
        g.setPaint(Color.decode("#373737"));
        int[] xDarkSidePoints = {x, x, x - 25, x - 25, x - 50, x - 75, x - 75, x - 100, x - 100};
        int[] yDarkSidePoints = {y, y - 100, y - 135, y - 190, y - 225, y - 190, y - 135, y - 100, y};
        g.fillPolygon(xDarkSidePoints, yDarkSidePoints, 9);
    }

}
