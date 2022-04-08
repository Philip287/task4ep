package by.suprun.task4.exception;

public class CustomCompositeException extends Exception{

    public CustomCompositeException() {
        super();
    }


    public CustomCompositeException(String message) {
        super(message);
    }


    public CustomCompositeException(String message, Throwable cause) {
        super(message, cause);
    }


    public CustomCompositeException(Throwable cause) {
        super(cause);
    }
}
