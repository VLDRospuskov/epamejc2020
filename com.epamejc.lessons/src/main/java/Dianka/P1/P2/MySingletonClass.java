package Dianka.P1.P2;

public final class MySingletonClass {
    private MySingletonClass() {
    }


    private static MySingletonClass instance;

    static MySingletonClass factoryMethod(){
        if (instance == null) instance = new MySingletonClass();
        return instance;
    }
}
enum EnumSingleton {

    INSTANCE("Initial class info");

    private String info;

    private EnumSingleton(String info) {
        this.info = info;
    }

    public EnumSingleton getInstance() {
        return INSTANCE;
    }
}