package hfutonline.exception;

/**
 * Created by lenovo on 2017/9/10.
 */
public class UserException extends Exception{

    private static final long serialVersionUID = 1L;

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(String message) {
        super(message);
    }

}
