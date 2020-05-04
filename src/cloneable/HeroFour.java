package cloneable;

import java.lang.reflect.Field;

public class HeroFour {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        HeroFour hero = new HeroFour();
        hero.setName("Rosomaha");
        hero.setSkill("Predatory");
        hero.setPower(500);
        System.out.println("Hero: " + hero + " hash: "+hero.hashCode());

        HeroFour heroCopy = copy(hero);
        System.out.println("Hero: " + heroCopy + " hash: "+heroCopy.hashCode());
    }

    public static HeroFour copy(Object obj) throws IllegalAccessException, InstantiationException {
        Class<?> cl = obj.getClass();
        Object clone = cl.newInstance();
        for (Field field : cl.getDeclaredFields()) {
            field.setAccessible(true);
            field.set(clone, field.get(obj));
        }
        return (HeroFour) clone;
    }

    private String name;

    private String skill;

    private int power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "HeroFour{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", power=" + power +
                '}';
    }
}
