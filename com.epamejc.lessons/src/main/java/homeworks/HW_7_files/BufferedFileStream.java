package homeworks.HW_7_files;

import java.io.*;

public class BufferedFileStream extends FileStream {

    /**
     * Extract the contents of the file
     *
     * @param filePath path to the file we are reading
     * @return file contents
     */
    @Override
    public String readFile(String filePath) {
        char[] content = null;
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            content = new char[fileInputStream.available()];
            bufferedReader.read(content);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new String(content);
    }

    /**
     * Write the contents of the file we read
     *
     * @param content  file contents we are writing
     * @param filePath path to the file we are writing
     */
    @Override
    public void writeFile(String content, String filePath) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
