package homeworks.homework2.ImmutableClass;

public final class ImmutableDinosaur {

    private final int AGE;
    private final String KIND;
    private final String NAME;
    private final double SIZE;


    public ImmutableDinosaur(int age, String kind, double size, String name) {
        System.out.println("I'm angry dinosaur!. My name is " + name + " !!!");
        this.AGE = age;
        this.KIND = kind;
        this.SIZE = size;
        this.NAME = name;

    }

    public int getAGE() {
        return AGE;
    }

    public String getKIND() {
        return KIND;
    }

    public String getNAME() {
        return NAME;
    }

    public double getSIZE() {
        return SIZE;
    }
    public ImmutableDinosaur changeNAME(String newName){
        return new ImmutableDinosaur(AGE, KIND, SIZE, newName);

    }
}
