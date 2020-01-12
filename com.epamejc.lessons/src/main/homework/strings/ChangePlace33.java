package homework.strings;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class ChangePlace33 {
    public static void main(String[] args) {
        MainTemplate.main(ChangePlace33::ChangePlace);
    }

    public static String ChangePlace(BufferedReader reader) {
        try {
            System.out.println("введите строку: ");
            String str = reader.readLine();

            char[] arrstr1 = str.toCharArray();

            System.out.println(String.format("введите первый индекс в пределах 0, %d: ", str.length() - 1));
            String sFirstIndex = reader.readLine();
            int nFirstIndex = Integer.parseInt(sFirstIndex);
            System.out.println(String.format("введите второй индекс в пределах 0, %d: ", str.length() - 1));
            String sSecondIndex = reader.readLine();
            int nSecondIndex = Integer.parseInt(sSecondIndex);

            arrstr1[nFirstIndex] = str.charAt(nSecondIndex);
            arrstr1[nSecondIndex] = str.charAt(nFirstIndex);

            return new String(arrstr1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return ChangePlace(reader);
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println(e);
            return ChangePlace(reader);
        }
    }

}
