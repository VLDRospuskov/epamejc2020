package lessons.java.lesson7.example6;

public class Main {

    public static void main(String [] args) {
//        System.out.println(asByte(7));
//        System.out.println(asByte(new Float("7.f")));
//         System.out.println(asByte(new Character('7')));
        // ошибка компиляции
    }

    public static <T1> int asByte(T1 num) {
//        Integer num1 = (Integer) num;
//        String num2 = (String) num;
        Class<?> aClass = num.getClass();
        String typeName = aClass.getTypeName();
        System.out.println(typeName);
        if (typeName.equals("Integer"))  {
            Integer num1 = (Integer) num;
        }
//        long n = num.longValue();
//        if (n >= -128 && n <= 127) return (byte)n;
//        else return 0;
        return 0;
    }

}


