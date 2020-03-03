package homeworks;

public class Main {
    public static Integer value = 0;

    public static void main(String[] args) {
        Integer value2 = getValue();
        value2 = 1;
        System.out.println(value);
    }

    public static Integer getValue() {
        return value;
    }

}