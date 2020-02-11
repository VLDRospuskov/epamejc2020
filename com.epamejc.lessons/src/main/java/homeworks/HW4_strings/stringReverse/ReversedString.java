package homeworks.HW4_strings.stringReverse;

public class ReversedString {

    /**
     * Method for reversing words inside input string
     *
     * @param inputString original input string
     * @return reversed words inside original string
     */
    public String reverseStrings(String inputString) {
        String resultString = "";
        String[] splittedStrings = inputString.split("\\s+");
        for (int i = 0; i < splittedStrings.length; i++) {
            StringBuilder strBuilder = new StringBuilder(splittedStrings[i]);
            if (i == splittedStrings.length - 1) {
                resultString = resultString + strBuilder.reverse().toString();
            } else {
                resultString = resultString + strBuilder.reverse().toString() + " ";
            }
        }
        return resultString;
    }
}
