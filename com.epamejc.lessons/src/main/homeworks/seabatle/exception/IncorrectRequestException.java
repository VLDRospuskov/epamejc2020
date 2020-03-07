package homeworks.seabatle.exception;

public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException(String request) {
        super(request);
    }
}
