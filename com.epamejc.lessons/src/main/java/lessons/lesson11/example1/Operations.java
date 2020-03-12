package lessons.lesson11.example1;

public class Operations {
    
    public int getSum(int a, int b) {
        return a + b;
    }
    
    public int getSumOfStrings(String a, String b) {
        try {
            Integer integer = Integer.valueOf(a);
            Integer integer2 = Integer.valueOf(b);
            return integer + integer2;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        throw new NumberFormatException();
    }
    
}
