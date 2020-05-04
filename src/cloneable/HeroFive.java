package cloneable;

import java.io.*;
import java.util.Objects;
import java.util.Optional;

public class HeroFive implements Serializable{

    public static void main(String[] args) {
        HeroFive hero = new HeroFive();
        hero.setName("Tor");
        hero.setSkill("Hit");
        hero.setPower(600);
        System.out.println("Hero: " + hero + " hash: "+hero.hashCode());

        copy(hero).ifPresent(heroFive -> System.out.println("Hero: " + heroFive + " hash: "+heroFive.hashCode()));
    }

    public static Optional<HeroFive> copy(HeroFive hero) {
        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
        try(ObjectOutputStream out = new ObjectOutputStream(byteOutput)) {
            out.writeObject(hero);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        HeroFive heroClone = null;
        try(ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteOutput.toByteArray()))) {
            heroClone = (HeroFive) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            byteOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Objects.isNull(heroClone) ? Optional.empty() : Optional.of(heroClone);
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
        return "HeroOne{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", power=" + power +
                '}';
    }

}