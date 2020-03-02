package homeworks.homework1;

public class InputHandler {

    public void handleUserInput (String userInput) {
        if (userInput != null && userInput.length() != 0 && isNumeric(userInput)) {
            double time = Double.parseDouble(userInput);
            ColorPrinter printer = new ColorPrinter();
            printer.printColor(time);
        } else {
            System.out.println("Time should be a digit");
        }
    }

    private Boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        return str.matches(regexDouble);
    }
}
