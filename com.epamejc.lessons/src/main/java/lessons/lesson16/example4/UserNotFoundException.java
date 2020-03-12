package lessons.lesson16.example4;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException() {
    }
    
    public UserNotFoundException(String message) {
        super(message);
    }
    
}
