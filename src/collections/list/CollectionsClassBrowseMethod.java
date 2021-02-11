package collections.list;

import java.util.*;

/**
 * Created by Евгений on 01.05.2018.
 */
public class CollectionsClassBrowseMethod {
    public static void main(String[] args) {
        final List<String> lst1 = new ArrayList<>(Arrays.asList("Watermelon", "Orange", "Banana", "Apple", "Melon"));

        System.out.println("------------------------comparator---------------------");
        // 1. sorting - прямая сортировка
        Collections.sort(lst1);
        System.out.println(lst1);

        // 2. binary - бинарный поиск
        System.out.println("------------------------binarySearch---------------------");
        System.out.println(Collections.binarySearch(lst1, "Melon"));

        // 3. reverse - обратная сортировка коллекции
        System.out.println("------------------------reverse---------------------");
        Collections.reverse(lst1);
        System.out.println(lst1);

        System.out.println("------------------------shuffle---------------------");
        // 4. shuffle - случайная перетасовка элементов коллекции
        Collections.shuffle(lst1, new Random());
        System.out.println(lst1);
        Collections.sort(lst1);

        System.out.println("------------------------swap---------------------");
        // 5. swap - перестановка элементов в коллекции по индексам
        System.out.println("before swap collections: " + lst1);
        Collections.swap(lst1, 0, lst1.size() - 1);
        System.out.println(lst1);

        System.out.println("------------------------fill---------------------");
        // 6. fill - заполняет все элементы, переданым объектом
        //Collections.fill(lst1,"Banana");
        //System.out.println(lst1);

        // 7. copy - копирование значений одного массива в другой
        // Внимание!!! - копирование производится в воответствующие индексы приемника
        System.out.println("------------------------copy---------------------");
        final List<String> lst2 = new ArrayList<String>(Arrays.asList("Cherry", "Grapes"));
        Collections.copy(lst1, lst2);
        System.out.println(lst1);

        // 8. min - поиск минимального элемента в коллекции
        System.out.println("------------------------min---------------------");
        final String minStr = Collections.min(lst1);
        System.out.println(minStr);

        // 9. max - поиск максимального элемента в коллекции
        System.out.println("------------------------max---------------------");
        final String maxStr = Collections.max(lst1);
        System.out.println(maxStr);

        // 10. rotate - смещение каждого элемента на кол-во шагов в коллекции
        System.out.println("----------------------rotate---------------------");
        System.out.println("Before rotate: " + lst1);
        Collections.rotate(lst1, 2);
        System.out.println(lst1);

    }
}
