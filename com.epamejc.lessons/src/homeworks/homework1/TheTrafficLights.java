package homeworks.homework1;

public class TheTrafficLights {
    IOConsoleProvider ioConsoleProvider;

    private String green = "Green";
    private String yellow = "Yellow";
    private String red = "Red";

    public TheTrafficLights(IOConsoleProvider ioConsoleProvider) {
        this.ioConsoleProvider = ioConsoleProvider;
    }

    public void run() {
        ioConsoleProvider.writeOutput("Welcome to The Traffic Light \nPlease, enter a number. \nIf you want to quit, enter Q.");
        String userInput;

        while (true) {
            userInput = ioConsoleProvider.readInput();

            if (userInput.toLowerCase().equals("q")) break;

            checkTheLight(userInput);
        }



    }

    private void checkTheLight(String userInput) {
        int numb;
        String s = "Light color is ";

        if(!tryParse(userInput)) {
            ioConsoleProvider.writeOutput("You should enter a positive number");
            return;
        } else {
            numb = Integer.parseInt(userInput);
            numb %= 10;
        }


        if (numb >= 0 && numb <= 3) {
            ioConsoleProvider.writeOutput(s + green);
        } else if (numb >= 4 && numb <= 5) {
            ioConsoleProvider.writeOutput(s + yellow);
        } else if (numb >= 6) {
            ioConsoleProvider.writeOutput(s + red);
        }
        


    }

    private boolean tryParse(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
