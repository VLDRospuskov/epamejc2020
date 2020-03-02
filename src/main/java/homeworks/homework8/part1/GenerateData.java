package homeworks.homework8.part1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateData {

    public static DataToValidate getData(Provider<? extends Integer> provider) {
        return new DataToValidate(Stream
                .iterate(0, x -> x < 1000, x -> x + provider.provide())
                .collect(Collectors.toList()));
    }
}
