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
        //Parkour skill stage
        RectShape rightPlatformStart = new RectShape(super.canvas, Color.GRAY, 0, 480, 500, 20);
        rightPlatformStart.draw();
        this.platforms.add(rightPlatformStart);

        //Left platform
        RectShape leftPlatform = new RectShape(super.canvas, Color.GRAY, 0, 400, 150, 20);
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

        //Portal
        RectShape portal = new RectShape(super.canvas, new Color(153, 50, 204), 360, 90, 50, 50);
        portal.draw();
        this.stageObjs.add(portal);
    }
}
