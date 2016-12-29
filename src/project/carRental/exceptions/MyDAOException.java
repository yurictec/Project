package project.carRental.exceptions;

/**
 * @author Yuri Kolennikov
 */
public class MyDAOException extends PsException {

    public MyDAOException() {
        super();
    }


    public MyDAOException(String message) {
        super(message);
    }


    public MyDAOException(String message, Exception cause) {
        super(message, cause);
    }


    public MyDAOException(Exception cause) {
        super(cause);
    }


    protected MyDAOException(String message, Exception cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
