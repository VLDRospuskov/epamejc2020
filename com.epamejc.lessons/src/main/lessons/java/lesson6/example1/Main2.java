package lessons.java.lesson6.example1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Main2 {

    public static void main(String[] args) {
        Cat cat = new Cat(1, "barsik");
        Class<? extends Cat> aClass = cat.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Method[] declaredMethods = aClass.getDeclaredMethods();

        for (Field field: declaredFields) {
            System.out.println(field);
            field.setAccessible(true);
            Type genericType = field.getGenericType();
            System.out.println(genericType);
            if (genericType.getTypeName().equals("int")) {
                try {
                    field.set(cat, 10);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(cat);
//        for (Method method: declaredMethods) {
//            System.out.println(method);
//        }
    }
}
