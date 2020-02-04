package main.lessons.lesson8.example4;

public interface InterfaceWithClass {

    int x = 10;

    class InnerInInterface {

        public void meth() {
            System.out.println("x=" + x);
        }

    }

}
