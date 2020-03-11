package homeworks.seabatle.exception;


public class ShipNotFoundException extends IncorrectRequestException {

    public ShipNotFoundException(String request) {
        super(request);
    }
}
