package collections.map;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Set;

public class EqualsAndHashCode {
    public static void main(String[] args) {

        final Set<Employee> employes = Sets.newHashSet();
        Employee employee1 = new Employee(1, "Ivanov", "male", 33);
        Employee employee2 = new Employee(2, "Petrova", "female", 22);
        Employee employee3 = new Employee(1, "Ivanov", "male", 33);
        employes.add(employee1);
        employes.add(employee2);
        employes.add(employee3);

        System.out.println("Employee list " + employes);
    }
}


class Employee {

    public Employee(long id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    private long id;

    private String name;

    private String sex;

    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return new EqualsBuilder()
                .append(id, employee.id)
                .append(age, employee.age)
                .append(name, employee.name)
                .append(sex, employee.sex)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(sex)
                .append(age)
                .toHashCode();
    }
}