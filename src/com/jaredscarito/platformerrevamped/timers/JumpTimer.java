package com.jaredscarito.platformerrevamped.timers;

import com.jaredscarito.platformerrevamped.characters.GameCharacter;

import java.util.TimerTask;

/**
 * Created by user on 12/6/2017.
 */
public class JumpTimer extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    private GameCharacter gc;
    private int addedY;
    public JumpTimer(GameCharacter gc) {
        this.gc = gc;
        this.addedY = 0;
    }
    @Override
    public void run() {
        this.gc.subtractY(25);
        this.gc.draw();
        this.gc.pr.gb.appletPaint = false;
        this.gc.pr.gb.repaint();
        this.addedY += 25;
        if(this.addedY >= 100) {
            this.gc.isJumped = false;
            this.cancel();
        }
    }
}
