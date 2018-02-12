package view.gui;

import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import model.shape.ShapeHandler;
import mouse.MyMouseListener;
import view.interfaces.IPaintCanvas;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent implements IPaintCanvas {
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
