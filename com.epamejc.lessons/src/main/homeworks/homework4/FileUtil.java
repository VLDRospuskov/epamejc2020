package homeworks.homework4;

import java.io.*;
import java.util.Date;
import java.util.Random;


public class FileUtil {
    public String compareSpeed(){
        File testFile = new File("test.txt");
        createFile(testFile);
        Date dateStBuf = new Date();
        String resultBuf = bufferedRead(testFile);

        Date dateEndBuf = new Date();
        Date dateStStr = new Date();
        String resultStr = read(testFile.getName());
        Date dateEndStr = new Date();

        int bufTime = getDuration(dateEndBuf,dateStBuf);
        int streamTime = getDuration(dateEndStr,dateStStr);

        String stream = bufTime > streamTime ? "Buffered slower. Difference is "  : "Stream slower. Difference is  ";
        int difference  = Math.abs(bufTime-streamTime)/1000;
        return stream + difference + " seconds";
    }
    private void createFile(File file){
        try (FileWriter writer = new FileWriter(file)) {
            final String sp = System.lineSeparator();
            writer.write(makeRandomText() + sp);
            System.out.println("File created!");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    private String makeRandomText(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20000; i ++){
            sb.append(makeRandomLane());
            sb.append("\r\n");
        }
        return sb.toString();
    }
    private String makeRandomLane(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i ++){
            sb.append(makeRandomChar());
        }
        return sb.toString();
    }
    private char makeRandomChar(){
        Random r = new Random();
        char ab = (char)(r.nextInt(26) + 'a');
        return ab;
    }
    private String bufferedRead(File file){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            System.out.println("Buffered done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    private String read(String fileName){
        StringBuilder sb = new StringBuilder();
        try(FileInputStream stream = new FileInputStream(fileName);){
            while(stream.available() > 0 ) {
                sb.append((char) stream.read());
            }
            System.out.println("Stream done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    private int getDuration(Date start, Date end){
        return (int)(end.getTime() - start.getTime());
    }

}
