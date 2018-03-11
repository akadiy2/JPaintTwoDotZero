package model.shape;

import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by abhiramkadiyala on 2/7/18.
 */
public class Triangle extends Shape {
    private static final int NUM_SIDES = 3;
    private int[] xCoords;
    private int[] yCoords;


    public Triangle(Point p1, Point p2) {
        super(p1, p2);
        xCoords = new int[NUM_SIDES];
        yCoords = new int[NUM_SIDES];
        setShapeType(ShapeType.TRIANGLE);
        setUp(p1, p2);
    }

    @Override
    void setUp(Point p1, Point p2) {
        if (p1 != null && p2 != null) {
            if (p1.getX() < p1.getY()) {
                //If the mouse was dragged from left to right
                xCoords[0] = (int) p1.getX();
                xCoords[1] = (int) ((p2.getX() - p1.getX()) / 2);
                xCoords[xCoords.length - 1] = (int) p2.getX();
                yCoords[0] = (int) p1.getY();
                yCoords[1] = (int) (Math.abs(p1.getY() - p2.getY()) + 20);
                yCoords[yCoords.length - 1] = (int) p2.getY();
            } else {
                //Mouse was dragged from right to left
                xCoords[0] = (int) p2.getX();
                xCoords[1] = xCoords[1] = (int) ((p1.getX() - p2.getX()) / 2);
                xCoords[xCoords.length - 1] = (int) p1.getX();
                yCoords[0] = (int) p2.getY();
                yCoords[1] = (int) (Math.abs(p1.getY() - p2.getY()) + 20);
                yCoords[yCoords.length - 1] = (int) p1.getY();
            }
        }
    }

    @Override
    public void draw(Graphics2D g) throws Exception {


        super.draw(g);
        System.out.println(String.format("Drawing a %s %s with coordinates %s, %s, with number of sides %d",
                getShapeColor(), getShapeType().name(), Arrays.toString(xCoords), Arrays.toString(yCoords), NUM_SIDES));

        if (ShapeShadingType.FILLED_IN == getShapeShadingType()) {
            g.fillPolygon(xCoords, yCoords, NUM_SIDES);
        } else {
            g.drawPolygon(xCoords, yCoords, NUM_SIDES);
        }

    }

    @Override
    public void clear(Graphics2D g) throws Exception {
        g.dispose();
    }
}
