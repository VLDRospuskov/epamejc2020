package main.homework.homework2;

public class StringGenerator {

    public static String createOfEveryOtherChars(String string, boolean isEven) {
        int startIndex = isEven ? 1 : 0;
        return getEveryOtherChars(string, startIndex);
    }

    public static String createOfChars(String string, int... indexes) {

        StringBuilder builder = new StringBuilder();

        for (int index : indexes) {
            if (index < 0 || index >= string.length()) {
                throw new IndexOutOfBoundsException();
            }

            builder.append(string.charAt(index));
        }
        return builder.toString();
    }

    public static String swapSymbols(String string, int index1, int index2) {

        int length = string.length();
        if (index1 < 0 || index2 < 0 || index1 >= length || index2 >= length) {
            throw new IndexOutOfBoundsException();
        }

        StringBuilder builder = new StringBuilder(string);

        char symbol1 = builder.charAt(index1);
        char symbol2 = builder.charAt(index2);

        builder.replace(index1, index1 + 1, String.valueOf(symbol2));
        builder.replace(index2, index2 + 1, String.valueOf(symbol1));

        return builder.toString();
    }

    public static String reverseWords(String string) {

        String[] words = string.split(" ");

        StringBuilder resultBuilder = new StringBuilder();

        for (String word : words) { // make method reverseString
            String reversedWord = new StringBuilder(word).reverse().toString();
            resultBuilder.append(reversedWord);
            resultBuilder.append(" ");
        }
        resultBuilder.deleteCharAt(string.length());
        return resultBuilder.toString();
    }

    private static String getEveryOtherChars(String string, int startIndex) {

        StringBuilder builder = new StringBuilder();

        for (int index = startIndex; index < string.length(); index += 2) {
            builder.append(string.charAt(index));
        }

        return builder.toString();
    }
}