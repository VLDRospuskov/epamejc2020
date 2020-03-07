package main.homeworks.java.homework7;

import com.sun.jndi.toolkit.url.Uri;

import java.io.*;
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

    private String getBook() throws Exception {
        URL website = new URL(fromURL);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine).append("\r\n");

        in.close();

        return response.toString();
    }

}
