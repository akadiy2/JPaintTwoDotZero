package mouse;

import model.shape.Shape;
import model.shape.ShapeHandler;
import view.gui.PaintCanvas;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseInputAdapter implements IListener {
    private Point startingPoint;
    private Point endingPoint;
    private PaintCanvas canvas;
    private ShapeHandler shapeHandler;


    public MyMouseListener(ShapeHandler shapeHandler, PaintCanvas canvas) {
        this.shapeHandler = shapeHandler;
        this.canvas = canvas;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse X: " + e.getX());
        startingPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Y: " + e.getX());
        endingPoint = e.getPoint();
        execute();

    }

    @Override
    public void execute() {

        Shape shape = null;
        try {
            shape = shapeHandler.createShape(startingPoint, endingPoint);
            shape.draw(canvas.getGraphics2D());


        } catch (Exception e) {
            System.out.println("Unable to execute: " + e.getMessage());
        }
    }
}
