package streams;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Employee {
    private String name;
    private String city;
    private Integer old;


    public Employee(String name, String city, Integer old) {
        this.name = name;
        this.city = city;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) { this.old = old; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(city, employee.city) &&
                Objects.equals(old, employee.old);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, old);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("old", old)
                .add("name", name)
                .add("city", city)
                .toString();
    }
}