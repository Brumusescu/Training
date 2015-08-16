package com.endava.brokers;

/**
 * Created by dbrumusescu on 8/16/2015.
 */
public class Subscription extends Product {
    private int months;

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getTotalPrice () {
        return this.getPrice() * months;
    }
}
