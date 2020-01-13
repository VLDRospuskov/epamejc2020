package homeworks.homework2.ImmutableClass;

public class Main {
    public static void main(String[] args) {
        ImmutableDinosaur firstDino = new ImmutableDinosaur(3000000, "Tyrannosaurs", 10.3, "Cutie:)");
        System.out.println(firstDino.getAGE());
        System.out.println(firstDino.getKIND());
        System.out.println(firstDino.getNAME());
        System.out.println(firstDino.getSIZE());

        ImmutableDinosaur secondDino = firstDino.changeNAME("Godzilla");
        System.out.println(secondDino.getNAME()); //name changing creates new object

    }
}
