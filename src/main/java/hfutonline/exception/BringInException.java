package hfutonline.exception;

/**
 * Created by lenovo on 2017/9/12.
 */
public class BringInException extends Exception {
    private static final long serialVersionUID = 1L;

    public BringInException(String message, Throwable cause) {
        super(message, cause);
    }

    public BringInException(String message) {
        super(message);
    }
}

