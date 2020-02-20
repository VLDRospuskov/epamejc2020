package homeworks.HW_7_files;

import java.io.*;

public class FileStream {

    /**
     * Extract the contents of the file
     *
     * @param filePath path to the file we are reading
     * @return file contents
     */
    public String readFile(String filePath) {
        char[] content = null;
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            content = new char[fileInputStream.available()];
            InputStreamReader fileReader = new InputStreamReader(fileInputStream);
            fileReader.read(content);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return new String(content);
    }


    /**
     * Write the contents of the file we read
     *
     * @param content  file contents we are writing
     * @param filePath path to the file we are writing
     */
    public void writeFile(String content, String filePath) {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath))) {
            outputStreamWriter.write(content, 0, content.length());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
