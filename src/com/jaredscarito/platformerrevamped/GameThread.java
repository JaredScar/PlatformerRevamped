package com.jaredscarito.platformerrevamped;

import com.jaredscarito.platformerrevamped.main.PlatformerRevamped;

/**
 * Created by user on 12/6/2017.
 */
public class GameThread {
    private static PlatformerRevamped platformer;
    public static void main(String[] args) {
        platformer = new PlatformerRevamped();
        platformer.start();
    }
}
