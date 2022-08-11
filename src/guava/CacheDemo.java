package guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import streams.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Евгений on 30.11.2018.
 */
public class CacheDemo {
    public static void main(String[] args) {

        LoadingCache<String, Employee> employeeCache =
                CacheBuilder.newBuilder()
                        .maximumSize(100)
                        .expireAfterAccess(1, TimeUnit.MINUTES)
                        .build(new CacheLoader<String, Employee>() {
                            @Override
                            public Employee load(String empId) {
                                return getFromDataBase(empId);
                            }
                        });

        try {
            System.out.println("INVOCATION #1");
            System.out.println(employeeCache.get("1"));
            System.out.println(employeeCache.get("2"));
            System.out.println(employeeCache.get("3"));

            System.out.println("INVOCATION #2");
            System.out.println(employeeCache.get("1"));
            System.out.println(employeeCache.get("2"));
            System.out.println(employeeCache.get("3"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static Employee getFromDataBase(String empId) {
        Employee e1 = new Employee("Iv", "Finance", 1);
        Employee e2 = new Employee("Ax", "IT", 2);
        Employee e3 = new Employee("Sg", "President", 3);


        Map<String, Employee> database = new HashMap<String, Employee>();
        database.put("1", e1);
        database.put("2", e2);
        database.put("3", e3);

        System.out.printf("Database hit for " + empId);
        return database.get(empId);
    }
}


