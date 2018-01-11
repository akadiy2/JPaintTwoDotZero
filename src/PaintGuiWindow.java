import view.EventName;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;

import javax.swing.*;

/**
 * Created by abhiramkadiyala on 1/10/18.
 */
public class PaintGuiWindow extends GuiWindow {
    public PaintGuiWindow(PaintCanvas canvas) {
        super(canvas);
        JButton button = this.getButton(EventName.CHOOSE_SHAPE);

        JPopupMenu menu = new JPopupMenu();

        JMenuItem jMenuItem = new JMenuItem("Square");
        menu.add(jMenuItem);

        jMenuItem.addActionListener(ev -> {
            button.setText(jMenuItem.getText().toUpperCase());
        });


        button.addActionListener(ev -> {
            menu.show(button, button.getX(), button.getY() + button.getHeight());
        });
    }
}
