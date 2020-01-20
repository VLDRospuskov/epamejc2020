package lesson2;


public class Task1 {

    public static void main(String[] args) {

        String str = "I love";
        String str1 =str+" Java";

        String str3 = "I love Java";
        String str2 = str1;//обе переменные-ссылки указывают на одну строку.
        System.out.println(str1==str3);
        System.out.println(str3==str2);

        System.out.println(str2);
        str1="test";
        //str1.substring(10);//обрезаем исходную строку
        System.out.println(str1);

    }

}
