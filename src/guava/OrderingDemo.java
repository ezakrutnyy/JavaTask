package guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Евгений on 15.11.2018.
 */
public class OrderingDemo {
    public static void main(String[] args) {
        List<Students> numbers = Lists.newArrayList();
        numbers.add(new Students("Лаврентьев", 33, "Ярославль", 4));
        numbers.add(new Students("Артемьев", 31, "Иваново", 5));
        numbers.add(new Students("Бляхер", 17, "Морка", 6));
        numbers.add(new Students("Иванов", 12, "Москва", 1));
        numbers.add(new Students("Петров", 13, "Москва", 2));
        numbers.add(new Students("Сидоров", 10, "Киев", 3));
        numbers.add(new Students("Сидоров", 10, "Арх", 3));
        numbers.add(new Students("Сидоров", 9, "Уф", 3));
        numbers.add(new Students("Сидоров", 11, "Москва", 3));
        numbers.add(new Students("Сидоров", 12, "Москва", 3));


        Ordering order = Ordering.natural();

        System.out.println(numbers);


        // Проверим отсортированна ли коллекция
        System.out.println(order.isOrdered(numbers));

        // отсортировали по ID
        Collections.sort(numbers,order);
        System.out.println(numbers);

        // получим минимальное и максимальное значение
        Students min = (Students) order.min(numbers);
        Students max = (Students) order.max(numbers);
        System.out.println("MIN element:"+min);
        System.out.println("MAX element:"+max);

        // определеное кол-во элементов больше/меньше
        List<Students> leastOf = order.leastOf(numbers,3);
        System.out.println("LeastOf "+leastOf);

        List<Students> greatestOf = order.greatestOf(numbers,3);
        System.out.println("GreatestOf "+greatestOf);

        // SortedCopyList
        List<Students> elems = order.sortedCopy(numbers);
        System.out.println("SortedCopy"+elems);

//        // Добавим еще несколько сортировок, в констукторе отчетов может поможет???
//        List<Comparator> comparators = Lists.newArrayList();
//        comparators.add(new ComparatorName());
//        comparators.add(new ComparatorAge());
//        comparators.add(new ComparatorCity());
//
//        Ordering multiOrder = Ordering.compound(comparators);
//        Collections.sort(numbers, multiOrder);
//        System.out.println(numbers);
    }
}



class Students implements Comparable{

    final private String name;

    final private Integer age;
    final private String city;
    final private int id;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Students(String name, Integer age, String city, Integer id) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Students st = (Students) o;

        return this.getId().compareTo(st.getId());
    }

}

class ComparatorAge implements Comparator<Students>
{
    public int compare(Students o1, Students o2)
    {
        return o1.getAge().compareTo(o2.getAge());
    }
}

class ComparatorName implements Comparator<Students>
{
    public int compare(Students o1, Students o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}

class ComparatorCity implements Comparator<Students>
{
    public int compare(Students o1, Students o2)
    {
        return o1.getCity().compareTo(o2.getCity());
    }
}