package project.carRental.exceptions;

/**
 * @author Yuri Kolennikov
 */
public class PsException extends Exception {
       public PsException() {
        super();
    }


    public PsException(String message) {
        super(message);
    }


    public PsException(String message, Exception cause) {
        super(message, cause);
    }


    public PsException(Exception cause) {
        super(cause);
    }


    protected PsException(String message, Exception cause,
                          boolean enableSuppression,
                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
