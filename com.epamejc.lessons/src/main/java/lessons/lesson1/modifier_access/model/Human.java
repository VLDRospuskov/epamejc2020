package lessons.lesson1.modifier_access.model;

public class Human {

    public String publicMove() {
        return "publicMove";
    }

    String packageMove() {
        return "packageMove";
    }

    protected String protectedMove() {
        return "protectedMove";
    }

    private String privateMove() {
        return "privateMove";
    }

    private void callYourselfMethods() {
        publicMove();
        packageMove();
        protectedMove();
        privateMove();
    }

}
