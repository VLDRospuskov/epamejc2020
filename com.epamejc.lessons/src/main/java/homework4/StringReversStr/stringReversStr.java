package homework4.StringReversStr;

public class stringReversStr {

    public String reversStr(String str) {
        int firstWord = 0;
        int Space = 0;
        StringBuilder out = new StringBuilder();
        String strToReverse;
        while (true) {
            Space = str.indexOf(" ", Space);// find index of space
            if (Space == -1) {
                strToReverse = str.substring(firstWord, str.length());
                out.append(new StringBuffer(strToReverse).reverse());
                break;
            } else {
                strToReverse = str.substring(firstWord, Space);
                out.append(new StringBuffer(strToReverse).reverse());
                firstWord = Space;
                Space += 1;
            }
        }
        return out.toString();
    }
}
