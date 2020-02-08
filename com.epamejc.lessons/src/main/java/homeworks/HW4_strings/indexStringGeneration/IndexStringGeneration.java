package homeworks.HW4_strings.indexStringGeneration;

public class IndexStringGeneration {

    private String resultString;

    public IndexStringGeneration() {
        this.resultString = "";
    }

    /**
     * Method for generating a substring with given charindex and entered string
     *
     * @param inputString index of char
     * @param indexOfChar entered string
     * @return substring
     */
    public String generateSubstring(String inputString, int indexOfChar) {
        StringBuilder charBox = new StringBuilder();
        charBox.append(inputString.charAt(indexOfChar));
        return charBox.toString();
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }
}


