package homeworks.homework2.strings.task3_4;

public class ReverseWords {

    public String getReversedString(String inputString) {
        String[] splited = inputString.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder reversedStringBuilder = new StringBuilder();

        for (String s : splited) {
            reversedStringBuilder.append(s);
            stringBuilder.append(reversedStringBuilder.reverse()).append(" ");
            reversedStringBuilder.delete(0, reversedStringBuilder.length());
        }

        return stringBuilder.toString();
    }

}
