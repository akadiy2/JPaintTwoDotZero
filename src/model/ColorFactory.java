package model;

import java.awt.*;

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
            case CYAN:
                return Color.CYAN;
            case DARK_GRAY:
                return Color.DARK_GRAY;
            case GRAY:
                return Color.GRAY;
            case GREEN:
                return Color.GREEN;
            case MAGENTA:
                return Color.MAGENTA;
            case ORANGE:
                return Color.ORANGE;
            case PINK:
                return Color.PINK;
            case RED:
                return Color.RED;
            case WHITE:
                return Color.WHITE;
            case YELLOW:
                return Color.YELLOW;
            default:
                throw new IllegalArgumentException(String.format("Invalid color name given: %s", shapeColor));
        }
    }
}
