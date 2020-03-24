package homework.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringIndex32 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringInd(reader);
    }

    private static void StringInd(BufferedReader reader) {
        try {
            System.out.print("введите строку: ");
            String str = reader.readLine();

            System.out.print("сколько индексов строки вы хотите получить (введите целое число): ");
            String sCountIndex = reader.readLine();
            int nNumOfIndices = Integer.parseInt(sCountIndex);

            StringBuilder resStr = new StringBuilder();

            for (int i = 0; i < nNumOfIndices; i++) {
                System.out.printf("введите индекс в пределах от 0 до %d:\n", str.length() - 1);
                String sIndex = reader.readLine();
                int nIndex = Integer.parseInt(sIndex);

                resStr.append(str.charAt(nIndex));
                System.out.println(resStr);
            }
        } catch (IOException e) {
            System.out.println("Unforeseen IOException");
        } catch (StringIndexOutOfBoundsException ee) {
            System.err.println("Entered index is out of bounds. Try again");
            StringInd(reader);
        }
    }
}
