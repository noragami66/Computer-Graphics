package ru.vsu.cs.kodintsev.elements.middle;

import java.awt.*;

public class House {
    private int x;
    private int y;
    private int floors;
    private int windows;
    private int arcs;

    public int getArcs() {
        return arcs;
    }

    public void setArcs(int arcs) {
        this.arcs = arcs;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
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

    public House(int arcs, int floors, int windows, int x, int y) {
        this.arcs = arcs;
        this.floors = floors;
        this.windows = windows;
        this.x = x;
        this.y = y;
    }

    public static void drawHouse(Graphics2D g, int x, int y, int floors, int windows, int arcs) {
        int originalY = y;
        int width = 150;

        int minWidthForArcs = 15 + arcs * 50;
        int minWidthForWindows = (windows * 20) + (windows + 1) * 10;

        if (arcs > 0 && minWidthForArcs > width) {
            width = minWidthForArcs;
        }
        if (windows > 0 && minWidthForWindows > width) {
            width = minWidthForWindows;
        }

        for (int i = 0; i < floors; i++) {
            //стены этажа
            g.setPaint(Color.decode("#4a4a4a"));
            int[] xWallPoints = {x, x + width, x + width, x};
            int[] yWallPoints = {y, y, y - 50, y - 50};
            g.fillPolygon(xWallPoints, yWallPoints, 4);

            g.setPaint(Color.decode("#373737"));
            int[] xDarkWallPoints = {x - width /2, x, x, x - width /2};
            int[] yDarkWallPoints = {y, y, y - 50, y - 50};
            g.fillPolygon(xDarkWallPoints, yDarkWallPoints, 4);

            // 1 этаж, арки
            if (i == 0 && arcs > 0) {
                if (arcs == 1) {
                    g.setPaint(Color.decode("#434343"));
                    int middleArcX = x + (width / 2) - 10;
                    g.fillRoundRect(middleArcX, originalY - 30, 20, 35, 20, 20);
                    g.setPaint(Color.decode("#636363"));
                    int[] xArcPoints = {middleArcX, middleArcX + 20, middleArcX};
                    int[] yArcPoints = {originalY, originalY, originalY - 25};
                    g.fillPolygon(xArcPoints, yArcPoints, 3);
                } else {
                    int spaceBetweenArcs = (width - (arcs * 25)) / (arcs + 1);
                    int currentX = x + spaceBetweenArcs;

                    for (int j = 0; j < arcs; j++) {
                        g.setPaint(Color.decode("#434343"));
                        g.fillRoundRect(currentX, originalY - 30, 25, 35, 20, 20);
                        g.setPaint(Color.decode("#636363"));
                        int[] xArcPoints = {currentX, currentX + 25, currentX};
                        int[] yArcPoints = {originalY, originalY, originalY - 25};
                        g.fillPolygon(xArcPoints, yArcPoints, 3);

                        currentX += 25 + spaceBetweenArcs;
                    }
                }
                // окна на этажах
            } else if (i > 0 && windows > 0) {
                int spaceBetweenWindows = (width - (windows * 20)) / (windows + 1);
                int currentWindowX = x + spaceBetweenWindows;
                g.setPaint(Color.decode("#373737"));

                for (int j = 0; j < windows; j++) {
                    g.fillRect(currentWindowX, y - 40, 20, 30);
                    currentWindowX += 20 + spaceBetweenWindows;
                }
            }

            y -= 50;
        }

        g.setPaint(Color.decode("#4a4a4a"));
        int[] xRoofPoints = {x, x + width, x + (width / 2)};
        int[] yRoofPoints = {y, y, y - 50};
        g.fillPolygon(xRoofPoints, yRoofPoints, 3);
        g.setPaint(Color.decode("#434343"));
        int[] xDarkRoofPoints = {x - width/2, x, x + (width / 2), x};
        int[] yDarkRoofPoints = {y, y, y - 50, y - 50};
        g.fillPolygon(xDarkRoofPoints, yDarkRoofPoints, 4);
    }
}
