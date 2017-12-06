package com.jaredscarito.platformerrevamped.main;

import com.jaredscarito.platformerrevamped.draw.DrawableAdapter;
import com.jaredscarito.platformerrevamped.draw.GameBoard;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 12/6/2017.
 */
public class PlatformerRevamped extends DrawableAdapter {
    public GameBoard gb = new GameBoard(this, "Jared's Platformer");
    public int height = 500;
    public int width = 500;
    private BufferedImage canvas;
    public void setCanvas(Color c) {
        for(int x=0; x<this.canvas.getWidth(); x++) {
            for(int y=0; y<this.canvas.getHeight(); y++) {
                this.canvas.setRGB(x, y, c.getRGB());
            }
        }
    }
    public void start() {
        this.canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        setCanvas(Color.CYAN);
        showGameBoard(gb);
    }

    //Draw method
    @Override
    public void draw(Graphics g) {
        //Background:
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.canvas, null, null);

        //Character
    }
}
