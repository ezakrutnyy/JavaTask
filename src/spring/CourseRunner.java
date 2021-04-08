package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CourseRunner {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        while (true) {
            context.getBean(CourseShower.class).showCourse();
            Thread.sleep(500);
        }
    }
}
