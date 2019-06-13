package reflections;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        ReflectionEmployee employee = new ReflectionEmployee("test",3);
        Class ref = employee.getClass();

        Class ref2 = Class.forName("reflections.ReflectionEmployee");

        System.out.println(ref.getSimpleName());
        System.out.println(ref2.getName());


        System.out.println("*********************Field****************");
        Field[] fields = ref.getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("*********************Constructors****************");
        Constructor[] constructors = ref.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        System.out.println("*********************Methods****************");
        Method[] methods = ref.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);

        /*
        * Загрузка ресурсов
        * */
        InputStream inputStream = ref.getResourceAsStream("config.txt");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println("Parameters from config: "+s);
            }
        } catch (Exception ex) {
            System.out.println("Error"+ ex);
        }



        
    }
}



class ReflectionEmployee {
    private String name;
    private int old;

    public ReflectionEmployee(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReflectionEmployee that = (ReflectionEmployee) o;
        return old == that.old &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, old);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}