package lessons.java.lesson22.example7;

import java.io.IOException;

public class Main {

    static {}

    public static void main(String[] args) {
         class Game {

           void myMethod() {

               try(MyInputThread myInputThread = new MyInputThread()) {
                   throw new IllegalArgumentException();
               } catch (IllegalArgumentException e) {

               }
           }

         }
    }
}

 interface MyCustomClose extends AutoCloseable {
      void close() throws Exception;
 }

 class MyInputThread implements MyCustomClose {
  public void close() {
  }
 }