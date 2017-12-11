package com.jaredscarito.platformerrevamped.main;

import com.jaredscarito.platformerrevamped.characters.GameCharacter;
import com.jaredscarito.platformerrevamped.characters.Meatboy;
import com.jaredscarito.platformerrevamped.draw.DrawableAdapter;
import com.jaredscarito.platformerrevamped.draw.GameBoard;
import com.jaredscarito.platformerrevamped.stages.Stage;
import com.jaredscarito.platformerrevamped.stages.StartingStage;
import com.jaredscarito.platformerrevamped.stages.WinStage;
import com.jaredscarito.platformerrevamped.timers.GameTimer;
import com.sun.javafx.iio.ImageStorage;

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
    private int stageIndex = 0;
    private boolean gameStarted = false;
    private GameCharacter charact;
    private boolean gameOver = false;
    //Draw method
    @Override
    public void draw(Graphics g) {
        if(!gameOver) {
            //Background:
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(this.canvas, null, null);
            setCanvas(Color.CYAN);
            //Character
            if (!this.gameStarted) {
                //Set up order of stages:
                Stage startingStage = new StartingStage(this.canvas);
                startingStage.setup();
                this.stageOrder[0] = startingStage;
                Stage winStage = new WinStage(this.canvas);
                this.stageOrder[1] = winStage;
                //Set up private datas
                this.currentStage = this.stageOrder[0];
                this.charact = new Meatboy(this, this.canvas, 50, 432, 1000);
                this.charact.setGravitySpeed(20);
                this.charact.startGravity(this.currentStage);
                this.gameStarted = true;
            }
            //Check if character is in portal
            if (this.currentStage.collidedWithObj(this.charact.getX(), this.charact.getY())) {
                //Goes to next stage
                stageIndex++;
                if(stageIndex != (stageOrder.length - 1)) {
                    this.currentStage.clear();
                    this.currentStage = stageOrder[stageIndex];
                    this.currentStage.setup();
                    //Change character's coords
                    this.charact.setX(this.currentStage.startCharX);
                    this.charact.setY(this.currentStage.startCharY);
                } else {
                    //Game is over, display their score and end game
                    this.gameOver = true;
                    this.gt.cancel();
                }
            }
            g.drawString(this.gt.getTimeString(), 350, 50);
            this.currentStage.draw();
            this.charact.draw();
        } else {
            //The game is over, displaying their score
            this.gb.stopTimer(1);
            //this.gt.cancel();
        }
    }
    @Override
    public void timer1() {
        //Does nothing
    }

    @Override
    public void keyStruck(char c) {
        if(!gameOver) {
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
}
