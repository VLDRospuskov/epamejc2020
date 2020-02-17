package main.homeworks.java.homework4.strings.task4;

public class WordReverser {

    private String inputString;

    public WordReverser(String inputString) {
        this.inputString = inputString;
    }

    public String reverse() {
        String[] input = inputString.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : input) {
            int len = s.length();
            char lastChar = s.charAt(len - 1);
            if (!Character.isLetter(lastChar) && !Character.isDigit(lastChar)) {
                s = new StringBuilder(s.substring(0,s.length() - 1)).reverse().append(lastChar).toString();
            } else {
                s = new StringBuilder(s).reverse().toString();
            }
            result.append(s).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }


}
