package fpij.chapter5;

public class RodCutterException extends Exception {
    public RodCutterException() {
    }

    public RodCutterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RodCutterException(Throwable cause) {
        super(cause);
    }

    public RodCutterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RodCutterException(String s) {
        super(s);
    }
}
