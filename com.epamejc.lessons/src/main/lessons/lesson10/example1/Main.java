package main.lessons.lesson10.example1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        try {
//            int sum = 10 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println("CANT / ZERO");
//        } finally {0
//            System.out.println("FINNALY");
//        }
//        method1();
        method3("0");
    }

    public static void method1() {
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method2() throws Exception {
        throw new Exception();
    }

    /**
     *
     * @param str
     * @throws NumberFormatException - dsgh
     * @throws ArithmeticException - sdfghj
     */
    public static void method3(String str) throws NumberFormatException, ArithmeticException {
      try {
          Integer integer = Integer.valueOf(str);
          int sum = 10 / integer;
//      } catch (NumberFormatException e) {
//          System.err.println("WRONG NUMBER FORMAT");
//      } catch (ArithmeticException e) {
//          System.err.println("CANT / ZERO");
//      }
      } catch (Exception e1) {

      }
    }

}
