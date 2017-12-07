package com.jaredscarito.platformerrevamped.stages;

import java.awt.*;

/**
 * Created by user on 12/6/2017.
 */
public class StartingStage extends Stage {
    public StartingStage(Graphics g) {
        super(g);
    }
    public void draw() {
        //Parkour skill stage
        this.g.setColor(Color.GRAY);
        this.g.drawRect(0, 480, 500, 20);
        this.g.fillRect(0, 480, 500, 20);

        //Left platform
        this.g.drawRect(0, 400, 150, 20);
        this.g.fillRect(0, 400, 150, 20);

        //Right platform
        this.g.drawRect(300, 350, 200, 20);
        this.g.fillRect(300, 350, 200, 20);

        //Left top platform
        this.g.drawRect(0, 250, 150, 20);
        this.g.fillRect(0, 250, 150, 20);

        //Right top platform with door possibly
        this.g.drawRect(300, 170, 200, 20);
        this.g.fillRect(300, 170, 200, 20);
    }
}
