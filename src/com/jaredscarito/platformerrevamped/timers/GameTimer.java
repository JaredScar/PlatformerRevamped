package com.jaredscarito.platformerrevamped.timers;

import java.util.TimerTask;

/**
 * Created by user on 12/6/2017.
 */
public class GameTimer extends TimerTask {
    private String time = "";
    private int secs = 0;
    private int mins = 0;
    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        secs++;
        if(secs == 60) {
            secs = 0;
            mins++;
        }
        if(mins > 0) {
            if(secs <= 9) {
                time = "ELAPSED: " + mins + ":0" + secs;
            } else {
                time = "ELAPSED: " + mins + ":" + secs;
            }
        } else {
            time = "ELAPSED: " + secs;
        }
    }
    public String getTimeString() {
        return this.time;
    }
}
