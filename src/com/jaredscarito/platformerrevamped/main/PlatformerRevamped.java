package com.jaredscarito.platformerrevamped.main;

import com.jaredscarito.platformerrevamped.characters.GameCharacter;
import com.jaredscarito.platformerrevamped.characters.Meatboy;
import com.jaredscarito.platformerrevamped.draw.DrawableAdapter;
import com.jaredscarito.platformerrevamped.draw.GameBoard;
import com.jaredscarito.platformerrevamped.stages.Stage;
import com.jaredscarito.platformerrevamped.timers.GameTimer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;

/**
 * Created by user on 12/6/2017.
 */
public class PlatformerRevamped extends DrawableAdapter {
    public GameBoard gb = new GameBoard(this, "Jared's Platformer");
    public int height = 500;
    public int width = 500;
    private BufferedImage canvas;
    public void setCanvas(Color c) {
        for(int x=0; x<this.canvas.getWidth(); x++) {
            for(int y=0; y<this.canvas.getHeight(); y++) {
                this.canvas.setRGB(x, y, c.getRGB());
            }
        }
    }
    public void start() {
        this.canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setCanvas(Color.CYAN);
        showGameBoard(gb);
        GameTimer gt = new GameTimer();
        Timer timer = new Timer();
        timer.schedule(gt, 0, 1000); //Each second is ran
        gt.run();
    }

    private Stage currentStage;
    private boolean gameStarted = false;
    private GameCharacter charact;
    //Draw method
    @Override
    public void draw(Graphics g) {
        //Background:
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.canvas, null, null);
        for(int x=0; x<this.canvas.getWidth(); x++) {
            for(int y=0; y<this.canvas.getHeight(); y++) {
                this.canvas.setRGB(x, y, Color.CYAN.getRGB());
            }
        }

        //Character
        if(!this.gameStarted) {
            this.charact = new Meatboy(g, this.canvas, 50, 480, 1000, Color.GRAY, Color.DARK_GRAY);
            this.gameStarted = true;
        }
        this.charact.draw();
    }

    @Override
    public void keyStruck(char c) {
        switch (c) {
            case 'W':
                this.charact.jump();
                break;
            case 'S':
                break;
            case 'D':
                this.charact.moveRight();
                break;
            case 'A':
                this.charact.moveLeft();
                break;
        }
    }
}
