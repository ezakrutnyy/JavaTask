package cloneable;

public class HeroOne implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {
        HeroOne hero = new HeroOne();
        hero.setName("Batman");
        hero.setSkill("Flying");
        hero.setPower(750);
        System.out.println("Hero: " + hero + " hash: "+hero.hashCode());

        HeroOne heroCopy = hero.clone();
        System.out.println("Hero: " + heroCopy + " hash: "+hero.hashCode());
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
    public HeroOne clone() throws CloneNotSupportedException {
        return (HeroOne) super.clone();
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
