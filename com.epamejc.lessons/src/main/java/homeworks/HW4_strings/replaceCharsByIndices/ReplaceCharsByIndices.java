package homeworks.HW4_strings.replaceCharsByIndices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceCharsByIndices {

    private int firstIndex = 0;
    private int secondIndex = 0;
    private final String REGEX = "(\\d{1,})\\s{0,}?.?\\s{0,}?(\\d{1,})";

    public ReplaceCharsByIndices() {
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    /**
     * Method for initializing indexes
     *
     * @param inputIndexes entered string with indices
     * @return check indexes flag
     */
    public boolean parseIndexes(String inputIndexes, String inputString) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(inputIndexes);
        if (matcher.find()) {
            return checkIndexes(matcher, inputString);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method for replacing characters in the original string by indexes
     *
     * @param inputString original string
     * @param firstIndex  first index
     * @param secondIndex second index
     * @return string with exchanged chars
     */
    public String exchangeStringChars(String inputString, int firstIndex, int secondIndex) {
        char[] inputStringArray = inputString.toCharArray();
        char index1 = inputStringArray[firstIndex];
        char index2 = inputStringArray[secondIndex];
        inputStringArray[firstIndex] = index2;
        inputStringArray[secondIndex] = index1;
        return String.valueOf(inputStringArray);
    }

    /**
     * Method for returning indices inside an array
     *
     * @return array with indices
     */
    public int[] getIndexes() {
        int[] indexArray = new int[2];
        indexArray[0] = getFirstIndex();
        indexArray[1] = getSecondIndex();
        return indexArray;
    }

    /**
     * Method for checking entered index values
     *
     * @param matcher      regex-matcher object
     * @param inputIndexes string with indices
     * @return flag are indices correct
     * @throws IllegalArgumentException exception if indices are incorrect
     */
    private boolean checkIndexes(Matcher matcher, String inputIndexes) throws IllegalArgumentException {
        if (matcher.groupCount() == 2) {
            firstIndex = Integer.parseInt(matcher.group(1));
            secondIndex = Integer.parseInt(matcher.group(2));
            if (firstIndex >= 0 && secondIndex >= 0 && firstIndex <= inputIndexes.length() - 1
                    && secondIndex <= inputIndexes.length() - 1) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }
}