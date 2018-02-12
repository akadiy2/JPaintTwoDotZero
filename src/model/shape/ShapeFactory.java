package model.shape;

import exception.InvalidShapeException;
import model.ShapeType;
import util.PaintHelper;

import java.awt.*;

/**
 * Created by abhiramkadiyala on 2/9/18.
 */
public class ShapeFactory {

//    public static Shape createShape(String shapeTypeName) throws InvalidShapeException {
//        ShapeType shapeTypeFromString = PaintHelper.searchEnum(ShapeType.class, shapeTypeName);
//
//        if (ShapeType.TRIANGLE == shapeTypeFromString) {
//            return new Triangle();
//        } else if (ShapeType.RECTANGLE == shapeTypeFromString) {
//            return new Rectangle();
//        } else if (ShapeType.ELLIPSE == shapeTypeFromString) {
//            return new Ellipse();
//        } else {
//            throw new InvalidShapeException(String.format("Invalid shape name given: %s", shapeTypeName));
//        }
//    }

    public static Shape createShape(ShapeType shapeType, Point p1, Point p2) throws InvalidShapeException {

        if (ShapeType.TRIANGLE == shapeType) {
            return new Triangle(p1, p2);
        } else if (ShapeType.RECTANGLE == shapeType) {
            return new Rectangle(p1, p2);
        } else if (ShapeType.ELLIPSE == shapeType) {
            return new Ellipse(p1, p2);
        } else {
            throw new InvalidShapeException(String.format("Invalid shape type given: %s", shapeType));
        }
    }


}
