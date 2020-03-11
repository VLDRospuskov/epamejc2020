package homeworks.seabatle.exception;


public class IncorrectShootRequestException extends IncorrectRequestException {

    public IncorrectShootRequestException(String request) {
        super(request + " is not valid");
    }
}
