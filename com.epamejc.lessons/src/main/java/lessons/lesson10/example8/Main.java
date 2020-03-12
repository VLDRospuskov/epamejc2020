package lessons.lesson10.example8;

public class Main {
    
    private static int age = 20;
    
    public static int getAgeWoman() {
        try {
            age = age - 3;
            return age;
        } finally {
            int age = Main.age;
            return age;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getAgeWoman());
    }
    
}
