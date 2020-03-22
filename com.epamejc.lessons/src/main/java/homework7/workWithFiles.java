package homework7;


import static java.lang.System.*;

public class workWithFiles {
    private String ReadFile="com.epamejc.lessons\\src\\main\\java\\homework7\\files\\read.txt";
    private String BWriteFile = "com.epamejc.lessons\\src\\main\\java\\homework7\\files\\writeb.txt";
    private String WriteFile="com.epamejc.lessons\\src\\main\\java\\homework7\\files\\write.txt";

    public void run(){
        FileManager fileManager = new FileManager();
        BFileManager bFileManager = new BFileManager();
        out.println(timer(fileManager, WriteFile));
        out.println(timer(bFileManager, BWriteFile));
    }

    private long timer(FileManager file, String patch) {
        long start = currentTimeMillis();
        String s = file.readFile(ReadFile);
        file.writeFile(patch, s);
        long stop = currentTimeMillis();
        return stop - start;
    }

}
