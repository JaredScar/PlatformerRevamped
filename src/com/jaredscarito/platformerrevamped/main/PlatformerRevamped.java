package com.jaredscarito.platformerrevamped.main;

import com.jaredscarito.platformerrevamped.characters.GameCharacter;
import com.jaredscarito.platformerrevamped.characters.Meatboy;
import com.jaredscarito.platformerrevamped.draw.DrawableAdapter;
import com.jaredscarito.platformerrevamped.draw.GameBoard;
import com.jaredscarito.platformerrevamped.stages.Stage;
import com.jaredscarito.platformerrevamped.stages.StartingStage;
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
    public BufferedImage canvas;
    public void setCanvas(Color c) {
        for(int x=0; x<this.canvas.getWidth(); x++) {
            for(int y=0; y<this.canvas.getHeight(); y++) {
                this.canvas.setRGB(x, y, c.getRGB());
            }
        }
    }
    private GameTimer gt;
    public void start() {
        this.canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setCanvas(Color.CYAN);
        showGameBoard(gb);
        this.gt = new GameTimer();
        Timer timer = new Timer();
        timer.schedule(this.gt, 0, 1000); //Each second is ran
        this.gt.run();
        this.gb.setTimerInterval(1, 100);
        this.gb.startTimer(1);
    }

    private Stage currentStage;
    private Stage[] stageOrder = new Stage[3];
    private boolean gameStarted = false;
    private GameCharacter charact;
    //Draw method
    @Override
    public void draw(Graphics g) {
        //Background:
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.canvas, null, null);
        setCanvas(Color.CYAN);
        //Character
        if(!this.gameStarted) {
            //Set up order of stages:
            Stage startingStage = new StartingStage(this.canvas);
            this.stageOrder[0] = startingStage;
            //Set up private datas
            this.currentStage = this.stageOrder[0];
            this.charact = new Meatboy(this, this.canvas, 50, 432, 1000);
            this.charact.setGravitySpeed(20);
            this.charact.startGravity(this.currentStage);
            this.gameStarted = true;
        }
        //Check if character is in portal
        if(this.currentStage.collidedWithObj(this.charact.getX(), this.charact.getY())) {
            //Goes to next stage
        }
        g.drawString(this.gt.getTimeString(), 350, 50);
        this.currentStage.draw();
        this.charact.draw();
    }
    @Override
    public void timer1() {
        //Does nothing
    }

    @Override
    public void keyStruck(char c) {
        switch (c) {
            case 'W':
                this.charact.jump(this.currentStage);
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
