package homework.homework6;

public class Main {
    public static void main(String[] args) {
        ClassWithAnnotation instance = new ClassWithAnnotation();
        CustomAnnotationProcessor.process(instance);
        System.out.println(instance.getName() + instance.getAge());
    }
}
