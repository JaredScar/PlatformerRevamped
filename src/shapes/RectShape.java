package shapes;

import com.jaredscarito.platformerrevamped.storage.PointStorage;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by user on 12/9/2017.
 */
public class RectShape extends Shape {
    public RectShape(BufferedImage canvas, Color c, int startX, int startY, int width, int height) {
        super(canvas, c, startX, startY, width, height);
        for(int x=0; x<width; x++) {
            for(int y=0; y<height; y++) {
                super.points.add(new PointStorage(x, y, c));
            }
        }
    }
}
