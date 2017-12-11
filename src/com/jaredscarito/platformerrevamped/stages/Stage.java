package com.jaredscarito.platformerrevamped.stages;

import com.jaredscarito.platformerrevamped.storage.PointStorage;
import shapes.RectShape;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by user on 12/6/2017.
 */
public abstract class Stage {
    protected BufferedImage canvas;
    protected ArrayList<RectShape> platforms = new ArrayList<>();
    protected ArrayList<RectShape> stageObjs = new ArrayList<>();
    public int startCharX = 0;
    public int startCharY = 0;
    public Stage(BufferedImage canvas) {
        this.canvas = canvas;
    }
    public void clear() {
        this.platforms.clear();
        this.stageObjs.clear();
    }
    public void setup() {}
    public boolean willCollideWithPlatform(int x, int y) {
        for(RectShape rect : this.platforms) {
            for(PointStorage points : rect.getPoints()) {
                if(points.getTransformedX() == x && points.getTransformedY() == y) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean collidedWithObj(int x, int y) {
        for(RectShape obj : this.stageObjs) {
            for(PointStorage points : obj.getPoints()) {
                if(points.getTransformedX() == x && points.getTransformedY() == y) {
                    return true;
                }
            }
        }
        return false;
    }
    public void draw() {
        for(RectShape platform : this.platforms) {
            platform.draw();
        }
        //Need to draw stageObjs too:
        for(RectShape obj : this.stageObjs) {
            obj.draw();
        }
    }
}
