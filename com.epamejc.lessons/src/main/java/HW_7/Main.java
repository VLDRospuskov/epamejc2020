package HW_7;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Writer fileWriter = new Writer();
        Reader filesReader = new Reader();

        fileWriter.writeByBytes();
        filesReader.readByBytes();

        Writer fileWriter2 = new Writer();
        fileWriter2.writeWithBuffer();

        Reader filesReader2 = new Reader();
        filesReader2.readByBuffer();

        Writer filesWriter3 = new Writer();
        filesWriter3.writeFileByFileWriter();

        Reader filesReader3 = new Reader();
        filesReader3.readByFileReaderWriter();

        Writer filesWriter4 = new Writer();
        filesWriter4.writeFileWithBufferedWriter();

        Reader filesReader4 = new Reader();
        filesReader4.readByBufferedReaderWriter();
    }
}


