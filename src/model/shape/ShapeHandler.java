package model.shape;

import exception.InvalidShapeException;
import model.ShapeType;
import model.persistence.ApplicationState;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class ShapeHandler {
    private ApplicationState applicationState;

    public ShapeHandler() {
    }

    public ShapeHandler(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
    private Shape createShape(ShapeType shapeType, Point p1, Point p2) throws InvalidShapeException {
        return ShapeFactory.createShape(shapeType, p1, p2);
    }

    /**
     * Creates an {@link IShape} based on the {@link ApplicationState}'s selected shape and given {@link Point}'s
     *
     * @param start - The {@link Point} retrieved when the mouse was pressed (beginning of shape)
     * @param end - - The {@link Point} retrieved when the mouse was released (end of shape)
     * @return an {@link IShape}
     * @throws Exception
     */
    public IShape createShape(Point start, Point end) throws Exception {
        Shape shape = createShape(applicationState.getActiveShapeType(), start, end);
        if (shape != null) {

            shape.setStartPoint(start);
            shape.setEndPoint(end);
            shape.setShapeColor(applicationState.getActivePrimaryColor());
            shape.setSecondaryShapeColor(applicationState.getActiveSecondaryColor());
            shape.setShapeType(applicationState.getActiveShapeType());
            shape.setShapeShadingType(applicationState.getActiveShapeShadingType());
            shape.setStartAndEndPointMode(applicationState.getActiveStartAndEndPointMode());
            return shape;
        }

        throw new InvalidShapeException("Unable to create shape");
    }

}
