package com.jaredscarito.platformerrevamped.timers;

import com.jaredscarito.platformerrevamped.characters.GameCharacter;
import com.jaredscarito.platformerrevamped.draw.GameBoard;

import java.util.TimerTask;

/**
 * Created by user on 12/6/2017.
 */
public class JumpTimer extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    private GameCharacter gc;
    private GameBoard gb;
    private int addedY;
    public JumpTimer(GameCharacter gc, GameBoard gb) {
        this.gc = gc;
        this.addedY = 0;
        this.gb = gb;
    }
    @Override
    public void run() {
        this.gc.subtractY(5);
        //this.gc.draw();
        this.addedY += 5;
        //this.gb.appletPaint = false;
        //this.gb.repaint();
        if(this.addedY >= 138) {
            this.gc.isJumped = false;
            this.cancel();
        }
    }
}
