package homeworks.java.hw4.strings;

public class WordsReverser {

     String reverseWordsAnPutOnInitialPlaces(String text) {
        String[] words = text.split(" ");
        String reversedStr = "";
        for (String word : words) {
            StringBuilder str = new StringBuilder(word);
            reversedStr = reversedStr + str.reverse().append(" ");
        }
        System.out.println(reversedStr.trim());
        return reversedStr.trim();
    }
}
