package com.jaredscarito.platformerrevamped.stages;

import shapes.RectShape;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 12/6/2017.
 */
public class StartingStage extends Stage {
    public StartingStage(BufferedImage canvas) {
        super(canvas);
    }
    @Override
    public void draw() {
        //Parkour skill stage
        RectShape rightPlatformStart = new RectShape(super.canvas, Color.GRAY, 0, 480, 500, 20);
        rightPlatformStart.draw();

        //Left platform
        RectShape leftPlatform = new RectShape(super.canvas, Color.GRAY, 0, 400, 150, 20);
        leftPlatform.draw();

        //Right platform
        RectShape rightPlatform = new RectShape(super.canvas, Color.GRAY, 300, 350, 200, 20);
        rightPlatform.draw();

        //Left top platform
        RectShape leftTopPlatform = new RectShape(super.canvas, Color.GRAY, 0, 250, 150, 20);
        leftTopPlatform.draw();

        //Right top platform with door possibly
        RectShape rightTopPlatWithDoor = new RectShape(super.canvas, Color.GRAY, 300, 170, 200, 20);
        rightTopPlatWithDoor.draw();
    }
}
