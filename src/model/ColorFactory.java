package model;

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
