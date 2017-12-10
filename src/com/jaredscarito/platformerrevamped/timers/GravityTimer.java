package com.jaredscarito.platformerrevamped.timers;

import com.jaredscarito.platformerrevamped.characters.GameCharacter;

import java.awt.*;
import java.util.TimerTask;

/**
 * Created by user on 12/6/2017.
 */
public class GravityTimer extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    private GameCharacter gCharacter;
    public GravityTimer(GameCharacter character) {
        this.gCharacter = character;
    }
    @Override
    public void run() {
        int characterX = this.gCharacter.getAllPoints().get(0).getTransformedX();
        int legsY = this.gCharacter.getLegsY();
        if(this.gCharacter.pr.canvas.getRGB(characterX, (legsY + 3)) == Color.CYAN.getRGB()) {
            this.gCharacter.addY(1);
        }
    }
}
