package io.jkh;

import java.util.Date;

public class Account {

    Date date;

    Integer coldWater;

    Integer hotWater;

    Integer electricity;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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
}
