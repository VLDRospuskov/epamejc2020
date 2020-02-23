package homeworks.java.hw7;

public class Main {

    public static void main(String[] args) {
//        FilesWriter fileWriter = new FilesWriter();
//        FilesReaderAndRewriter filesReaderAndRewriter = new FilesReaderAndRewriter();
//
//        fileWriter.writeByBytes();
//        filesReaderAndRewriter.readAndRewriteByBytes();

//        FilesWriter fileWriter2 = new FilesWriter();
//        fileWriter2.writeWithBuffer();
//
//        FilesReaderAndRewriter filesReaderAndRewriter2 = new FilesReaderAndRewriter();
//        filesReaderAndRewriter2.readAndRewriteByBuffer();

//        FilesWriter filesWriter3 = new FilesWriter();
//        filesWriter3.writeFileByFileWriter();
//
//        FilesReaderAndRewriter filesReaderAndRewriter3 = new FilesReaderAndRewriter();
//        filesReaderAndRewriter3.readAndRewriteByFileReaderWriter();

        FilesWriter filesWriter4 = new FilesWriter();
        filesWriter4.writeFileWithBufferedWriter();

        FilesReaderAndRewriter filesReaderAndRewriter4 = new FilesReaderAndRewriter();
        filesReaderAndRewriter4.readAndRewriteByBufferedReaderWriter();

    }
}
