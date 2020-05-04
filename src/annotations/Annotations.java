package annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Евгений on 15.05.2018.
 */

public class Annotations{

    private static void trackUseCases(List<Integer> lst) {
        for (Method m : Annotations2.class.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println(uc.id());
                System.out.println(uc.description());
                lst.remove(new Integer(uc.id()));
            }

        }

        for (Integer k : lst) {
            System.out.println("Not removed"+k);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 44,45,46,47);
        trackUseCases(useCases);
    }
}

@Documented // Попадет в документацию
@Target(ElementType.METHOD) // Для чего применимо
@Retention(RetentionPolicy.RUNTIME) // На каком этапе выполняем
@Inherited // Распостраняется н только на метода основного класса но и потомков
@interface  UseCase {
    int id() default 0;
    String  description();
}


class Annotations2 {

    @UseCase(id = 45, description = "sss")
    void testAnnotate() {
     System.out.println("Test Annotations");
 }

    @UseCase(id = 47, description = "sss")
    public boolean validatePassword() {
     return false;
 }

}

// Add new in Java8
@FunctionalInterface
interface FunctionalIterfaceMap {
    String value();
}
