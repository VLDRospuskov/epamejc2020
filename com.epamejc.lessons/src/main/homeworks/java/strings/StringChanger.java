package homeworks.java.strings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringChanger {

    private String storedString = "";
    private String stringCache = "";

    /**
     * Generates a new {@code String} using even or odd characters of a source.
     *
     * @param parity switches the {@code String} building mode between the output of even and odd characters
     * @return builded {@code String}
     */
    public String evenOdd(Parity parity) {

        StringBuilder newString = new StringBuilder();
        for (int i = parity.ordinal(); i < storedString.length(); i += 2) {
            newString.append(storedString.charAt(i));
        }
        return newString.toString();

    }

    /**
     * Adds new char to cashed {@code String} by index.
     *
     * @param index The index of char in source {@code String} to be added
     *              to output
     * @return {@code boolean} indicator {@code true} if done and {@code false} otherwise
     */
    public boolean byIndex(int index) {

        boolean charAdded = false;
        if (index <= storedString.length() - 1 && index >= 0) {
            stringCache += storedString.charAt(index);
            charAdded = true;
        }
        return charAdded;

    }

    /**
     * Swaps two chars in the source {@code String} and returns
     * the result as a new {@code String}
     *
     * @param start index of the first character
     * @param end   index of the second character
     * @return changed String
     */
    public String swapChars(int start, int end) {

        if (start > end || end > storedString.length() - 1 || start < 0) {
            return "Wrong input. Try again!";
        }
        StringBuilder swapper = new StringBuilder(storedString);
        swapper.setCharAt(start, storedString.charAt(end));
        swapper.setCharAt(end, storedString.charAt(start));
        return swapper.toString();

    }

    /**
     * Flips words in source {@code String} without changing their
     * position in the sentence.
     *
     * @return new {@code String} with all words flipped.
     */
    public String flipWords() {

        StringBuilder flipped = new StringBuilder();
        String[] tempContainer = storedString.split(" ");
        for (String word : tempContainer) {
            flipped.append(new StringBuffer(word).reverse().toString()).append(" ");
        }
        return flipped.toString().trim();

    }

}
