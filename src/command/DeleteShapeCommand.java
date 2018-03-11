package command;

import model.ShapeManager;
import model.shape.IShape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhiramkadiyala on 3/10/18.
 */
public class DeleteShapeCommand implements ICommand, IUndoable {

    private PaintCanvas canvas;
    private List<Point> clickedPoints;
    private ShapeManager shapeManager = ShapeManager.getInstance();
    private List<IShape> shapesToBeDeleted = shapeManager.getShapesToDelete(clickedPoints);
    private List<IShape> shapesThatHaveBeenDeleted;

    public DeleteShapeCommand(PaintCanvas paintCanvas, List<Point> points) {
        this.canvas = paintCanvas;
        this.clickedPoints = points;
        shapesThatHaveBeenDeleted = new ArrayList<>();
    }

    @Override
    public void undo() {
        if (shapesThatHaveBeenDeleted.size() > 0) {
            shapeManager.addShape(shapesThatHaveBeenDeleted.get(shapesThatHaveBeenDeleted.size() - 1));
        }
        shapesThatHaveBeenDeleted.remove(shapesThatHaveBeenDeleted.size() - 1);
    }

    @Override
    public void redo() {
        IShape shape = shapesThatHaveBeenDeleted.get(shapesThatHaveBeenDeleted.size() - 1);
        try {
            shape.clear(canvas.getGraphics2D());
            shapeManager.remove(shapesThatHaveBeenDeleted.get(shapesThatHaveBeenDeleted.size() - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() throws IOException {
        shapesToBeDeleted.forEach(shape -> {
            try {
                shape.clear(canvas.getGraphics2D());
                shapeManager.remove(shape);
                shapesThatHaveBeenDeleted.add(shape);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
}
