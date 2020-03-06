package homework3.StringRandomNewStr;

public class stringRandomNewStr {

    public String applyStrategy(String str, String typeOfStrategy) {
        int i = 0;
        StringBuilder out = new StringBuilder();
        if ((typeOfStrategy.equals("B")) || (typeOfStrategy.equals("b"))) {
            i = 1;
        }
        while (i < str.length()) {
            out.append(str.charAt(i));
            i += 2;
        }
        return out.toString();
    }
}
