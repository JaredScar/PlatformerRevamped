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
    private Color[] cantCollide;
    public GravityTimer(GameCharacter character, Color... cantCollide) {
        this.gCharacter = character;
        this.cantCollide = cantCollide;
    }
    @Override
    public void run() {
        //
    }
}
