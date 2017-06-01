package by.htp.shape.exception;

public class PairLinesException extends Exception {

    public PairLinesException() {
    }

    public PairLinesException(String message, Throwable exception) {
        super(message, exception);
    }

    public PairLinesException(String message) {
        super(message);
    }

    public PairLinesException(Throwable exception) {
        super(exception);
    }
}
