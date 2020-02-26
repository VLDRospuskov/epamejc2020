package homeworks.java.hw4.strings;

public class CharsReplacer {

    String replaceTwoChars(String str, int index1, int index2) {
        StringBuilder strB = new StringBuilder(str);
        String first = str.substring(index1, index1 + 1);
        String second = str.substring(index2, index2 + 1);
        StringBuilder changedStr = new StringBuilder();

        if (index1 <= str.length() && index2 <= str.length()) {
            changedStr = strB.replace(index1, index1 + 1, second);
            changedStr.replace(index2, index2 + 1, first);
            System.out.println(changedStr);
        } else {
            System.out.println("The indexes have to be smaller or to match the string's length");
        }
        return String.valueOf(changedStr);
    }

}
