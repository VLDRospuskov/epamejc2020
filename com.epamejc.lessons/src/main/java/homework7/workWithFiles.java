package homework7;


import static java.lang.System.*;

public class workWithFiles {
    private String ReadFile="com.epamejc.lessons\\src\\main\\java\\homework7\\files\\read.txt";
    private String WriteFile="com.epamejc.lessons\\src\\main\\java\\homework7\\files\\write.txt";
    private String BWriteFile="com.epamejc.lessons\\src\\main\\java\\homework7\\files\\writeb.txt";
    public void run(){
        FileManager fileManager = new FileManager();
        BFileManager bFileManager = new BFileManager();
        long start = currentTimeMillis();
        String s = fileManager.readFile(ReadFile);
        fileManager.writeFile(WriteFile,s);
        long stop = currentTimeMillis();
        s = bFileManager.readFile(ReadFile);
        bFileManager.writeFile(BWriteFile,s);
        long stop2 = currentTimeMillis();
        out.println("Work with out buffer: "+ (stop - start) + "ms");
        out.println("Work with buffer: "+ (stop2 - stop) + "ms");



    }

}
