package homeworks.homework4.task4_1;

public class OddEvenSubstring {
    
    public String useStrategy(String inputString, String mod) {
        switch (mod.toLowerCase()) {
            case "even":
                return createStringFromEven(inputString);
            case "odd":
                return createStringFromOdd(inputString);
            default:
                System.out.println("wrong mod input");
                return "";
        }
    }
    
    private String createStringFromEven(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (s.length() > 0) {
            for (int i = 1; i < s.length(); i += 2) {
                stringBuilder.append(s.charAt(i));
            }
        } else {
            System.out.println("String is too short for even");
        }
        
        return stringBuilder.toString();
    }
    
    private String createStringFromOdd(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
    
}
