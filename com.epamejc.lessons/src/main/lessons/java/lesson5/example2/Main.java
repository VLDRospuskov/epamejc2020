package lessons.java.lesson5.example2;

public class Main {

    public static void main(String[] args) {
        Num o1 = new Num();
        Int o2 = new Int();
        LongInt o3 = new LongInt();
        Num o4 = new Int();

        Mathematica m1 = new Mathematica(o1);
        Mathematica m2 = new Mathematica(o2);
        Mathematica m3 = new Mathematica(o3);
        Mathematica m4 = new Mathematica(o4);
        Mathematica m5 = new Mathematica(o1, o2);
        Mathematica m6 = new Mathematica(o3, o2);
        Mathematica m7 = new Mathematica(o1, o4);//error
        Mathematica m8 = new Mathematica(o3, o4);//error

    }
}
