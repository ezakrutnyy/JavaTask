package cloneable;

import com.google.common.collect.Lists;

import java.util.List;

public class ClonableClassDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        SberBank sb = new SberBank("Новосибирск",1991, Lists.newArrayList("13","22","40"));
        SberBank sb2Clone = sb.clone();
        System.out.println(sb);
        System.out.println(sb2Clone);

        sb.setName("Москва");
        sb.setOld(77);
        sb.getPakUvisas().add("77");

        System.out.println(sb);
        System.out.println(sb2Clone);
    }
}


class SberBank implements Cloneable{

    @Override
    public String toString() {
        return "SberBank{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", pakUvisas=" + pakUvisas +
                '}';
    }

    public SberBank(String name, int old, List<String> pakUvisas) {
        this.name = name;
        this.old = old;
        this.pakUvisas = pakUvisas;
    }

    private String name;

    private int old;

    private List<String> pakUvisas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public List<String> getPakUvisas() {
        return pakUvisas;
    }

    public void setPakUvisas(List<String> pakUvisas) {
        this.pakUvisas = pakUvisas;
    }

    public SberBank clone () throws CloneNotSupportedException {
        // с глубоким копированием
        SberBank sb =  (SberBank) super.clone();
        sb.setPakUvisas(Lists.newArrayList(sb.getPakUvisas()));
        return sb;
    }
}
