package lessons.lesson3.string;

public class Main {

    public static void main(String[] args) {
        String s1, s2;
        s1 = "Java1";
        s2 = "Java" + 1;

        System.out.println("сравнение ссылок " + (s1 == s2));

        s1 += '2';

        // s1-="a"; //ошибка, вычитать строки нельзя
        s2 = s1;

        String s3 = new String(s1);


        System.out.println("сравнение ссылок " + (s1 == s3));
        System.out.println("сравнение значений " +
                s1.equals(s3));

    }
}
