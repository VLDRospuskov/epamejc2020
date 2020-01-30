package homeworks.homework4;

public class StringChanger {

    private String temp = "";

    public String evenOrOddChars(String input, int n) {
        String s = "";
        char[] chars = input.toCharArray();

        for (int i = n; i < chars.length; i += 2) {
            s += chars[i];
        }

        return s;
    }

    public String generateString(String input, int n) {
        char[] chars = input.toCharArray();

        if (n < 0 || n >= chars.length) {
            return "Out of range. Please enter a number from 0 to " + (chars.length - 1);
        }

        this.temp += chars[n];

        return this.temp;
    }

    public String swapChars(String input, int a, int b) {
        char[] chars = input.toCharArray();

        if ((a < 0 || a >= chars.length) || (b < 0 || b >= chars.length)) {
            return input;
        }

        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;

        return String.copyValueOf(chars);
    }

    public String reverse(String input) {
        String replacement = input.replaceAll("[^A-Za-zА-Яа-я0-9\\s]", "");
        String[] strings = replacement.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            strings[i] = new StringBuffer(strings[i]).reverse().toString();
        }

        for (String s : strings) {
            sb.append(s).append(" ");
        }

        return sb.toString();
    }

    public void clearTemp() {
        this.temp = "";
    }

}
