package com.jaredscarito.platformerrevamped.stages;

import java.awt.image.BufferedImage;

/**
 * Created by user on 12/6/2017.
 */
public abstract class Stage {
    protected BufferedImage canvas;
    public Stage(BufferedImage canvas) {
        this.canvas = canvas;
    }
    public void draw() {}
}
