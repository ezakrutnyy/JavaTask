package objects.constructor;

/**
 * Created by Евгений on 29.10.2017.
 */
public class ManyConstructorDemo {
    public static void main(String[] args) {
        ManyConstructorEmployee[] staff = new ManyConstructorEmployee[3];
        staff[0] = new ManyConstructorEmployee("Harry", 40000);
        staff[1] = new ManyConstructorEmployee(60000);
        staff[2] = new ManyConstructorEmployee();
        for (ManyConstructorEmployee e : staff) {
            e.raiseSalary(100).raiseSalary(10);
            System.out.println("name=" + e.getName() + ",id=" + e.getId()
                    + ",salary=" + e.getSalary());
        }

    }
}

class ManyConstructorEmployee {
    public ManyConstructorEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public ManyConstructorEmployee(double s) {
        this("Employee #" + nextId, s);
    }

    public ManyConstructorEmployee() {

    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    private static int nextId = 1;

    private int id;
    private String name = "";
    private double salary;

    {
        id = nextId;
        nextId++;
    }

    public ManyConstructorEmployee raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
        return this;
    }

}