package cloneable;

public class HeroThree {

    public static void main(String[] args) {
        HeroThree hero = new HeroThree();
        hero.setName("Hulk");
        hero.setSkill("Hit");
        hero.setPower(980);
        System.out.println("Hero: " + hero + " hash: "+hero.hashCode());

        HeroThree heroCopy = hero.getInstance();
        System.out.println("Hero: " + heroCopy + " hash: "+heroCopy.hashCode());
    }

    private HeroThree() {

    }

    public HeroThree getInstance() {
        HeroThree hero = new HeroThree();
        hero.setName(this.name);
        hero.setSkill(this.skill);
        hero.setPower(this.power);
        return hero;
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
        return "HeroThree{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", power=" + power +
                '}';
    }

}
