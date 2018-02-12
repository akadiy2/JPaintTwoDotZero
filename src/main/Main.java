

import controller.IJPaintController;
import controller.JPaintController;
import exception.InvalidShapeException;
import model.ShapeType;
import model.persistence.ApplicationState;
import model.shape.Shape;
import model.shape.ShapeFactory;
import model.shape.ShapeHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationState appState = ApplicationState.getInstance();
        IGuiWindow guiWindow = new GuiWindow(appState, new PaintCanvas());
        IUiModule uiModule = new Gui(guiWindow);
        appState.init(uiModule);

        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
    }
}