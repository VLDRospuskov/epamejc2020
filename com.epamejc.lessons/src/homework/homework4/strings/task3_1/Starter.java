package homework.homework4.strings.task3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print string:");
            String line = bufReader.readLine();
            System.out.println("Print option of output \"odd\" or \"even\" :");
            String option = getOption(bufReader);
            System.out.println("Output:");
            String modifiedLine = getModifiedString(line, option);
            System.out.println(modifiedLine);
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }

    private String getModifiedString(String str, String option) {
        if (option == null || str == null) {
            throw new IllegalArgumentException("Arguments must not be null!");
        }
        if (!option.equals("odd") && !option.equals("even")) {
            throw new IllegalArgumentException("Available option \"odd\" or \"even\" .");
        }
        return buildString(str, option);
    }

    private String buildString(String str, String option) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((i + 1) % 2 == 0 && option.equals("even")) {
                stringBuilder.append(str.charAt(i));
            } else if ((i + 1) % 2 != 0 && option.equals("odd")) {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private String getOption(BufferedReader bufReader) throws IOException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            String option = bufReader.readLine();
            if (!option.equals("odd") && !option.equals("even")) {
                System.err.println("Available option \"odd\" or \"even\" . Try again!");
            } else {
                return option;
            }
        }
    }
}
