package guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Comparator;
import java.util.List;


/**
 * Created by Евгений on 15.11.2018.
 */
public class OrderingDemo {
    public static void main(String[] args) {

        final List<Student> students = Lists.newArrayList();
        students.add(new Student("Лаврентьев", 33, "Ярославль", 4));
        students.add(new Student("Артемьев", 31, "Иваново", 5));
        students.add(new Student("Бляхер", 17, "Морка", 6));
        students.add(new Student("Иванов", 12, "Москва", 1));
        students.add(new Student("Петров", 13, "Москва", 2));
        students.add(new Student("Сидоров", 10, "Киев", 3));
        students.add(new Student("Сидоров", 10, "Арх", 3));
        students.add(new Student("Сидоров", 9, "Уф", 3));
        students.add(new Student("Сидоров", 11, "Москва", 3));
        students.add(new Student("Сидоров", 12, "Москва", 3));
        System.out.println(students);

        final Ordering<Student> order = Ordering.from(Comparator.comparing(Student::getAge));

        // Проверим отсортированна ли коллекция
        System.out.println(order.isOrdered(students));

        // отсортировали по ID
        students.sort(order);
        System.out.println(students);

        // Проверим отсортированна ли коллекция
        System.out.println(order.isOrdered(students));

        // получим минимальное и максимальное значение
        Student minElement = order.min(students);
        Student maxElement = order.max(students);
        System.out.println("MIN element:" + minElement);
        System.out.println("MAX element:" + maxElement);

        // определеное кол-во элементов больше/меньше
        List<Student> leastOf = order.leastOf(students, 3);
        System.out.println("LeastOf " + leastOf);

        List<Student> greatestOf = order.greatestOf(students, 3);
        System.out.println("GreatestOf " + greatestOf);

        // SortedCopyList
        List<Student> elements = order.sortedCopy(students);
        System.out.println("SortedCopy" + elements);

        // Добавим еще несколько сортировок, в констукторе отчетов может поможет???
        List<Comparator<Student>> comparators = Lists.newArrayList();
        comparators.add(Comparator.comparing(Student::getAge));
        comparators.add(Comparator.comparing(Student::getName));
        comparators.add(Comparator.comparing(Student::getCity));

        Ordering<Student> multiOrder = Ordering.compound(comparators);
        students.sort(multiOrder);
        System.out.println(students);
    }
}


class Student {

    final private String name;

    final private Integer age;
    final private String city;
    final private int id;

    public String getName() {
        return name;
    }

    Integer getAge() {
        return age;
    }

    String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    Student(String name, Integer age, String city, Integer id) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.id = id;
    }
}