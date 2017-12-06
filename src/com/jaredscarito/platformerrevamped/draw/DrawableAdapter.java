package com.jaredscarito.platformerrevamped.draw;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;

public class DrawableAdapter implements Drawable {
    public DrawableAdapter() {}

    public static void showGameBoard(GameBoard gb) {
        gb.setVisible(true);

        try {
            Thread.sleep(10L);
            gb.repaint(true);
        } catch (InterruptedException var2) {
            ;
        }

    }

    public void draw(Graphics g) {
    }

    public void timer1() {
    }

    public void timer2() {
    }

    public void timer3() {
    }

    public void leftButton() {
    }

    public void rightButton() {
    }

    public void upButton() {
    }

    public void downButton() {
    }

    public void keyStruck(char key) {
    }

    public void mouseClicked(int x, int y, int buttonClicked) {
    }

    public void mouseDragged(int x, int y) {
    }
}