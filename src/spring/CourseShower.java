package spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("periodical")
public class CourseShower {

    private int course = new Random().nextInt(100);

    void showCourse() {
        System.out.println("Текуший курс = " + course);
    }

}
