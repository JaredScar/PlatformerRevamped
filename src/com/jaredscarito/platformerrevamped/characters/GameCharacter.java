package com.jaredscarito.platformerrevamped.characters;

import com.jaredscarito.platformerrevamped.main.PlatformerRevamped;
import com.jaredscarito.platformerrevamped.stages.Stage;
import com.jaredscarito.platformerrevamped.storage.PointStorage;
import com.jaredscarito.platformerrevamped.timers.GravityTimer;
import com.jaredscarito.platformerrevamped.timers.JumpTimer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by user on 12/6/2017.
 */
public abstract class GameCharacter {
    /**/ //Probably taking this out, we will rely on our shapes instead
    protected ArrayList<PointStorage> bodyPoints = new ArrayList<>();
    protected ArrayList<PointStorage> leftArm = new ArrayList<>();
    protected ArrayList<PointStorage> rightArm = new ArrayList<>();
    protected ArrayList<PointStorage> leftLeg = new ArrayList<>();
    protected ArrayList<PointStorage> rightLeg = new ArrayList<>();
    protected ArrayList<PointStorage> eyePoints = new ArrayList<>();
    protected ArrayList<PointStorage> mouthPoints = new ArrayList<>();
    /**/
    protected int legsY = 0;
    protected int gravitySpeed = 0;
    protected BufferedImage canvas;
    protected Color[] cantCollide;
    public PlatformerRevamped pr;
    protected int x;
    protected int y;
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX() {
        this.x = x;
    }
    public void setY() {
        this.y = y;
    }

    //Draw the character
    public void draw() {
        for(PointStorage points : this.getAllPoints()) {
            this.canvas.setRGB(points.getTransformedX(), points.getTransformedY(), points.getColor().getRGB());
        }
        //this.pr.gb.appletPaint = false;
        //this.pr.gb.repaint();
    }


    public void setGravitySpeed(int speed) {
        this.gravitySpeed = speed;
    }
    //Get last layer of legs' Y
    public int getLegsY() {
        return legsY;
    }

    //Start gravity of character
    protected GravityTimer gravity;
    public void startGravity(Stage stage) {
        this.gravity = new GravityTimer(this, stage);
        Timer task = new Timer();
        task.schedule(this.gravity, 0, this.gravitySpeed);
        this.gravity.run();
    }
    public void stopGravity() {
        this.gravity.stop();
    }

    public boolean isJumped = false;
    //Character jump
    public void jump(Stage stage) {
        if(!isJumped) {
            //Jump, then have it get reset after jump is completed
            if(stage.willCollideWithPlatform(this.x, (this.legsY))) {
                isJumped = true;
                JumpTimer jumpTask = new JumpTimer(this, this.pr.gb);
                Timer task = new Timer();
                task.schedule(jumpTask, 0, 20);
                jumpTask.run();
            }
        }
    }
    //Move right
    public void moveRight() {
        this.addX(10);
    }
    //Move left
    public void moveLeft() {
        this.subtractX(10);
    }

    //Get all points
    public ArrayList<PointStorage> getAllPoints() {
        //TODO REDO
        return null;
    }

    //Set Ys and Xs
    public void addY(int y) {
        //TODO REDO
    }
    public void subtractY(int y) {
        //TODO REDO
    }
    public void addX(int x) {
        //TODO REDO
    }
    public void subtractX(int x) {
        //TODO REDO
    }
}
