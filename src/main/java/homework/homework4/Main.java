package homework.homework4;

public class Main {
    public static void main(String[] args) {
        String everyOtherCharsString = StringGenerator.createOfEveryOtherChars("String", true);
        System.out.println(everyOtherCharsString);

        String chosenCharsString = StringGenerator.createOfIndexes("Hello world", 0, 4, 6);
        System.out.println(chosenCharsString);

        String swappedSymbolsString = StringGenerator.swapSymbols("Hello World", 0, 4);
        System.out.println(swappedSymbolsString);

        String reversedWordsString = StringGenerator.reverseWords("Hello World");
        System.out.println(reversedWordsString);
    }
}
