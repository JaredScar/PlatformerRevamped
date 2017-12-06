package com.jaredscarito.platformerrevamped.storage;

import java.awt.*;

/**
 * Created by user on 12/6/2017.
 */
public class PointStorage {
    private int originalX = 0;
    private int originalY = 0;
    private int lastX = -999;
    private int lastY = -999;
    private int transformedX = -999;
    private int transformedY = -999;
    private Color c;
    public PointStorage(int x, int y, Color c) {
        this.originalX = x;
        this.originalY = y;
        this.c = c;
    }
    // Replace the original set values
    public void setOriginalX(int x) {
        this.originalX = x;
    }
    public void setOriginalY(int y) {
        this.originalY = y;
    }

    // Change transformedX and transformedY, set their old values to lastX and lastY if they had any
    public void setX(int x) {
        this.lastX = this.transformedX;
        this.transformedX = x;
    }
    public void setY(int y) {
        this.lastY = this.transformedY;
        this.transformedY = y;
    }

    //Getters
    public Color getColor() {
        return this.c;
    }
    public int getOriginalX() {
        return this.originalX;
    }
    public int getOriginalY() {
        return this.originalY;
    }
    public int getLastX() {
        return this.lastX;
    }
    public int getLastY() {
        return this.lastY;
    }
    public int getTransformedX() {
        if(this.transformedX !=-999) {
            return this.transformedX;
        }
        return this.originalX;
    }
    public int getTransformedY() {
        if(this.transformedY !=-999) {
            return this.transformedY;
        }
        return this.originalY;
    }
}
