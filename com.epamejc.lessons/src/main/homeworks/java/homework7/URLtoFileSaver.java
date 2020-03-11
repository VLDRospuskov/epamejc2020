package main.homeworks.java.homework7;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLtoFileSaver {

    private static final String OUT = "book.out";
    private String fromURL;

    public URLtoFileSaver(String fromURL) {
        this.fromURL = fromURL;
    }

    public void writeToFile() {

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUT)))) {
            String text = getBook();
            bw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getBook() throws MalformedURLException {
        URL website = new URL(fromURL);

        StringBuilder response = new StringBuilder();
        try {

            URLConnection connection = website.openConnection();

            try (
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()))
            ) {
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    response.append(inputLine).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

}
