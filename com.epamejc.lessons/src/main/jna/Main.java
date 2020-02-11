package jna;

//import com.sun.jna.Library;
//import com.sun.jna.Native;
//
//public class Main {
//
//    public interface Kernel32 extends Library {
//        boolean Beep(int frequency, int duration);
//    }
//
//    private static Kernel32 kernel32 = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
//
//    private static void toMorseCode(String letter) throws Exception {
//        for (byte b : letter.getBytes()) {
//            kernel32.Beep(1200, ((b == '.') ? 150 : 450));
//            Thread.sleep(150);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        String helloWorld[][] = {
//                {"....", ".", ".-..", ".-..", "---"}, // HELLO
//                {".--", "---", ".-.", ".-..", "-.."}  // WORLD
//        };
//        for (String word[] : helloWorld) {
//            for (String letter : word) {
//                toMorseCode(letter);
//                Thread.sleep(450);
//            }
//            Thread.sleep(1000);
//        }
//    }
//}
//
