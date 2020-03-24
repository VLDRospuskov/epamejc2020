package homework;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.io.BufferedReader;

public class MainTemplate {
    public static void main(Function<BufferedReader, Object> function) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println(function.apply(reader));
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}