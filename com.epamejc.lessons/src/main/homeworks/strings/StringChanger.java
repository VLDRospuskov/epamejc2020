package main.homeworks.strings;

public class StringChanger {

    private String temporaryStorage = "";

    public String evenOdd(String str, int eo) {
        String temp = str.replaceAll(" ", "");
        StringBuilder result = new StringBuilder();

        if (eo == 3) {
            for (int i = 1; i < temp.length(); i += 2) {
                result.append(temp.charAt(i));
            }
        } else if (eo == 4) {
            for (int i = 0; i < temp.length(); i += 2) {
                result.append(temp.charAt(i));
            }
        }
        return result.toString();
    }

    public String byIndex(String str, int index) {
        try {
            temporaryStorage += str.charAt(index);
            return temporaryStorage;
        } catch (StringIndexOutOfBoundsException e) {
            return "Index out of bounds. Please enter index in range: 0 - " + (str.length() - 1) + "\n";
        }
    }

    public String swapChars(String str, int[] se) {
        int start = se[0], end = se[1];
        if (start > end || end > str.length() - 1 || start < 0) {
            return "Wrong input. Try again!";
        }

        StringBuilder swapper = new StringBuilder(str);
        swapper.setCharAt(start, str.charAt(end));
        swapper.setCharAt(end, str.charAt(start));

        return swapper.toString();
    }

    public String flipWords(String str) {
        StringBuilder flipped = new StringBuilder();
        String[] tempContainer = str.split(" ");
        for (String i : tempContainer) {
            flipped.append(new StringBuffer(i).reverse().toString()).append(" ");
        }
        return flipped.toString();
    }

    public void clearStorage() {
        temporaryStorage = "";
    }

}
