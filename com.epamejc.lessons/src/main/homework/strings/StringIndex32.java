package homework.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringIndex32 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringInd(reader);
    }

    public static void StringInd(BufferedReader reader) {

        StringBuffer resStr = new StringBuffer("");
        try {
            System.out.print("введите строку: ");
            String str = reader.readLine();

            StringBuffer strBuff = new StringBuffer(str);
            System.out.print("сколько индексов строки вы хотите получить (введите целое число): ");
            String sCountIndex = reader.readLine();
            int nCountIndex = Integer.parseInt(sCountIndex);
            int len = str.length() - 1;
            for (int i = 0; i < nCountIndex; i++) {
                System.out.print("введите индекс в пределах " + len + ": ");
                String sIndex = reader.readLine();
                int nIndex = Integer.parseInt(sIndex);
                resStr.append(strBuff.substring(nIndex, nIndex + 1));
                System.out.println(resStr);
            }
        } catch (IOException e) {
            System.out.println("Oops");
        } catch (StringIndexOutOfBoundsException ee) {
            System.err.println("WRONG!!!11");
            System.out.println("try again");
            StringInd(reader);
        }
    }
}
