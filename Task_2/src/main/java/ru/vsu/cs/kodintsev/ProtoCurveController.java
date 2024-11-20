package ru.vsu.cs.kodintsev;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class ProtoCurveController {
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    ArrayList<Point2D> points = new ArrayList<>();

    private final WuLineDrawer wuDrawer = new WuLineDrawer();

    @FXML
    private void initialize() {

        drawGrid(canvas.getGraphicsContext2D());
        drawCentralLines();

        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY -> handlePrimaryClick(canvas.getGraphicsContext2D(), event);
            }
        });

        canvas.setOnMouseMoved(event -> handleMouseMoved(canvas.getGraphicsContext2D(), event));
    }

    private void drawGrid(GraphicsContext gc) {
//        double gridSpacing = 20;
//
//        for (double x = 0; x <= canvas.getWidth(); x += gridSpacing) {
//            wuDrawer.drawWuLine(gc, (int) x, 0, (int) x, (int) canvas.getHeight(), Color.LIGHTGRAY, Color.LIGHTGRAY);
//        }
//
//        for (double y = 0; y <= canvas.getHeight(); y += gridSpacing) {
//            wuDrawer.drawWuLine(gc, 0, (int) y, (int) canvas.getWidth(), (int) y, Color.LIGHTGRAY, Color.LIGHTGRAY);
//        }
    }

    private void drawCentralLines() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        int centerX = 300;
        int centerY = (int) (canvas.getHeight() / 3);

        int linesCount = 100;
        double angleIncrement = 360.0 / linesCount;

        Color startColor = Color.RED;
        Color endColor = Color.BLUE;

        for (int i = 0; i < linesCount; i++) {
            double angle = Math.toRadians(i * angleIncrement);
            int endX = centerX + (int) (200 * Math.cos(angle));
            int endY = centerY + (int) (200 * Math.sin(angle));

            wuDrawer.drawWuLine(gc, endX, endY, centerX, centerY, startColor, endColor);
        }
    }

    private void handlePrimaryClick(GraphicsContext graphicsContext, MouseEvent event) {
        final Point2D clickPoint = new Point2D(event.getX(), event.getY());

        if (points.size() > 0) {
            final Point2D lastPoint = points.get(points.size() - 1);

            wuDrawer.drawWuLine(graphicsContext, (int) lastPoint.getX(), (int) lastPoint.getY(), (int) clickPoint.getX(), (int) clickPoint.getY(), Color.RED, Color.BLUE);
        }
        points.add(clickPoint);
    }

    private void handleMouseMoved(GraphicsContext gc, MouseEvent event) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        drawGrid(gc);
        drawCentralLines();

        int centerX = (int) (canvas.getWidth() / 2);
        int centerY = (int) (canvas.getHeight() / 2);
        Point2D mousePoint = new Point2D(event.getX(), event.getY());

        wuDrawer.drawWuLine(gc, centerX, centerY, (int) mousePoint.getX(), (int) mousePoint.getY(), Color.RED, Color.BLUE);
    }
}
