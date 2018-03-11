package model.shape;

import model.ColorFactory;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

/**
 * Created by abhiramkadiyala on 2/7/18.
 */
public class Rectangle extends QuadrilateralShape {

    public Rectangle(Point p1, Point p2) {
        super(p1, p2);
        setShapeType(ShapeType.RECTANGLE);
        setUp(p1, p2);
    }

    @Override
    public void draw(Graphics2D g) throws Exception {
        super.draw(g);
        System.out.println(String.format("Drawing a %s %s with coordinates %s, %s and height %s and width %s",
                getShapeColor(), getShapeType().name(), x, y, height, width));

        if (ShapeShadingType.FILLED_IN == this.getShapeShadingType()) {
            g.fillRect(x, y, Math.abs(width), Math.abs(height));
        } else if (ShapeShadingType.OUTLINE == this.getShapeShadingType()){
            g.drawRect(x, y, Math.abs(width), Math.abs(height));
        } else {
            g.fillRect(x, y, Math.abs(width), Math.abs(height));
            g.setColor(ColorFactory.getColor(this.getSecondaryShapeColor()));
            g.drawRect(x, y, Math.abs(width), Math.abs(height));
        }
    }

    @Override
    public void clear(Graphics2D g) throws Exception {
        g.setColor(Color.WHITE);
        if (ShapeShadingType.OUTLINE_AND_FILLED_IN == this.getShapeShadingType()) {

            g.fillRect(x - 1, y - 1, Math.abs(width) + 1, Math.abs(height) + 1);
        }

        g.fillRect(x, y, Math.abs(width), Math.abs(height));
    }

}
