package main.homeworks.java.homework4.strings.task1;

public class EvenOddString {

    private String inputString;

    public EvenOddString(String inputString) {
        this.inputString = inputString;
    }

    public String makeString(String inputMethod) {
        String result;
        switch (inputMethod) {
            case "even":
                result = evenString(inputString);
                break;
            case "odd":
                result = oddString(inputString);
                break;
            default:
                result = "Unknown method!";
                break;
        }
        return result;
    }

    private String oddString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    private String evenString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
