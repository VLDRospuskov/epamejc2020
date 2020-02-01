package main.lessons.lesson7.example7;

public class GenericRestriction<T> {

    private T x; // error
    private T y;

    public GenericRestriction(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public <T> String typeIdentifier(T obj) {
        try {
            if (obj instanceof String){
                return "String";
            } else if (obj instanceof Integer) {
                return "Integer";
            } else if (obj instanceof Double) {
                return "Double";
            } else {
                return "UnknownType";
            }

        } catch (Exception ex) {
            return "UnknownType";
        }
    }

}
