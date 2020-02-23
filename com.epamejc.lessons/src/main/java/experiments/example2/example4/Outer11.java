package experiments.example2.example4;

public class Outer11 {

    public void meth() {
        Inner1.method();
    }

    static class Inner1 {
        public static void method() {	}
    }
    
}


class Main5 {

    public static void main(String[] args) {
        Outer11.Inner1.method();
    }

}