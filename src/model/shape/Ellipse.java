package model.shape;

import model.*;

import java.awt.*;

/**
 * Created by abhiramkadiyala on 2/6/18.
 */
public class Ellipse extends QuadrilateralShape {

    public Ellipse(Point p1, Point p2) {
        super(p1, p2);
        setShapeType(ShapeType.ELLIPSE);
        setUp(p1,p2);
    }

    @Override
    public void draw(Graphics2D g) throws Exception {
        super.draw(g);
        System.out.println(String.format("Drawing a %s %s with coordinates %s, %s and height %s and width %s",
                getShapeColor(), getShapeType().name(), x, y, height, width));
        if (ShapeShadingType.FILLED_IN == this.getShapeShadingType()) {
            g.fillOval(x, y, Math.abs(width), Math.abs(height));
        } else {
            g.drawOval(x, y, Math.abs(width), Math.abs(height));
        }

    }

    @Override
    public void clear(Graphics2D g) throws Exception {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, Math.abs(width), Math.abs(height));
    }
}
