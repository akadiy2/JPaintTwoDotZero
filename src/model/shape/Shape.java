package model.shape;

import model.*;

import java.awt.*;

public abstract class Shape implements IShape {

    private ShapeColor shapeColor;
    private ShapeColor secondaryShapeColor;
    private ShapeShadingType shapeShadingType;
    private ShapeType shapeType;
    private StartAndEndPointMode startAndEndPointMode;
    private Point startPoint;
    private Point endPoint;

    public Shape(ShapeColor shapeColor, ShapeColor secondaryShapeColor, ShapeShadingType shapeShadingType,
                 ShapeType shapeType, StartAndEndPointMode startAndEndPointMode, Point startPoint, Point endPoint) {
        this.shapeColor = shapeColor;
        this.secondaryShapeColor = secondaryShapeColor;
        this.shapeShadingType = shapeShadingType;
        this.shapeType = shapeType;
        this.startAndEndPointMode = startAndEndPointMode;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Shape(Point p1, Point p2) {
        this.startPoint = p1;
        this.endPoint = p2;
    }

    abstract void setUp(Point p1, Point p2);

    @Override
    public void draw(Graphics2D g) throws Exception {
        g.setColor(ColorFactory.getColor(this.getShapeColor()));
    }


    public ShapeColor getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;
    }

    public ShapeColor getSecondaryShapeColor() {
        return secondaryShapeColor;
    }

    public void setSecondaryShapeColor(ShapeColor secondaryShapeColor) {
        this.secondaryShapeColor = secondaryShapeColor;
    }

    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }

    public void setShapeShadingType(ShapeShadingType shapeShadingType) {
        this.shapeShadingType = shapeShadingType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public StartAndEndPointMode getStartAndEndPointMode() {
        return startAndEndPointMode;
    }

    public void setStartAndEndPointMode(StartAndEndPointMode startAndEndPointMode) {
        this.startAndEndPointMode = startAndEndPointMode;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public String toString() {
        return this.shapeType.name();
    }
}
