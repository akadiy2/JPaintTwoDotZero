package mouse;

import exception.InvalidShapeException;

/**
 * Created by abhiramkadiyala on 2/11/18.
 */
public interface IListener {
    void execute() throws InvalidShapeException, Exception;
}
