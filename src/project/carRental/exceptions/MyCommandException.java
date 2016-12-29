package project.carRental.exceptions;

/**
 * @author Yuri Kolennikov
 */
public class MyCommandException extends PsException {

    public MyCommandException() {
        super();
    }


    public MyCommandException(String message) {
        super(message);
    }


    public MyCommandException(String message, Exception cause) {
        super(message, cause);
    }


    public MyCommandException(Exception cause) {
        super(cause);
    }


    protected MyCommandException(String message, Exception cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
