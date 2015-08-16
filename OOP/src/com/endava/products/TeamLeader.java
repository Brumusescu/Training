package com.endava.products;

import java.util.List;

/**
 * Created by dbrumusescu on 8/16/2015.
 */
public class TeamLeader extends Salesman {
    private List <Salesman> salesmanList;

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void setSalesmanList(List<Salesman> salesmanList) {
        this.salesmanList = salesmanList;
    }

    @Override
    public int getBenefit() {
        return super.getBenefit();
    }

    @Override
    public void calculateSalary() {
        super.calculateSalary();

        if (salesmanList != null && !salesmanList.isEmpty()) {
            for (Salesman currentSalesman : salesmanList) {
                salary += currentSalesman.getSalary();
            }
        }
    }
}
