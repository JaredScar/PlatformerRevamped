package com.jaredscarito.platformerrevamped.characters;

import com.jaredscarito.platformerrevamped.main.PlatformerRevamped;
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
    protected ArrayList<PointStorage> bodyPoints = new ArrayList<>();
    protected ArrayList<PointStorage> leftArm = new ArrayList<>();
    protected ArrayList<PointStorage> rightArm = new ArrayList<>();
    protected ArrayList<PointStorage> leftLeg = new ArrayList<>();
    protected ArrayList<PointStorage> rightLeg = new ArrayList<>();
    protected ArrayList<PointStorage> eyePoints = new ArrayList<>();
    protected ArrayList<PointStorage> mouthPoints = new ArrayList<>();
    protected int legsY = 0;
    protected int gravitySpeed = 0;
    protected BufferedImage canvas;
    protected Color[] cantCollide;
    public PlatformerRevamped pr;

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
    public void startGravity() {
        GravityTimer gravity = new GravityTimer(this);
        Timer task = new Timer();
        task.schedule(gravity, 0, this.gravitySpeed);
        gravity.run();
    }

    public boolean isJumped = false;
    //Character jump
    public void jump() {
        if(!isJumped) {
            //Jump, then have it get reset after jump is completed
            isJumped = true;
            JumpTimer jumpTask = new JumpTimer(this, this.pr.gb);
            Timer task = new Timer();
            task.schedule(jumpTask, 0, 80);
            jumpTask.run();
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
        ArrayList<PointStorage> allPoints = new ArrayList<>();
        //Body points
        for(PointStorage bp : bodyPoints) {
            allPoints.add(bp);
        }

        //Left arm
        for(PointStorage la : leftArm) {
            allPoints.add(la);
        }
        //Right arm
        for(PointStorage ra : rightArm) {
            allPoints.add(ra);
        }

        //Left leg
        for(PointStorage ll : leftLeg) {
            allPoints.add(ll);
        }
        //Right leg
        for(PointStorage rl : rightLeg) {
            allPoints.add(rl);
        }

        //Eye points
        for(PointStorage eyes : eyePoints) {
            allPoints.add(eyes);
        }

        //Mouth points
        for(PointStorage mouth : mouthPoints) {
            allPoints.add(mouth);
        }
        return allPoints;
    }

    //Set Ys and Xs
    public void addY(int y) {

        //Body points
        for(PointStorage bp : bodyPoints) {
            bp.setY((bp.getTransformedY() + y));
        }

        //Left arm
        for(PointStorage la : leftArm) {
            la.setY(la.getTransformedY() + y);
        }
        //Right arm
        for(PointStorage ra : rightArm) {
            ra.setY(ra.getTransformedY() + y);
        }

        //Left leg
        for(PointStorage ll : leftLeg) {
            ll.setY(ll.getTransformedY() + y);
        }
        //Right leg
        for(PointStorage rl : rightLeg) {
            rl.setY(rl.getTransformedY() + y);
        }
        this.legsY += y;

        //Eye points
        for(PointStorage eyes : eyePoints) {
            eyes.setY(eyes.getTransformedY() + y);
        }

        //Mouth points
        for(PointStorage mouth : mouthPoints) {
            mouth.setY(mouth.getTransformedY() + y);
        }
    }
    public void subtractY(int y) {

        //Body points
        for(PointStorage bp : bodyPoints) {
            bp.setY((bp.getTransformedY() - y));
        }

        //Left arm
        for(PointStorage la : leftArm) {
            la.setY(la.getTransformedY() - y);
        }
        //Right arm
        for(PointStorage ra : rightArm) {
            ra.setY(ra.getTransformedY() - y);
        }

        //Left leg
        for(PointStorage ll : leftLeg) {
            ll.setY(ll.getTransformedY() - y);
        }
        //Right leg
        for(PointStorage rl : rightLeg) {
            rl.setY(rl.getTransformedY() - y);
        }
        this.legsY -= y;

        //Eye points
        for(PointStorage eyes : eyePoints) {
            eyes.setY(eyes.getTransformedY() - y);
        }

        //Mouth points
        for(PointStorage mouth : mouthPoints) {
            mouth.setY(mouth.getTransformedY() - y);
        }
    }
    public void addX(int x) {

        //Body points
        for(PointStorage bp : bodyPoints) {
            bp.setX((bp.getTransformedX() + x));
        }

        //Left arm
        for(PointStorage la : leftArm) {
            la.setX(la.getTransformedX() + x);
        }
        //Right arm
        for(PointStorage ra : rightArm) {
            ra.setX(ra.getTransformedX() + x);
        }

        //Left leg
        for(PointStorage ll : leftLeg) {
            ll.setX(ll.getTransformedX() + x);
        }
        //Right leg
        for(PointStorage rl : rightLeg) {
            rl.setX(rl.getTransformedX() + x);
        }

        //Eye points
        for(PointStorage eyes : eyePoints) {
            eyes.setX(eyes.getTransformedX() + x);
        }

        //Mouth points
        for(PointStorage mouth : mouthPoints) {
            mouth.setX(mouth.getTransformedX() + x);
        }
    }
    public void subtractX(int x) {

        //Body points
        for(PointStorage bp : bodyPoints) {
            bp.setX((bp.getTransformedX() - x));
        }

        //Left arm
        for(PointStorage la : leftArm) {
            la.setX(la.getTransformedX() - x);
        }
        //Right arm
        for(PointStorage ra : rightArm) {
            ra.setX(ra.getTransformedX() - x);
        }

        //Left leg
        for(PointStorage ll : leftLeg) {
            ll.setX(ll.getTransformedX() - x);
        }
        //Right leg
        for(PointStorage rl : rightLeg) {
            rl.setX(rl.getTransformedX() - x);
        }

        //Eye points
        for(PointStorage eyes : eyePoints) {
            eyes.setX(eyes.getTransformedX() - x);
        }

        //Mouth points
        for(PointStorage mouth : mouthPoints) {
            mouth.setX(mouth.getTransformedX() - x);
        }
    }
}
