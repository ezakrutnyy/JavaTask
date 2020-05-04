package cloneable;

public class HeroTwo {

    public static void main(String[] args) {
        HeroTwo hero = new HeroTwo();
        hero.setName("Captain America");
        hero.setSkill("Stealth");
        hero.setPower(345);
        System.out.println("Hero: " + hero + " hash: "+hero.hashCode());

        HeroTwo heroCopy = new HeroTwo(hero);
        System.out.println("Hero: " + heroCopy + " hash: "+heroCopy.hashCode());
    }

    public HeroTwo(HeroTwo heroTwo) {
        this.name = heroTwo.getName();
        this.skill = heroTwo.getSkill();
        this.power = heroTwo.getPower();
    }

    public HeroTwo() {
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
        return "HeroTwo{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", power=" + power +
                '}';
    }

}
