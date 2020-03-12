package lessons.lesson12.example11;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    
    @SneakyThrows
    public static void main(String[] args) {
        OutputStream stdout = System.out;
        stdout.write(104); // ASCII 'h'
        stdout.flush();
        stdout.write('\n');
        
        byte[] b1 = new byte[5];
        InputStream stdin1 = System.in;
        stdin1.read(b1);
        System.out.write(b1);
        System.out.write('\n');
        System.out.flush();
        
        InputStream stdin2 = System.in;
        byte[] b2 = new byte[stdin2.available()];
        int len = b2.length;
        for (int i = 0; i < len; i++) {
            b2[i] = (byte) stdin2.read();
        }
        System.out.println(b2[0] + " " + b2[1]);
        System.out.flush();
    }
    
}
