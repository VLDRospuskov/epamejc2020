package homeworks.java.seabattle.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNameGenerator {

    public static String generateName() {

        List<String> names = read("com.epamejc.lessons/src/resources/lastNames.sb");
        List<String> firstNames = read("com.epamejc.lessons/src/resources/firstNames.sb");

        return ("admiral " +
                firstNames.get(new Random().nextInt(firstNames.size())) + " "
                + names.get(new Random().nextInt(names.size())));

    }

    private static List<String> read(String fileName) {

        List<String> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;

    }

}

