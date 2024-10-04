package ru.vsu.cs.kodintsev;

import ru.vsu.cs.kodintsev.elements.background.Star;
import ru.vsu.cs.kodintsev.elements.background.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.vsu.cs.kodintsev.elements.background.Background.drawBackground;
import static ru.vsu.cs.kodintsev.elements.background.Moon.drawMoon;
import static ru.vsu.cs.kodintsev.elements.background.Star.drawStars;
import static ru.vsu.cs.kodintsev.elements.background.Tree.drawTrees;
import static ru.vsu.cs.kodintsev.elements.foreground.Bush.drawBush;
import static ru.vsu.cs.kodintsev.elements.middle.Church.drawChurch;
import static ru.vsu.cs.kodintsev.elements.middle.House.drawHouse;

public class DrawPanel extends JPanel {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 600;
    private final static Random rnd = new Random();
    private List<Star> stars = new ArrayList<>();
    private List<Tree> trees = new ArrayList<>();
    private Timer timer;


    public DrawPanel() {
        for (int i = 0; i < 20; i++) {
            stars.add(new Star(
                    Color.decode("#6c6c69"),
                    rnd.nextInt(BACKGROUND_WIDTH),
                    rnd.nextInt(BACKGROUND_HEIGHT / 2)
            ));
        }
        for (int i = 0; i < 6; i++) {
            trees.add(new Tree(
                    Color.decode("#343328"),
                    200 + rnd.nextInt(100),
                    100 + (i * 100),
                    (int)(BACKGROUND_HEIGHT / 1.65)
            ));
        }
        timer = new Timer(500, e -> {
            twinkleStars();
            repaint();
        });
        timer.start();
    }

    private void twinkleStars() {
        for (Star star : stars) {
            star.twinkle();
        }
    }   



    public void paint(Graphics g) {
        super.paint(g);
        drawBackground((Graphics2D)g,BACKGROUND_WIDTH,BACKGROUND_HEIGHT,Color.decode("#2c2c28"),Color.decode("#454435"));
        drawStars((Graphics2D) g, stars);
        drawMoon((Graphics2D)g,600,50,75,Color.decode("#aaaa9f"));
        drawTrees((Graphics2D) g, trees);
        drawChurch((Graphics2D) g, 520,(int)(BACKGROUND_HEIGHT / 1.65));
        drawHouse((Graphics2D) g, 175,(int)(BACKGROUND_HEIGHT / 1.65), 3, 2, 1);
        drawHouse((Graphics2D) g, 300,(int)(BACKGROUND_HEIGHT / 1.65), 1, 0, 3);
        drawBush((Graphics2D) g, 200, 400,150);
    }
}
