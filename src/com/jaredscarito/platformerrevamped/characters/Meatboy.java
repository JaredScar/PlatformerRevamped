package com.jaredscarito.platformerrevamped.characters;

import com.jaredscarito.platformerrevamped.storage.PointStorage;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 12/6/2017.
 */
public class Meatboy extends GameCharacter {
    public Meatboy(Graphics g, BufferedImage canvas, int startX, int startY, int gravitySpeed,  Color... cantCollide) {
        this.cantCollide = cantCollide;
        this.canvas = canvas;
        this.gravitySpeed = gravitySpeed;

        //Draw his feet
        g.setColor(Color.RED);
        g.drawRect(startX, startY, 8, 8);
        g.fillRect(startX, startY, 8, 8);
        int rightFootStart = startX + 16;
        g.drawRect(rightFootStart, startY, 8, 8);
        g.fillRect(rightFootStart, startY, 8, 8);
        this.legsY = startY + 8;
        //Add the points to array
        for(int y=startY; y<(startY + 8); y++) {
            //Left foot points
            for(int xLeft=startX; xLeft<(startX + 8); xLeft++) {
                this.leftLeg.add(new PointStorage(xLeft, y, Color.RED));
            }
            //Right foot points
            for(int xRight=rightFootStart; xRight<(rightFootStart + 8); xRight++) {
                this.rightLeg.add(new PointStorage(xRight, y, Color.RED));
            }
        }


        //Body
        int bodyStartX = startX;
        int bodyStartY = startY - 22;
        g.drawRect(bodyStartX, bodyStartY, 24, 24);
        g.fillRect(bodyStartX, bodyStartY, 24, 24);
        //Add the points to array
        for(int x=bodyStartX; x<(bodyStartX + 24); x++) {
            for(int y=bodyStartY; y<(bodyStartY + 24); y++) {
                this.bodyPoints.add(new PointStorage(x, y, Color.RED));
            }
        }


        //Eyes
        int eyesStartX = startX + 3;
        int eyesStartY = startY - 18;
        //Left
        g.setColor(Color.BLACK);
        g.drawRect(eyesStartX, eyesStartY, 5, 5);
        g.fillRect(eyesStartX, eyesStartY, 5, 5);
        //Right
        g.drawRect(eyesStartX + 13, eyesStartY, 5, 5);
        g.fillRect(eyesStartX + 13, eyesStartY, 5, 5);
        //Add the points
        for(int y=eyesStartY; y<(eyesStartY + 5); y++) {
            for(int xLeft = eyesStartX; xLeft<(eyesStartX + 5); xLeft++) {
                this.eyePoints.add(new PointStorage(xLeft, y, Color.BLACK));
            }
            for(int xRight = (eyesStartX + 13); xRight<(eyesStartX + 13 + 5); xRight++) {
                this.eyePoints.add(new PointStorage(xRight, y, Color.BLACK));
            }
        }


        //Arms
        int armsStartX = startX - 5;
        int armsStartY = startY - 13;
        g.setColor(Color.RED);
        //Left
        g.drawRect(armsStartX, armsStartY, 5, 8);
        g.fillRect(armsStartX, armsStartY, 5, 8);
        //Right
        g.drawRect(armsStartX + 28, armsStartY, 5, 8);
        g.fillRect(armsStartX + 28, armsStartY, 5, 8);
        //add the points
        //Left
        for(int xLeft=armsStartX; xLeft<(armsStartX + 5); xLeft++) {
            for(int yLeft=armsStartY; yLeft<(armsStartY + 8); yLeft++) {
                this.leftArm.add(new PointStorage(xLeft, yLeft, Color.RED));
            }
        }
        //Right
        for(int xRight=(armsStartX + 28); xRight<(armsStartX + 5 + 28); xRight++) {
            for(int yRight=armsStartY; yRight<(armsStartY + 8); yRight++) {
                this.rightArm.add(new PointStorage(xRight, yRight, Color.RED));
            }
        }


        //Mouth
        g.setColor(Color.BLACK);
        int topMouthStartX = startX + 8;
        int topMouthStartY = startY - 8;
        g.drawRect(topMouthStartX, topMouthStartY, 9, 2);
        g.setColor(Color.WHITE);
        g.fillRect(topMouthStartX, topMouthStartY, 9, 2);
        g.setColor(Color.BLACK);
        g.drawRect(topMouthStartX + 1, topMouthStartY + 3, 7, 2);
        g.setColor(Color.WHITE);
        g.fillRect(topMouthStartX + 1, topMouthStartY + 3, 7, 2);
        int bottomMouthX = topMouthStartX + 1;
        int bottomMouthY = topMouthStartY + 3;
        //Add to irrelevant array
        //Top
        for(int y=topMouthStartY; y<(topMouthStartY+2); y++) {
            for(int x=topMouthStartX; x<(topMouthStartX+9); x++) {
                if(canvas.getRGB(x, y) == Color.BLACK.getRGB()) {
                    this.mouthPoints.add(new PointStorage(x, y, Color.BLACK));
                } else {
                    this.mouthPoints.add(new PointStorage(x, y, Color.WHITE));
                }
            }
        }
        //Bottom
        for(int y=bottomMouthY; y<(bottomMouthY+2); y++) {
            for(int x=bottomMouthX; x<(bottomMouthX+9); x++) {
                if(canvas.getRGB(x, y) == Color.BLACK.getRGB()) {
                    this.mouthPoints.add(new PointStorage(x, y, Color.BLACK));
                } else {
                    this.mouthPoints.add(new PointStorage(x, y, Color.WHITE));
                }
            }
        }
        this.startGravity();
    }
}
