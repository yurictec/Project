
package project.carRental.exceptions;

/**
 * @author Yuri Kolennikov
 */
public class MyConnectionException extends PsException {

    public MyConnectionException() {
        super();
    }


    public MyConnectionException(String message) {
        super(message);
    }


    public MyConnectionException(String message, Exception cause) {
        super(message, cause);
    }


    public MyConnectionException(Exception cause) {
        super(cause);
    }


    protected MyConnectionException(String message, Exception cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
