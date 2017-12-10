package shapes;

import com.jaredscarito.platformerrevamped.storage.PointStorage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by user on 12/9/2017.
 */
public abstract class Shape {
    protected ArrayList<PointStorage> points = new ArrayList<>();
    protected Color color;
    protected int width;
    protected int height;
    protected int startX;
    protected int startY;
    protected BufferedImage canvas;
    public Shape(BufferedImage canvas, Color c, int startX, int startY, int width, int height) {
        this.color = c;
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.canvas = canvas;
    }
    public void draw() {
        for(PointStorage ps : getPoints()) {
            this.canvas.setRGB(ps.getTransformedX(), ps.getTransformedY(), ps.getColor().getRGB());
        }
    }
    public ArrayList<PointStorage> getPoints() {
        return this.points;
    }
    public void addX(int x) {
        for(PointStorage ps : this.points) {
            ps.setX(ps.getTransformedX() + x);
        }
    }
    public void subX(int x) {
        for(PointStorage ps : this.points) {
            ps.setX(ps.getTransformedX() - x);
        }
    }
    public void addY(int y) {
        for(PointStorage ps : this.points) {
            ps.setY(ps.getTransformedY() + y);
        }
    }
    public void subY(int y) {
        for(PointStorage ps : this.points) {
            ps.setY(ps.getTransformedY() - y);
        }
    }
}
