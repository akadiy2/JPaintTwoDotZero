import view.gui.Gui;
import view.interfaces.IDialogChoice;
import view.interfaces.IGuiWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by abhiramkadiyala on 1/15/18.
 */
public class PaintGui extends Gui {
    public PaintGui(IGuiWindow gui) {
        super(gui);
    }

    @Override
    public <T> T getDialogResponse(IDialogChoice dialogSettings) {
        Object selectedValue = JOptionPane.showInputDialog((Component)null, dialogSettings.getDialogText(), dialogSettings.getDialogTitle(), -1, (Icon)null, dialogSettings.getDialogOptions(), dialogSettings.getCurrentSelection());

    }
}
