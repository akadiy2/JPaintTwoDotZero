package model;

import model.shape.IShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Class to manage the creation and deletion of shapes to a singleton instantiated list
 */
public class ShapeManager {

    private List<IShape> shapeList;

    public static ShapeManager shapeManager = getInstance();

    public static ShapeManager getInstance() {
        if (shapeManager == null) {
            return new ShapeManager();
        }

        return shapeManager;
    }

    private ShapeManager() {
        shapeList = new ArrayList<>();
    }

    public void addShape(IShape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("No shape given!");
        }

        shapeList.add(shape);
    }

    public void removeLastShape() {
        if (!shapeList.isEmpty()) {
            shapeList.remove(shapeList.get(shapeList.size() - 1));
        }
    }

    public void remove(IShape shape) {
        this.shapeList.remove(shape);
    }

    public List<IShape> getShapeList() {
        return shapeList;
    }

    /**
     * Get all the {@link IShape}'s that are covered in the points that have been clicked.
     *
     * @param clickedPoints The {@link List} of {@link Point}'s which have been tracked by the mouse listener.
     * @return A {@link List} of {@link IShape}'s to be deleted.
     */
    public java.util.List<IShape> getShapesToDelete(List<Point> clickedPoints) {
        List<IShape> shapesToBeDeleted = new ArrayList<>();
        clickedPoints.forEach(point -> {
            shapesToBeDeleted.addAll(shapeList.stream().filter(shape -> point.getX() >= shape.getStartPoint().getX()
                    && point.getX() <= shape.getEndPoint().getX()
                    && point.getY() >= shape.getStartPoint().getY()
                    && point.getY() <= shape.getEndPoint().getY()).collect(Collectors.toList()));
        });
        return shapesToBeDeleted;
    }
}
