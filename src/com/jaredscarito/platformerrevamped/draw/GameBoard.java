package com.jaredscarito.platformerrevamped.draw;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameBoard extends JFrame implements MouseMotionListener, MouseListener, Drawable {
    boolean timer1On = true;
    int timer1Interval = 1000;
    boolean timer2On = true;
    int timer2Interval = 500;
    boolean timer3On = true;
    int timer3Interval = 250;
    Color backgroundColor;
    static String windowTitle;
    static boolean gameStarted = false;
    Drawable gamePanel;
    int boardWidth;
    int boardHeight;
    public boolean appletPaint;
    StartHandler startHandler;
    StopHandler stopHandler;
    LeftHandler leftHandler;
    RightHandler rightHandler;
    UpHandler upHandler;
    DownHandler downHandler;
    Timer1Handler timer1Handler;
    Timer2Handler timer2Handler;
    Timer3Handler timer3Handler;
    KeyHandler keyBoard;
    Timer t1;
    Timer t2;
    Timer t3;
    boolean isStandalone;
    BorderLayout borderLayout1;
    JButton startButton;
    JButton stopButton;
    JButton leftButton;
    JButton upButton;
    JButton rightButton;
    JButton downButton;
    Image mImage;
    Image initImage;
    public void repaint(boolean paint) {
        if(paint) {
            this.repaint();
        }

    }

    public void draw(Graphics g) {
        this.gamePanel.draw(g);
    }

    public void mouseMoved(MouseEvent me) {
        this.appletPaint = false;
        this.repaint();
    }

    public void mouseDragged(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        this.gamePanel.mouseDragged(x, y);
        this.appletPaint = false;
        this.repaint();
    }

    public void mouseClicked(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        int buttonPressed = me.getButton();
        this.gamePanel.mouseClicked(x, y, buttonPressed);
        this.appletPaint = false;
        this.repaint();
    }

    public void mousePressed(MouseEvent me) {
        this.appletPaint = false;
        this.repaint();
    }

    public void setTimerInterval(int timerNumber, int interval) {
        if(timerNumber == 1) {
            this.timer1Interval = interval;
            this.t1.stop();
            this.t1 = new Timer(this.timer1Interval, this.timer1Handler);
            if(gameStarted && this.timer1On) {
                this.t1.start();
            }
        } else if(timerNumber == 2) {
            this.timer2Interval = interval;
            this.t2.stop();
            this.t2 = new Timer(this.timer2Interval, this.timer2Handler);
            if(gameStarted && this.timer2On) {
                this.t2.start();
            }
        } else if(timerNumber == 3) {
            this.timer3Interval = interval;
            this.t3.stop();
            this.t3 = new Timer(this.timer3Interval, this.timer3Handler);
            if(gameStarted && this.timer3On) {
                this.t3.start();
            }
        }

    }

    public void startTimer(int timerNumber) {
        if(timerNumber == 1) {
            this.timer1On = true;
            this.t1.start();
        } else if(timerNumber == 2) {
            this.timer2On = true;
            this.t2.start();
        } else if(timerNumber == 3) {
            this.timer3On = true;
            this.t3.start();
        }

    }

    public void stopTimer(int timerNumber) {
        if(timerNumber == 1) {
            this.t1.stop();
            this.timer1On = false;
        } else if(timerNumber == 2) {
            this.t2.stop();
            this.timer2On = false;
        } else if(timerNumber == 3) {
            this.t3.stop();
            this.timer3On = false;
        }

    }

    public GameBoard(Object ge, String windowTitle, int boardWidthLocal, int boardHeightLocal) {
        super(windowTitle);
        this.backgroundColor = Color.pink;
        this.appletPaint = false;
        this.startHandler = new StartHandler();
        this.stopHandler = new StopHandler();
        this.leftHandler = new LeftHandler();
        this.rightHandler = new RightHandler();
        this.upHandler = new UpHandler();
        this.downHandler = new DownHandler();
        this.timer1Handler = new Timer1Handler();
        this.timer2Handler = new Timer2Handler();
        this.timer3Handler = new Timer3Handler();
        this.keyBoard = new KeyHandler();
        this.t1 = new Timer(this.timer1Interval, this.timer1Handler);
        this.t2 = new Timer(this.timer2Interval, this.timer2Handler);
        this.t3 = new Timer(this.timer3Interval, this.timer3Handler);
        this.isStandalone = false;
        this.borderLayout1 = new BorderLayout();
        this.startButton = new JButton();
        this.stopButton = new JButton();
        this.leftButton = new JButton();
        this.upButton = new JButton();
        this.rightButton = new JButton();
        this.downButton = new JButton();
        this.gamePanel = (Drawable)ge;
        this.boardWidth = boardWidthLocal;
        this.boardHeight = boardHeightLocal;
        this.setBackground(this.backgroundColor);
        this.setLayout((LayoutManager)null);
        this.setDefaultCloseOperation(3);
        this.setSize(this.boardWidth + 122, this.boardHeight + 5);
        this.setLocation(100, 100);
        int upButtonY = (int)((double)this.boardHeight / 2.0D);
        this.upButton.setBounds(new Rectangle(this.boardWidth + 39, upButtonY, 44, 22));
        this.upButton.setFont(new Font("Tahoma", 0, 8));
        this.upButton.setText("/\\");
        this.upButton.addActionListener(this.upHandler);
        this.startButton.setBounds(new Rectangle(this.boardWidth + 28, upButtonY - 46, 70, 22));
        this.startButton.setText("Start");
        this.startButton.addActionListener(this.startHandler);
        this.stopButton.setBounds(new Rectangle(this.boardWidth + 28, upButtonY - 24, 70, 22));
        this.stopButton.setText("Stop");
        this.stopButton.addActionListener(this.stopHandler);
        this.leftButton.setBounds(new Rectangle(this.boardWidth + 8, upButtonY + 22, 51, 22));
        this.leftButton.setHorizontalAlignment(10);
        this.leftButton.setText("<-");
        this.leftButton.addActionListener(this.leftHandler);
        this.rightButton.setBounds(new Rectangle(this.boardWidth + 59, upButtonY + 22, 51, 22));
        this.rightButton.setHorizontalAlignment(0);
        this.rightButton.setText("->");
        this.rightButton.addActionListener(this.rightHandler);
        this.downButton.setBounds(new Rectangle(this.boardWidth + 37, upButtonY + 44, 51, 22));
        this.downButton.setFont(new Font("Tahoma", 0, 8));
        this.downButton.setText("\\/");
        this.downButton.addActionListener(this.downHandler);
        this.add(this.rightButton);
        this.add(this.leftButton);
        this.add(this.upButton);
        this.add(this.downButton);
        this.add(this.startButton);
        this.add(this.stopButton);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this.keyBoard);
        this.rightButton.setFocusable(false);
        this.leftButton.setFocusable(false);
        this.upButton.setFocusable(false);
        this.downButton.setFocusable(false);
        this.startButton.setFocusable(false);
        this.stopButton.setFocusable(false);
    }

    public GameBoard(Object ge, String windowTitle) {
        super(windowTitle);
        this.backgroundColor = Color.pink;
        this.appletPaint = false;
        this.startHandler = new StartHandler();
        this.stopHandler = new StopHandler();
        this.leftHandler = new LeftHandler();
        this.rightHandler = new RightHandler();
        this.upHandler = new UpHandler();
        this.downHandler = new DownHandler();
        this.timer1Handler = new Timer1Handler();
        this.timer2Handler = new Timer2Handler();
        this.timer3Handler = new Timer3Handler();
        this.keyBoard = new KeyHandler();
        this.t1 = new Timer(this.timer1Interval, this.timer1Handler);
        this.t2 = new Timer(this.timer2Interval, this.timer2Handler);
        this.t3 = new Timer(this.timer3Interval, this.timer3Handler);
        this.isStandalone = false;
        this.borderLayout1 = new BorderLayout();
        this.startButton = new JButton();
        this.stopButton = new JButton();
        this.leftButton = new JButton();
        this.upButton = new JButton();
        this.rightButton = new JButton();
        this.downButton = new JButton();
        this.gamePanel = (Drawable)ge;
        this.boardWidth = 500;
        this.boardHeight = 500;
        this.setBackground(this.backgroundColor);
        this.setLayout((LayoutManager)null);
        this.setDefaultCloseOperation(3);
        this.setSize(this.boardWidth + 122, this.boardHeight + 5);
        this.setLocation(100, 100);
        int upButtonY = (int)((double)this.boardHeight / 2.0D);
        this.upButton.setBounds(new Rectangle(this.boardWidth + 39, upButtonY, 44, 22));
        this.upButton.setFont(new Font("Tahoma", 0, 8));
        this.upButton.setText("/\\");
        this.upButton.addActionListener(this.upHandler);
        this.startButton.setBounds(new Rectangle(this.boardWidth + 28, upButtonY - 46, 70, 22));
        this.startButton.setText("Start");
        this.startButton.addActionListener(this.startHandler);
        this.stopButton.setBounds(new Rectangle(this.boardWidth + 28, upButtonY - 24, 70, 22));
        this.stopButton.setText("Stop");
        this.stopButton.addActionListener(this.stopHandler);
        this.leftButton.setBounds(new Rectangle(this.boardWidth + 8, upButtonY + 22, 51, 22));
        this.leftButton.setHorizontalAlignment(10);
        this.leftButton.setText("<-");
        this.leftButton.addActionListener(this.leftHandler);
        this.rightButton.setBounds(new Rectangle(this.boardWidth + 59, upButtonY + 22, 51, 22));
        this.rightButton.setHorizontalAlignment(0);
        this.rightButton.setText("->");
        this.rightButton.addActionListener(this.rightHandler);
        this.downButton.setBounds(new Rectangle(this.boardWidth + 37, upButtonY + 44, 51, 22));
        this.downButton.setFont(new Font("Tahoma", 0, 8));
        this.downButton.setText("\\/");
        this.downButton.addActionListener(this.downHandler);
        this.add(this.rightButton);
        this.add(this.leftButton);
        this.add(this.upButton);
        this.add(this.downButton);
        this.add(this.startButton);
        this.add(this.stopButton);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this.keyBoard);
        this.rightButton.setFocusable(false);
        this.leftButton.setFocusable(false);
        this.upButton.setFocusable(false);
        this.downButton.setFocusable(false);
        this.startButton.setFocusable(false);
        this.stopButton.setFocusable(false);
    }

    public void init() {
    }

    public void update(Graphics g) {
        this.paint(g);
    }

    public void paint(Graphics g) {
        Dimension d = this.getSize();
        if(this.appletPaint) {
            super.paint(g);
        }

        this.checkOffScreenImage();
        Graphics offG = this.mImage.getGraphics();
        offG.setColor(this.getBackground());
        offG.fillRect(4, 30, this.boardWidth, this.boardHeight);
        this.draw(this.mImage.getGraphics());
        g.drawImage(this.mImage, 0, 0, (ImageObserver)null);
        this.appletPaint = true;
    }

    private void checkOffScreenImage() {
        Dimension d = this.getSize();
        if(this.mImage == null || this.mImage.getWidth((ImageObserver)null) != this.boardWidth || this.mImage.getHeight((ImageObserver)null) != this.boardHeight + 30) {
            this.mImage = this.createImage(this.boardWidth, this.boardHeight + 30);
        }

    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
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

    public void mouseClicked(int x, int y, int buttonPressed) {
    }

    public void mouseDragged(int x, int y) {
    }

    class DownHandler implements ActionListener {
        DownHandler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.gamePanel.downButton();
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }

    class KeyHandler extends KeyAdapter {
        KeyHandler() {
        }

        public void keyPressed(KeyEvent e) {
            char c = KeyEvent.getKeyText(e.getKeyCode()).charAt(0);
            GameBoard.this.gamePanel.keyStruck(c);
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }

    class LeftHandler implements ActionListener {
        LeftHandler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.gamePanel.leftButton();
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }

    class RightHandler implements ActionListener {
        RightHandler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.gamePanel.rightButton();
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }

    class StartHandler implements ActionListener {
        StartHandler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.gameStarted = true;
            if(GameBoard.this.timer1On) {
                GameBoard.this.t1.start();
            }

            if(GameBoard.this.timer2On) {
                GameBoard.this.t2.start();
            }

            if(GameBoard.this.timer3On) {
                GameBoard.this.t3.start();
            }

            GameBoard.this.appletPaint = true;
            GameBoard.this.repaint();
            GameBoard.this.appletPaint = false;
        }
    }

    class StopHandler implements ActionListener {
        StopHandler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.t1.stop();
            GameBoard.this.t2.stop();
            GameBoard.this.t3.stop();
        }
    }

    class Timer1Handler implements ActionListener {
        Timer1Handler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.gamePanel.timer1();
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }

    class Timer2Handler implements ActionListener {
        Timer2Handler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.gamePanel.timer2();
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }

    class Timer3Handler implements ActionListener {
        Timer3Handler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.gamePanel.timer3();
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }

    class UpHandler implements ActionListener {
        UpHandler() {
        }

        public void actionPerformed(ActionEvent e) {
            GameBoard.this.gamePanel.upButton();
            GameBoard.this.appletPaint = false;
            GameBoard.this.repaint();
        }
    }
}

