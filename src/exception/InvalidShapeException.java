package exception;

/**
 * Exception which gets thrown for an Invalid Shape
 */
public class InvalidShapeException extends Exception {
    public InvalidShapeException() {
        super();
    }

    public InvalidShapeException(String message) {
        super(message);
    }
}
