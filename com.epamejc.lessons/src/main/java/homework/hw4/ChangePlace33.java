package homework.hw4;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class ChangePlace33 {
    public static void main(String[] args) {
        MainTemplate.main(ChangePlace33::ChangePlace);
    }

    public static String changePlaceCore(String str, int index1, int index2) {
        char[] aStr = str.toCharArray();
        aStr[index1] = str.charAt(index2);
        aStr[index2] = str.charAt(index1);

        return new String(aStr);
    }

    public static String ChangePlace(BufferedReader reader) {
        try {
            System.out.println("введите строку: ");
            String str = reader.readLine();


            System.out.println(String.format("введите первый индекс в пределах 0, %d: ", str.length() - 1));
            String sFirstIndex = reader.readLine();
            int nFirstIndex = Integer.parseInt(sFirstIndex);

            System.out.println(String.format("введите второй индекс в пределах 0, %d: ", str.length() - 1));
            String sSecondIndex = reader.readLine();
            int nSecondIndex = Integer.parseInt(sSecondIndex);

            return changePlaceCore(str, nFirstIndex, nSecondIndex);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return ChangePlace(reader);
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println(e);
            return ChangePlace(reader);
        }
    }

}
