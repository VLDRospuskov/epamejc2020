package lessons.java.lesson10.example2;

public class MyCustomException extends RuntimeException {

    public MyCustomException() {
    }

    public MyCustomException(String message) {
        super(message);
    }

    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCustomException(Throwable cause) {
        super(cause);
    }

    public MyCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
