package homework.homework2;

public final class Immutable {

    private final int immutableField;

    public Immutable(int value) {
        immutableField = value;
    }

    public int getValue(){
        return immutableField;
    }

    //Can not assign a value to final variable!
//    public void setValue(int value){
//        immutableField = value;
//    }

}
