package main.homeworks.hw3.strings.fourthstringtask;

class WordsReverserClass {

    static void reverser(String text) {

        String[] words = text.split(" ");
        for (String word : words) {
            StringBuilder str = new StringBuilder(word);
            str.reverse();
            System.out.print(str);
            System.out.print(" ");
        }
    }
}
