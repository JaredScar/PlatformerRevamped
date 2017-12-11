package com.jaredscarito.platformerrevamped.stages;

import shapes.RectShape;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 12/6/2017.
 */
public class WinStage extends Stage {
    public WinStage(BufferedImage canvas) {
        super(canvas);
        this.startCharX = 450;
        this.startCharY = 470;
    }
    @Override
    public void setup() {
        drawBandageGirl();
        //Now we setup the platforms
        //Parkour skill stage
        //Ground
        RectShape ground = new RectShape(super.canvas, Color.GRAY, 0, 480, 500, 20);
        this.platforms.add(ground);
        RectShape bottomRightPlat = new RectShape(super.canvas, Color.GRAY, 470, 470, 30, 20);
        this.platforms.add(bottomRightPlat);
    }
    public void drawBandageGirl() {
        int x = 450;
        int y = 80;
        this.stageObjs.add(new RectShape(this.canvas, Color.PINK, x, y, 8, 8));
        int rightFootStart = x + 16;
        //Right foot
        this.stageObjs.add(new RectShape(this.canvas, Color.PINK, rightFootStart, y, 8, 8));


        //Body
        int bodyStartX = x;
        int bodyStartY = y - 22;
        this.stageObjs.add(new RectShape(this.canvas, Color.PINK, bodyStartX, bodyStartY, 24, 24));


        //Eyes
        int eyesStartX = x + 3;
        int eyesStartY = y - 18;
        //Left
        this.stageObjs.add(new RectShape(this.canvas, Color.WHITE, eyesStartX, eyesStartY, 5, 5));
        //Right
        int righteyeX = eyesStartX + 13;
        this.stageObjs.add(new RectShape(this.canvas, Color.WHITE, righteyeX, eyesStartY, 5, 5));


        //Arms
        int armsStartX = x - 5;
        int armsStartY = y - 13;
        //Left
        this.stageObjs.add(new RectShape(this.canvas, Color.PINK, armsStartX, armsStartY, 5, 8));
        //Right
        int rightArmStartX = armsStartX + 28;
        this.stageObjs.add(new RectShape(this.canvas, Color.PINK, rightArmStartX, armsStartY, 5, 8));


        //Mouth
        int topMouthStartX = x + 8;
        int topMouthStartY = y - 8;
        this.stageObjs.add(new RectShape(this.canvas, Color.WHITE, topMouthStartX, topMouthStartY, 9, 2));
        int bottomMouthX = topMouthStartX + 1;
        int bottomMouthY = topMouthStartY + 3;
        this.stageObjs.add(new RectShape(this.canvas, Color.WHITE, bottomMouthX, bottomMouthY, 7, 2));
    }
}
