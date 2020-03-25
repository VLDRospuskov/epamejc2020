package experiments.example2;

public class Outer {

    private int x = 5;
    public static int y = 10;

    class Inner {

        private int x = 15;
        //что бы объявить статическую пременную во вложенном классе,
        //вложенный класс должен быть статическим.
//        private static int y = 20;

        //доступ к переменной вложенного класса.
        public int getX() {
            return x;
        }
        //доступ к приватной переменной внешнего класса.
        public int getOuterX() {
            return Outer.this.x;
        }
        //статические методы так же нуждаются в объявлении класса статическим.
//        public static int getY() {}

        //доступ к статической переменной внешнего класса.
        public int getY() {
            return Outer.y;
        }
    }
    //Внешний класс ничего не знает о внутренним.
//    public int getInner() {
//        return Inner.this.x;
//    }


    public int getX() {
        return x;
    }
}
