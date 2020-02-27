package homeworks.java.seabattle.data.enums;

import lombok.Getter;

@Getter
public enum Outputs {

    HELP ("enter \"Exit\" - to quit the program\n " +
            "input format to shoot is \"Sd\", where S - letter, d - integer\n "),
    START("Welcome to a Sea Battle game! \n" +
            "enter \"Help\" to see controls"),
    END("Whe winner is: ");

    private String message;

    Outputs(String message) {

        this.message = message;

    }

}
