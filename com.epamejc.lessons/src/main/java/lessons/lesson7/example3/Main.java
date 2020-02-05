package lessons.lesson7.example3;

public class Main {

    public static void main(String[] args) {
//         Mark<String> ms = new Mark<String>(“7”);
        //ошибка компиляции
        Mark<Double> md = new Mark<Double>(71.4D);//71.5d
        System.out.println(md.sameAny(md));

        Mark<Integer> mi = new Mark<Integer>(71);
        System.out.println(md.sameAny(mi));
        System.out.println(md.sameAny(md));
        System.out.println(mi.sameAny(mi));
        //md.same (mi); //ошибка компиляции, потому что требуется Double
        md.same(md);

        System.out.println(md.roundMark());
    }
}


