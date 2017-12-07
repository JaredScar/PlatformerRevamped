package com.jaredscarito.platformerrevamped.stages;

import java.awt.*;

/**
 * Created by user on 12/6/2017.
 */
public abstract class Stage {
    protected Graphics g;
    public Stage(Graphics g) {
        this.g = g;
    }
    public void draw() {}
}
