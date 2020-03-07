package homework.seabattle;

import lombok.Data;

import static homework.seabattle.Config.*;

@Data
public class Coordinate {

    private Character letter;
    private int number;

    public static Coordinate of(String letterNumberStr) {
        if (letterNumberStr.length() < 2) {
            throw new IllegalArgumentException(
                    "Line should contain letter and number, but actual line is " + letterNumberStr);
        }

        Character letter = letterNumberStr.charAt(0);
        int number = parseNumber(letterNumberStr);

        return new Coordinate(letter, number);
    }

    Coordinate(Character letter, int number) {
        this.letter = letter;
        this.number = number;

        verifyLetter(letter);
        verifyNumber(number);
    }

    private static int parseNumber(String letterNumberStr) {
        String numberStr = letterNumberStr.substring(1);
        int number;

        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a number " + numberStr);
        }
        return number;
    }

    private static void verifyNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Incorrect number " + number);
        }
    }

    private static void verifyLetter(Character letter) {
        if (letter.compareTo(MIN_LETTER) < 0 || letter.compareTo(MAX_LETTER) > 0) {
            throw new IllegalArgumentException("Incorrect letter " + letter);
        }
    }
}
