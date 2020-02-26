package homeworks.java.hw4.strings;

public class EvenOddReturner {

    public String makeStringFromEvenOrOddChars(String word, String evenOrOdd) {
        if (evenOrOdd.equalsIgnoreCase("even")) {
            String evenStr = "";
            for (int i = 1; i < word.length(); ) {
                evenStr = evenStr + word.charAt(i);
                System.out.print(word.charAt(i));
                i = i + 2;
            }
            System.out.println();
            return evenStr;
        } else if (evenOrOdd.equalsIgnoreCase("odd")) {
            String oddStr = "";
            for (int i = 0; i < word.length(); ) {
                oddStr = oddStr + word.charAt(i);
                System.out.print(word.charAt(i));
                i = i + 2;
            }
            System.out.println();
            return oddStr;
        }
        return new String();
    }

}
