package generics;

import com.google.common.collect.Lists;

import java.util.List;

public class WildCard {

    public static void main(String[] args) {
        List<Dog> dogs = Lists.newArrayList();
        dogs.add(new Dog("111"));
        dogs.add(new Dog("222"));
        dogs.add(new Dog("333"));
        produce(dogs);
        consume(dogs);


        consume(Lists.newArrayList(new Object()));


        List<Spaniel> spaniels = Lists.newArrayList(new Spaniel("jina", "russia"));

        copyAnimal(dogs, spaniels);
        System.out.println(dogs);
        System.out.println(spaniels);
    }

    /*
     * ? extends B, ограничение сверху, служит только как источник данных
     * */
    static void produce(List<? extends Animal> dogs) {
        System.out.println("*************produce*************");
        for (Animal dog : dogs) {
            System.out.println(dog);
        }
    }

    /*
     * ? extends B, ограничение снизу, служит только как потребитель данных
     * */
    static void consume(List<? super Dog> dogs) {
        System.out.println("*************consume*************");
        dogs.add(new Spaniel("sss", "sss"));
        System.out.println(dogs);
    }

    public static <T> void copyAnimal(List<? super T> dest, List<? extends T> src) {
        System.out.println("*************copy*************");
        dest.addAll(src);
    }
}

class Animal {
    String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    public Dog(String passport) {
        this.passport = passport;
    }

    String passport;

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}

class Spaniel extends Dog {
    String country;

    public Spaniel(String passport, String country) {
        super(passport);
        this.country = country;
    }

    @Override
    public String toString() {
        return "Spaniel{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}