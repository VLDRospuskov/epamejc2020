package homework4.StringReversStr;

class stringReversStr {

    String reversStr(String str) {
        int firstWord = 0;
        int Space = 0;
        StringBuilder out = new StringBuilder();
        String strToReverse;
        boolean exit = false;
        while (!exit) {
            Space = str.indexOf(" ", Space);// find index of space
            if (Space == -1) {
                strToReverse = str.substring(firstWord);
                out.append(new StringBuffer(strToReverse).reverse());
                exit=true;
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
