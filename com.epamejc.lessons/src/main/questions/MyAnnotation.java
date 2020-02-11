package questions;

import java.lang.annotation.*;


@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name();

    String age();
}
