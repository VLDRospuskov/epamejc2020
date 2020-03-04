package homework.homework3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CustomAnnotationProcessor {
    public static void process(Object instance){
        Class<?> aClass = instance.getClass();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        if (declaredConstructors.length == 0) {
            throw new IllegalArgumentException("No declared constructors");
        }

        CustomAnnotation annotation = declaredConstructors[0].getAnnotation(CustomAnnotation.class);

        if (annotation == null){
            throw new IllegalArgumentException("Constructor has no annotation");
        }

        try {
            Field nameField = aClass.getField("name");
            nameField.setAccessible(true);
            nameField.set(instance, annotation.name());

            Field ageField = aClass.getField("age");
            ageField.setAccessible(true);
            ageField.set(instance, annotation.age());
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("No Such Field");
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Illegal Access Exception");
        }
    }
}
