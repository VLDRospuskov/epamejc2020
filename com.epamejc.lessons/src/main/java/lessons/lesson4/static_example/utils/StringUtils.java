package lessons.lesson4.static_example.utils;

public class StringUtils {
    
    public static void printMsg(String str) {
        System.out.println(str);
    }
    
    public static String reverse(String str) {
        String reversedString = "";
        
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return reversedString;
    }
    
}
