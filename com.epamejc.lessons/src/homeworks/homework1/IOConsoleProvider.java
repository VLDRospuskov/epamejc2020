package homeworks.homework1;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOConsoleProvider {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readInput() {
        String s = null;

        try {
            s = reader.readLine();
        }catch (IOException e) {
            System.out.println("Wrong entry! Try again!");
            this.readInput();
        }

        return s;
    }

    public void writeOutput(String data) {
        System.out.println(data);
    }

    public void close() throws IOException {
        reader.close();
    }

}
