package Home_works.HW2.Number3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String string;

    protected void start() {
        try {
            while (true) {
                System.out.println("Write your string:");
                string = reader.readLine();
                inputCheck();
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    private void inputCheck() throws IOException {
        while (true) {
            System.out.print("Write the indicates which you wat to switch (use the spase between them): ");
            String inputIndices = reader.readLine();
            String[] ind = inputIndices.split(" ");
            int ind1 = Integer.parseInt(ind[0]);
            int ind2 = Integer.parseInt(ind[1]);
            changeString(ind1, ind2);
            break;
        }
    }


    private void changeString(int ind1, int ind2) {
        StringBuilder result = new StringBuilder(string);
        result.delete(ind1, ind1 + 1);
        result.insert(ind1, string.charAt(ind2));
        result.delete(ind2, ind2 + 1);
        result.insert(ind2, string.charAt(ind1));
        System.out.println(result);
    }
}
