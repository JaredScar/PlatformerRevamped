package com.jaredscarito.platformerrevamped.characters;

import com.jaredscarito.platformerrevamped.main.PlatformerRevamped;
import shapes.RectShape;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 12/6/2017.
 */
public class Meatboy extends GameCharacter {
    public Meatboy(PlatformerRevamped pr, BufferedImage canvas, int startX, int startY, int gravitySpeed) {
        this.canvas = canvas;
        this.gravitySpeed = gravitySpeed;
        this.pr = pr;
        this.x = startX;
        this.y = startY;
    }
    @Override
    public void draw() {
        //Draw his feet
        //Left food
        new RectShape(this.canvas, Color.RED, x, y, 8, 8).draw();
        int rightFootStart = x + 16;
        //Right foot
        new RectShape(this.canvas, Color.RED, rightFootStart, y, 8, 8).draw();
        this.legsY = y + 8;


        //Body
        int bodyStartX = x;
        int bodyStartY = y - 22;
        new RectShape(this.canvas, Color.RED, bodyStartX, bodyStartY, 24, 24).draw();


        //Eyes
        int eyesStartX = x + 3;
        int eyesStartY = y - 18;
        //Left
        new RectShape(this.canvas, Color.BLACK, eyesStartX, eyesStartY, 5, 5).draw();
        //Right
        int righteyeX = eyesStartX + 13;
        new RectShape(this.canvas, Color.BLACK, righteyeX, eyesStartY, 5, 5).draw();


        //Arms
        int armsStartX = x - 5;
        int armsStartY = y - 13;
        //Left
        new RectShape(this.canvas, Color.RED, armsStartX, armsStartY, 5, 8).draw();
        //Right
        int rightArmStartX = armsStartX + 28;
        new RectShape(this.canvas, Color.RED, rightArmStartX, armsStartY, 5, 8).draw();


        //Mouth
        int topMouthStartX = x + 8;
        int topMouthStartY = y - 8;
        new RectShape(this.canvas, Color.WHITE, topMouthStartX, topMouthStartY, 9, 2).draw();
        int bottomMouthX = topMouthStartX + 1;
        int bottomMouthY = topMouthStartY + 3;
        new RectShape(this.canvas, Color.WHITE, bottomMouthX, bottomMouthY, 7, 2).draw();
    }
    @Override
    public void addY(int y) {
        this.y += y;
    }
    @Override
    public void subtractY(int y) {
        this.y -= y;
    }
    @Override
    public void addX(int x) {
        this.x += x;
    }
    @Override
    public void subtractX(int x) {
        this.x -= x;
    }
}
