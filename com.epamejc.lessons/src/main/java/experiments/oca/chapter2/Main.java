package experiments.oca.chapter2;

public class Main {

    public static void main(String[] args) {
//        арифметически операции над числами.
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4L;
        float f = 5.0f;
        double d = 6.0d;
        char c = '\u0000';

        int bb = b + b;
        byte bb1 = (byte) (b + b);
        int ss = s + s;
        short ss1 = (short) (s + s);
        int sb = b + s;
        long li = l + i;
        int li1 = (int) (l + i);
        float fi = i + f;
        double di = i + d;
        int ic = i + c;

//        boolean нельзя складывать и вычитать, итд. к строкам можно применять только + (конкатенация или склеивание)
        String str = ""; // пустая строка
        str += "hello";
        str += c;
        str += i;
        str += true;
//        унарные + и - просто делают число позитивным или негативным. +1 или -1
//        инкремент и декрмент (++ --) применмы только к численным переменным.
        i++;
        i--;
        System.out.println(i);
        System.out.println(++i); // префиксный инкремент. вначале увеличит перменную, затем выведет на экран. 4
        System.out.println(i--); // постфиксный декремент. вначале выведет на экран, потом уменьшит. 4
        System.out.println(--i); // 2
//        унарный оператор отрицания ! не. применим только к булевым выражениям.
        boolean bool = false;
        boolean bool2 = !bool; // true
        boolean bool3 = !bool2; // false

    }

}

//операторы (в порядке убывания приоритета)
// ex++ ex--
// ++ex --ex
// unary + - !
// * / %
// + -
// << >> >>>
// == !=
// & ^ |
// && ||
// expr ? result1 : result2
// = += -= *= /= %= &= ^= |= <<= >>= >>>=
//
//
//