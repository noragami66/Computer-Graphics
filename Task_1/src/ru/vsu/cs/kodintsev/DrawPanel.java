package ru.vsu.cs.kodintsev;

import ru.vsu.cs.kodintsev.elements.background.Background;
import ru.vsu.cs.kodintsev.elements.background.Moon;
import ru.vsu.cs.kodintsev.elements.background.Star;
import ru.vsu.cs.kodintsev.elements.background.Tree;
import ru.vsu.cs.kodintsev.elements.foreground.Bush;
import ru.vsu.cs.kodintsev.elements.foreground.Sign;
import ru.vsu.cs.kodintsev.elements.middle.Church;
import ru.vsu.cs.kodintsev.elements.middle.House;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel {
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 600;
    private final static Random rnd = new Random();
    private List<Star> stars = new ArrayList<>();
    private List<Tree> trees = new ArrayList<>();
    private Timer timer;
    private List<House> houses = new ArrayList<>();
    private Church church;
    private Background background;
    private Moon moon;
    private Bush bush;
    private Sign sign;

    public DrawPanel() {
        background = new Background(BACKGROUND_WIDTH,BACKGROUND_HEIGHT,Color.decode("#2c2c28"),Color.decode("#454435"));
        church = new Church(520, (int)(BACKGROUND_HEIGHT / 1.65));
        sign = new Sign (600,400,200,100, "Городок");
        bush = new Bush(150,200,400);
        moon = new Moon(Color.decode("#aaaa9f"),75,600,50);
        houses.add(new House(1, 3, 2, 175, (int) (BACKGROUND_HEIGHT / 1.65)));
        houses.add(new House(3, 1, 5, 300, (int) (BACKGROUND_HEIGHT / 1.65)));

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
        background.draw((Graphics2D) g);
        for (Star star: stars) {
            star.draw((Graphics2D) g);
        }
        moon.draw((Graphics2D) g);
        for (Tree tree : trees) {
            tree.draw((Graphics2D) g);
        }
        church.draw((Graphics2D) g);
         for (House house : houses) {
            house.draw((Graphics2D) g);
        }
        bush.draw((Graphics2D) g);
         g.setColor(Color.red);
//         sign.draw((Graphics2D) g);
    }
}
