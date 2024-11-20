package ru.vsu.cs.kodintsev;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class WuLineDrawer {

    public void drawWuLine(GraphicsContext gc, int x1, int y1, int x2, int y2, Color color1, Color color2) {
        boolean steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);

        if (steep) {
            int temp = x1; x1 = y1; y1 = temp;
            temp = x2; x2 = y2; y2 = temp;
        }

        if (x1 > x2) {
            int temp = x1; x1 = x2; x2 = temp;
            temp = y1; y1 = y2; y2 = temp;
            Color tempColor = color1; color1 = color2; color2 = tempColor;
        }

        int dx = x2 - x1;
        int dy = y2 - y1;
        float gradient = dx == 0 ? 1 : (float) dy / dx;

        float xEnd = round(x1);
        float yEnd = y1 + gradient * (xEnd - x1);
        float xGap = rfpart(x1 + 0.5f);
        int xPixel1 = (int) xEnd;
        int yPixel1 = (int) Math.floor(yEnd);
        plot(gc, steep, xPixel1, yPixel1, color1, rfpart(yEnd) * xGap);
        plot(gc, steep, xPixel1, yPixel1 + 1, color1, fpart(yEnd) * xGap);

        float intery = yEnd + gradient;

        xEnd = round(x2);
        yEnd = y2 + gradient * (xEnd - x2);
        xGap = fpart(x2 + 0.5f);
        int xPixel2 = (int) xEnd;
        int yPixel2 = (int) Math.floor(yEnd);
        plot(gc, steep, xPixel2, yPixel2, color2, rfpart(yEnd) * xGap);
        plot(gc, steep, xPixel2, yPixel2 + 1, color2, fpart(yEnd) * xGap);

        for (int x = xPixel1 + 1; x < xPixel2; x++) {
            float t = (float) (x - xPixel1) / (xPixel2 - xPixel1);
            Color interpolatedColor = interpolateColor(color1, color2, t);
            plot(gc, steep, x, (int) Math.floor(intery), interpolatedColor, rfpart(intery));
            plot(gc, steep, x, (int) Math.floor(intery) + 1, interpolatedColor, fpart(intery));
            intery += gradient;
        }
    }

    private void plot(GraphicsContext gc, boolean steep, int x, int y, Color color, float brightness) {
        Color blendedColor = color.deriveColor(0, 1, 1, brightness);
        if (steep) {
            gc.getPixelWriter().setColor(y, x, blendedColor);
        } else {
            gc.getPixelWriter().setColor(x, y, blendedColor);
        }
    }

    private Color interpolateColor(Color color1, Color color2, float t) {
        double r = clamp((1 - t) * color1.getRed() + t * color2.getRed(), 0.0, 1.0);
        double g = clamp((1 - t) * color1.getGreen() + t * color2.getGreen(), 0.0, 1.0);
        double b = clamp((1 - t) * color1.getBlue() + t * color2.getBlue(), 0.0, 1.0);
        double a = clamp((1 - t) * color1.getOpacity() + t * color2.getOpacity(), 0.0, 1.0);
        return new Color(r, g, b, a);
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    private float fpart(float x) {
        return x - (float) Math.floor(x);
    }

    private float rfpart(float x) {
        return 1 - fpart(x);
    }

    private float round(float x) {
        return (float) Math.round(x);
    }
}
