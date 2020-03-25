package experiments.io;


import java.io.*;

public class Main {

    public static void main(String[] args) {
//        InputStream; (implements Closeable) -> {
//                  read()
//                  read(byte b[])
//                  read(byte b[], int off, int len)
//                  skip(long n)
//                  available()
//                  mark(int readlimit)
//                  reset()
//                  markSupported()
//            FileInputStream;
//            FilterInputStream; -> {
//                BufferedInputStream;
//                DataInputStream; (implements DataInput)
//            }
//            ByteArrayInputStream;
//            ObjectInputStream; (implements ObjectInput, ObjectStreamConstants)
//        }

//        OutputStream; (implements Closeable, Flushable) -> {
//            FileOutputStream;
//            FilterOutputStream; -> {
//                BufferedOutputStream;
//                DataOutputStream; (implements DataOutput)
//                PrintStream; (implements Appendable, Closeable)
//            }
//            ByteArrayOutputStream;
//            ObjectOutputStream; (implements ObjectOutput, ObjectStreamConstants)
//        }

//        RandomAccessFile (implements DataOutput, DataInput, Closeable)

//        Reader (implements Readable, Closeable) -> {
//            BufferedReader;
//            CharArrayReader;
//            InputStreamReader; -> {
//                FileReader;
//            }
//        }

//        Writer; (implements Appendable, Closeable, Flushable) -> {
//            BufferedWriter;
//            CharArrayWriter;
//            OutputStreamWriter; -> {
//                FileWriter;
//            }
//            PrintWriter;
//        }

    }

    private static void readFileInformation() {
//        try (FileInputStream in = new FileInputStream("file.txt")) {
        File file = new File("file.txt");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            int b;
            int count = 0;
            int half = (int) (file.length() / 2);

            while ((b = in.read()) > 0) {
                System.out.println((char) b);
                if (++count == half + 1) {
                    in.mark(half);
                }
            }

            System.out.println("--------------------");
            in.reset();

            while ((b = in.read()) > 0) {
                System.out.println((char) b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeIntoFile() {
        File file = new File("file.txt");
        try (BufferedWriter w = new BufferedWriter(new FileWriter(file))) {
            w.write("NUMBERS: ");
            w.flush();
            w.write('1');
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
