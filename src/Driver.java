import view.EventName;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;

/**
 * Created by abhiramkadiyala on 1/10/18.
 */
public class Driver {
    public static void main (String [] args) {
        PaintGuiWindow guiWindow = new PaintGuiWindow(new PaintCanvas());
        Gui gui = new Gui(guiWindow);
        gui.addEvent(EventName.CHOOSE_SHAPE, () -> gui.getDialogResponse(new ShapeChoice()));
    }
}