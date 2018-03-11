package command;

import model.ShapeManager;
import model.shape.IShape;
import view.gui.PaintCanvas;

import java.io.IOException;

/**
 * Created by abhiramkadiyala on 2/11/18.
 */
public class CreateShapeCommand implements ICommand, IUndoable {

    private PaintCanvas canvas;
    private ShapeManager shapeManager = ShapeManager.getInstance();
    private IShape shape;

    public CreateShapeCommand(PaintCanvas paintCanvas, IShape shape) {
        this.shape = shape;
        this.canvas = paintCanvas;
    }


    @Override
    public void undo() {
        try {
            this.shape.clear(canvas.getGraphics2D());
            shapeManager.removeLastShape();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void redo() {
        try {
            this.shape.draw(canvas.getGraphics2D());
            shapeManager.addShape(shape);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() throws IOException {
        try {
            shape.draw(canvas.getGraphics2D());
            CommandHistory.add(this);
            shapeManager.addShape(shape);
            System.out.println(shapeManager.getShapeList());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
