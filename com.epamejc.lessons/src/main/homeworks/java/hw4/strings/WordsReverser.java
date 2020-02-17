package homeworks.java.hw4.strings;

public class WordsReverser {

     void reverseWordsAnPutOnInitialPlaces(String text) {
        String[] words = text.split(" ");
        for (String word : words) {
            StringBuilder str = new StringBuilder(word);
            str.reverse();
            System.out.print(str);
            System.out.print(" ");
        }
    }
}
