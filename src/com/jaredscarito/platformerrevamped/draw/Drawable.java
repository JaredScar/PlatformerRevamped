package com.jaredscarito.platformerrevamped.draw;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;

public interface Drawable {
    void draw(Graphics var1);

    void timer1();

    void timer2();

    void timer3();

    void leftButton();

    void rightButton();

    void upButton();

    void downButton();

    void mouseDragged(int var1, int var2);

    void mouseClicked(int var1, int var2, int var3);

    void keyStruck(char var1);
}