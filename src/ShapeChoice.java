import view.EventName;
import view.interfaces.IDialogChoice;

/**
 * Created by abhiramkadiyala on 1/15/18.
 */
public class ShapeChoice implements IDialogChoice<ShapeType> {
    private String currentSelection;

    public ShapeChoice() {
        super();
        currentSelection = getDialogOptions()[0].toString();
    }

    @Override
    public String getDialogTitle() {
        return "Shapes";
    }

    @Override
    public String getDialogText() {
        return EventName.CHOOSE_SHAPE.toString();
    }

    @Override
    public ShapeType[] getDialogOptions() {
        return ShapeType.values();
    }

    @Override
    public ShapeType getCurrentSelection() {
        return ShapeType.ELLIPSE;
    }
}
