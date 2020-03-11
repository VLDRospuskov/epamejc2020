package homeworks.seabatle.exception;


public class IncorrectInputParseException extends IncorrectRequestException {

    public IncorrectInputParseException(String request) {
        super(request);
    }
}
