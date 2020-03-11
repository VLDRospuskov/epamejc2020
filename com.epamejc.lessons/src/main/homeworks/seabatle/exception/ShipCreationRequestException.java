package homeworks.seabatle.exception;


public class ShipCreationRequestException extends IncorrectRequestException {

    public ShipCreationRequestException(String request) {
        super(request);
    }
}
