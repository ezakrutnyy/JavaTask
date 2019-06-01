package streams;

import com.google.common.base.MoreObjects;

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
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("old", old)
                .add("name", name)
                .add("city", city)
                .toString();
    }
}