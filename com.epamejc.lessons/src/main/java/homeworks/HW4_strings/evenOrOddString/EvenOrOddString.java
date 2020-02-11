package homeworks.HW4_strings.evenOrOddString;

public class EvenOrOddString {

    public EvenOrOddString() { }

    /**
     * Method for transforming the string based on the filter
     *
     * @param inputString input string
     * @param filterType  filter type (odd or even)
     * @return
     */
    public String processString(String inputString, String filterType) {
        if (filterType.equals(FilterTypes.EVEN.getValue())) {
           return returnEvenChars(inputString);
        } else {
            return returnOddChars(inputString);
        }
    }

    /**
     * Method for returning odd characters from a string
     * @param inputString original string
     * @return transformed string
     */
    private String returnOddChars(String inputString){
        StringBuilder charBox = new StringBuilder();
        int counter = 1;
        while (counter < inputString.length()) {
            charBox.append(inputString.charAt(counter));
            counter += 2;
        }
        return charBox.toString();
    }

    /**
     * Method for returning even characters from a string
     * @param inputString original string
     * @return transformed string
     */
    private String returnEvenChars(String inputString) {
        StringBuilder charBox = new StringBuilder();
        int counter = 0;
        while (counter < inputString.length()) {
            charBox.append(inputString.charAt(counter));
            counter += 2;
        }
        return charBox.toString();
    }
}



