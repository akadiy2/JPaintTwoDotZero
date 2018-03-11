package command;

import java.io.IOException;

/**
 * Created by abhiramkadiyala on 3/10/18.
 */
public class RedoCommand implements ICommand {

    @Override
    public void run() throws IOException {
        CommandHistory.redo();
    }

}
