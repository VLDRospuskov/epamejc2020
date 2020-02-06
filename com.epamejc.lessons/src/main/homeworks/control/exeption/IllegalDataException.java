package homeworks.control.exeption;

public class IllegalDataException extends RuntimeException {
    public IllegalDataException(String request){
        super(String.format("Incorrect Input %s",request));
    }
}
