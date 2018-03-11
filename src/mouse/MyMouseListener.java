package mouse;

import command.CreateShapeCommand;
import command.DeleteShapeCommand;
import command.ICommand;
import model.ShapeManager;
import model.persistence.ApplicationState;
import model.shape.IShape;
import model.shape.ShapeHandler;
import view.gui.PaintCanvas;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MyMouseListener extends MouseInputAdapter implements IListener {
    private Point startingPoint;
    private Point endingPoint;
    private PaintCanvas canvas;
    private ShapeHandler shapeHandler;
    private ApplicationState applicationState = ApplicationState.getInstance();
    private List<Point> clickedPoints = new ArrayList<>();


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
        try {
            execute();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickedPoints.add(new Point(e.getX(), e.getY()));
    }

    @Override
    public void execute() throws Exception {
        IShape shape;
        ICommand command;

        System.out.println(applicationState.isDeleteModeOn());
        if (applicationState.isDeleteModeOn()) {
            command = new DeleteShapeCommand(canvas, clickedPoints);
        } else {

            shape = shapeHandler.createShape(startingPoint, endingPoint);
            command = new CreateShapeCommand(canvas, shape);

        }
        command.run();
    }
}
