package interAndInnerClassesExample;

import java.util.GregorianCalendar;

/**
 * Created by Евгений on 15.07.2017.
 */
public class InterfaceCloneExample  {
    public static void main(String[] args) {
        Employee original = new Employee("Tester1",27000);
        original.setPayDay(1988,7,9);
        Employee copy = (Employee) original.clone();
        copy.setPayDay(1995,7,6);
        System.out.println("Оригинал "+original);
        System.out.println("Копия "+copy);
    }
}

//Пример с глубоким клонированием
class Employee implements Cloneable {
    private String name;
    private double salary;
    private GregorianCalendar payDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setPayDay(int year, int month, int day) {
        payDay = new GregorianCalendar(year,month-1,day);
    }

    public Object clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.payDay = (GregorianCalendar) payDay.clone();
            return cloned;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", payDay=" + payDay.getTime() +
                '}';
    }
}