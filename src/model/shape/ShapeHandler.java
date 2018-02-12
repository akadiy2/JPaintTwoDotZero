package model.shape;

import exception.InvalidShapeException;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;

import java.awt.*;

public class ShapeHandler {
    private ApplicationState applicationState;

    public ShapeHandler(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
    private Shape createShape(ShapeType shapeType, Point p1, Point p2) throws InvalidShapeException {
        return ShapeFactory.createShape(shapeType, p1, p2);
    }

    public Shape createShape(Point start, Point end) throws Exception {
        Shape shape = createShape(applicationState.getActiveShapeType(), start, end);
        if (shape != null) {

            shape.setStartPoint(start);
            shape.setEndPoint(end);
            shape.setShapeColor(applicationState.getActivePrimaryColor());
            return shape;
        }

        throw new InvalidShapeException("Unable to create shape");
    }
}
