package generics;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GarageGenericDemo {

    public static void main(String[] args) throws IOException {
        Garage<Car, Motorcycle> garage = new Garage<>();
        garage.setVehicle1(new Car("audi-a1"));
        garage.setVehicle2(new Motorcycle("BMW-20550"));

        Car carNew = garage.getVehicle1();
        System.out.println(carNew.getName());

        Motorcycle motoNew = garage.getVehicle2();
        System.out.println(motoNew.getName());

        System.out.println("**********************************");

        /* FixedSizedGarage - generics arrays */
        FixedSizedGarage<Car> arrs = new FixedSizedGarage<>(3);
        arrs.set(0, new Car("Ford-s200"));
        arrs.set(1, new Car("Ford-s300"));
        arrs.set(2, new Car("Ford-s400"));
        Car car = arrs.get(2);
        System.out.println(car.getName());

        System.out.println("**********************************");

        /* DynamicSizedGarage - generics collections */
        DynamicSizedGarage<Motorcycle> dynamicCollection = new DynamicSizedGarage<>();
        dynamicCollection.add(new Motorcycle("Honda CBR500R"));
        dynamicCollection.add(new Motorcycle("Harley-Davidson"));
        Motorcycle motorcycle1 = dynamicCollection.get(0);
        Motorcycle motorcycle2 = dynamicCollection.get(1);
        System.out.println(motorcycle1.getName());
        System.out.println(motorcycle2.getName());

        System.out.println("**********************************");

        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Toyota"));
        carsList.add(new Car("Jaguar"));
        carsList.add(new Car("BMW"));

        Set<Car> carsSet = new HashSet<>();
        carsSet.add(new Car("Skoda"));
        carsSet.add(new Car("Volwswagen"));
        carsSet.add(new Car("Renault"));

        List<Track> tracks = Lists.newLinkedList();
        tracks.add(new Track("Kamaz"));
        tracks.add(new Track("Volvo"));

        DynamicSizedGarage<Car> dynamics = new DynamicSizedGarage<>();
        dynamics.add(new Car("Aston Martin"));
        dynamics.addAll(carsList);
        dynamics.addAll(carsSet);
        dynamics.addAll(tracks);


        Consumer<Vehicle> vehicleConsumer = vehicle -> System.out.println(vehicle.getName());
        dynamics.forEach(vehicleConsumer);

        System.out.println("**********************************");
        List<Car> carsList2 = new ArrayList<>();
        carsList2.add(new Car("LADA"));
        carsList2.add(new Car("NIVA"));
        dynamics.replaceWith(carsList2);
        dynamics.forEach(vehicleConsumer);

        System.out.println("**********************************");
        System.out.println(dynamics.filter(elem -> elem.getName().equals("Skoda")));

        System.out.println("**********************************");
        Supplier<Car> fillData = () -> new Track("RIO DOR");
        dynamics.fill(fillData, 5);
        dynamics.forEach(vehicleConsumer);

        System.out.println("**********************************");

        Comparator<Car> carName = Comparator.comparing(Car::getName);
        dynamics.sort(carName);
        dynamics.forEach(vehicleConsumer);

        System.out.println("**********************************");
        //dynamics.map(carName);
        dynamics.forEach(vehicleConsumer);


    }
}

class DynamicSizedGarage<T extends Vehicle> {

    private List<T> vehicles;

    public DynamicSizedGarage() {
        this.vehicles = new ArrayList<>();
    }

    public void add(T t) {
        vehicles.add(t);
    }

    public void addAll(Collection<? extends T> collections) {
        collections.forEach(this::add);
    }

    public T get(int index) {
        return vehicles.get(index);
    }

    public void forEach(Consumer<? super T> consumer) {
        for (T vehicle : vehicles) {
            consumer.accept(vehicle);
        }
    }

    public void replaceWith(List<? extends T> list) {
        final int listSize = list.size();
        final int size = vehicles.size();
        vehicles.subList(0, Math.min(listSize, size)).clear();
        vehicles.addAll(0, list);
    }


    public List<T> filter(Predicate<? super T> predicate) {
        List<T> res = Lists.newArrayList();
        for (T vehicle : vehicles) {
            if (predicate.test(vehicle)) {
                res.add(vehicle);
            }
        }
        return res;
    }

    public void fill(Supplier<? extends T> supplier, int size) {
        for (int i = 0; i < size; i++) {
            vehicles.add(supplier.get());
        }
    }

    public <U> List<U> map(Function<? super T,? extends U> function) {
        List<U> result = Lists.newArrayList();
        for (T vehicle : vehicles) {
            result.add(function.apply(vehicle));
        }
        return result;
    }

    public <U extends T> void addIf(
            List<? extends U> list, BiPredicate<? super T, ? super U> predicate) {
        List<U> candidatesToAdd = new ArrayList<>();
        Iterator<? extends U> it1 = list.iterator();
        Iterator<? extends T> it2 = vehicles.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            U u = it1.next();
            T t = it2.next();
            if (predicate.test(t, u)) {
                candidatesToAdd.add(u);
            }
        }
        addAll(candidatesToAdd);
    }

    public void merge(DynamicSizedGarage<? extends T> garage) {
        vehicles.addAll(garage.vehicles);
    }

    public void sort(Comparator<? super T> comparator) {
        vehicles.sort(comparator);
    }

}

class FixedSizedGarage<T extends Vehicle> {

    private T[] vehicles;

    @SuppressWarnings("unchecked")
    FixedSizedGarage(int size) {
        vehicles = (T[]) new Vehicle[size];
    }

    public T get(int index) {
        return vehicles[index];
    }

    public void set(int index, T vehicle) {
        this.vehicles[index] = vehicle;
    }

}
class Garage<T extends Vehicle, U extends Vehicle> {

    private T vehicle1;

    private U vehicle2;


    public Garage() {
    }

    public Garage(T vehicle1, U vehicle2) {
        this.vehicle1 = vehicle1;
        this.vehicle2 = vehicle2;
    }

    public T getVehicle1() {
        return vehicle1;
    }

    public void setVehicle1(T vehicle1) {
        this.vehicle1 = vehicle1;
    }

    public U getVehicle2() {
        return vehicle2;
    }

    public void setVehicle2(U vehicle2) {
        this.vehicle2 = vehicle2;
    }
}

class Vehicle {

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }

    public Vehicle(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }
}

class Track extends Car {
    public Track(String name) {
        super(name);
    }
}


class Motorcycle extends Vehicle {

    public Motorcycle(String name) {
        super(name);
    }
}