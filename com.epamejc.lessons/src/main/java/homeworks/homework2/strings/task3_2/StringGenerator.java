package homeworks.homework2.strings.task3_2;

public class StringGenerator {

    public String generateString(String sourceString, StringBuilder stringBuilder, int nextInt) {
        if ((nextInt < sourceString.length()) && (nextInt >= 0)) {
            stringBuilder.append(sourceString.charAt(nextInt));
        } else {
            System.out.println("Number is too big or too low");
        }
        return stringBuilder.toString();
    }

}
