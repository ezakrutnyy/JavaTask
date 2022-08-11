package generics;

import com.google.common.collect.Lists;
import streams.Employee;
import streams.Manager;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class GenericDemoExample {
    public static void main(String[] args) {

        List<Object> lst = Lists.newArrayList();
        lst.add(new Employee("aa", "bb", 3));
        lst.add(new Manager("aa", "bb", 3, BigDecimal.ZERO));
        System.out.println(lst);

        Object[] employes = new Object[2];
        employes[0] = new Employee("aa", "bb", 3);
        employes[1] = new Manager("aa", "bb", 3, BigDecimal.ZERO);
        System.out.println(Arrays.toString(employes));


        /*
         * Создвние Generic класса
         * */
        MyGeneric<String, Integer> myGen = new MyGeneric<>("aaaa", 3);
        myGen.printKey();


        /*
         * Создание Generic метода
         * */
        System.out.println(lst);

    }
}


class MyGeneric<K, V extends Number> {

    private K key;
    private V value;

    public MyGeneric(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void printKey() {
        K k = this.key;
        System.out.println(k.toString());
    }


}
