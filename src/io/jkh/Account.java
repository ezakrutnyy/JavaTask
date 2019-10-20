package io.jkh;

import java.util.Date;

public class Account {

    String monthYear;

    Integer coldWater;

    Integer hotWater;

    Integer electricity;

    Integer drainageSystem;

    public Integer getColdWater() {
        return coldWater;
    }

    public void setColdWater(Integer coldWater) {
        this.coldWater = coldWater;
    }

    public Integer getHotWater() {
        return hotWater;
    }

    public void setHotWater(Integer hotWater) {
        this.hotWater = hotWater;
    }

    public Integer getElectricity() {
        return electricity;
    }

    public void setElectricity(Integer electricity) {
        this.electricity = electricity;
    }

    public Integer getDrainageSystem() {
        return drainageSystem;
    }

    public void setDrainageSystem(Integer drainageSystem) {
        this.drainageSystem = drainageSystem;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    @Override
    public String toString() {
        return "Account{" +
                "monthYear='" + monthYear + '\'' +
                ", coldWater=" + coldWater +
                ", hotWater=" + hotWater +
                ", electricity=" + electricity +
                ", drainageSystem=" + drainageSystem +
                '}';
    }
}
