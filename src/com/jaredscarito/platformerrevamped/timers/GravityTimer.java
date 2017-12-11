package com.jaredscarito.platformerrevamped.timers;

import com.jaredscarito.platformerrevamped.characters.GameCharacter;
import com.jaredscarito.platformerrevamped.stages.Stage;

import java.util.TimerTask;

/**
 * Created by user on 12/6/2017.
 */
public class GravityTimer extends TimerTask {
    /**
     * The action to be performed by this timer task.
     */
    private GameCharacter gCharacter;
    private Stage stage;
    public GravityTimer(GameCharacter character, Stage stage) {
        this.gCharacter = character;
        this.stage = stage;
    }
    @Override
    public void run() {
        int characterX = this.gCharacter.getX();
        int legsY = this.gCharacter.getLegsY();
        if(!this.stage.willCollideWithPlatform(characterX, (legsY))) {
            this.gCharacter.addY(1);
        }
    }
    public void stop() {
        this.cancel();
    }
}
