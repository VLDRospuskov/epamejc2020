package experiments.example2;

public class Main {

    public static void main(String[] args) {
        //создаем экземпляр внешнего класса.
        Outer outer = new Outer();
        outer.getX(); //It`s alive!
//        int innerX = Outer.Inner.getX(); //доступ только к статическим методам статического вложенного класса.
        //создаем экземпляр вложенного класса.
        Outer.Inner inner1 = new Outer().new Inner();
        Outer.Inner inner2 = outer.new Inner();

        //доступ к переменной вложенного класса.
        int x = inner1.getX();
        //внешнего класса.
        int x2 = inner1.getOuterX();
        //статическая пременная внешнего класса через внутренний.
        int y = inner1.getY();
        int outerY = Outer.y;

    }

}
