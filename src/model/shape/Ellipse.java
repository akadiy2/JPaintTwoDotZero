package model.shape;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;

import java.awt.*;

/**
 * Created by abhiramkadiyala on 2/6/18.
 */
public class Ellipse extends Shape {

    private int height;
    private int width;
    private int x;
    private int y;

    public Ellipse(Point p1, Point p2) {
        super(p1, p2);
        setShapeType(ShapeType.ELLIPSE);
    }

    @Override
    void setUp(Point p1, Point p2) {
        if (p1 != null && p2 != null) {
            this.x = (int) p1.getX();
            this.y = (int) p1.getY();
            this.width = (int) (p2.getX() - this.x);
            this.height = (int) (p2.getY() - this.y);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        System.out.println(String.format("Drawing a %s %s with coordinates %s, %s and height %s and width %s",
                getShapeColor(), getShapeType().name(), x, y, height, width));
        g.fillOval(x, y, width, height);
    }
}
