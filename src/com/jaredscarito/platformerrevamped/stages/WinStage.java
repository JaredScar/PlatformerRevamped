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
        drawBandageGirl();
        //Now we setup the platforms
        //Parkour skill stage
        RectShape rightPlatformStart = new RectShape(super.canvas, Color.GRAY, 0, 480, 500, 20);
        rightPlatformStart.draw();
        this.platforms.add(rightPlatformStart);

        //Left platform
        RectShape leftPlatform = new RectShape(super.canvas, Color.GRAY, 0, 300, 150, 20);
        leftPlatform.draw();
        this.platforms.add(leftPlatform);

        //Right platform
        RectShape rightPlatform = new RectShape(super.canvas, Color.GRAY, 300, 350, 200, 20);
        rightPlatform.draw();
        this.platforms.add(rightPlatform);

        //Left top platform
        RectShape leftTopPlatform = new RectShape(super.canvas, Color.GRAY, 0, 250, 150, 20);
        leftTopPlatform.draw();
        this.platforms.add(leftTopPlatform);

        //Right top platform with door possibly
        RectShape rightTopPlatWithDoor = new RectShape(super.canvas, Color.GRAY, 300, 170, 200, 20);
        rightTopPlatWithDoor.draw();
        this.platforms.add(rightTopPlatWithDoor);
    }
    public void drawBandageGirl() {
        int x = 200;
        int y = 80;
        new RectShape(this.canvas, Color.PINK, x, y, 8, 8).draw();
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
