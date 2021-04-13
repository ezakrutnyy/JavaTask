package spring.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InjectRandomInt {

    int min();

    int max();
}
