package model;

import exception.InvalidShapeException;
import model.shape.Ellipse;
import model.shape.Rectangle;
import model.shape.Shape;
import model.shape.Triangle;

import java.awt.*;

/**
 * Created by abhiramkadiyala on 2/11/18.
 */
public class ColorFactory {
    public static Color getColor(ShapeColor shapeColor) throws Exception {
        if (shapeColor == null) {
            throw new NullPointerException("ShapeColor given was null");
        }

        switch (shapeColor) {
            case BLACK:
                return Color.BLACK;
            case BLUE:
                return Color.BLUE;
            default:
                throw new IllegalArgumentException(String.format("Invalid color name given: %s", shapeColor));
        }
    }
}
