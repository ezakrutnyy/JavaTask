package io.jkh;

import java.math.BigDecimal;
import java.util.Date;

public class Tariff {

    Date date;

    BigDecimal coldWater;

    BigDecimal hotWater;

    BigDecimal drainageSystem;

    BigDecimal electricity;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getColdWater() {
        return coldWater;
    }

    public void setColdWater(BigDecimal coldWater) {
        this.coldWater = coldWater;
    }

    public BigDecimal getHotWater() {
        return hotWater;
    }

    public void setHotWater(BigDecimal hotWater) {
        this.hotWater = hotWater;
    }

    public BigDecimal getDrainageSystem() {
        return drainageSystem;
    }

    public void setDrainageSystem(BigDecimal drainageSystem) {
        this.drainageSystem = drainageSystem;
    }

    public BigDecimal getElectricity() {
        return electricity;
    }

    public void setElectricity(BigDecimal electricity) {
        this.electricity = electricity;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "date=" + date +
                ", coldWater=" + coldWater +
                ", hotWater=" + hotWater +
                ", drainageSystem=" + drainageSystem +
                ", electricity=" + electricity +
                '}';
    }
}