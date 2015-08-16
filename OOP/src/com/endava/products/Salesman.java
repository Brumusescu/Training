package com.endava.products;

import com.endava.brokers.Product;
import com.endava.brokers.Subscription;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbrumusescu on 8/16/2015.
 */
public class Salesman {
    protected String name;
    protected int benefit;
    protected double salary = 0;

    protected List<Product> productList = new ArrayList<>();
    protected List<Subscription> subscriptionList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int beneffit) {
        this.benefit = beneffit;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public double getSalary() {
        setSalesSalary();
        return salary;
    }

    public void calculateSalary () {
        if (productList != null && !productList.isEmpty()) {
            for (Product currentProduct : productList) {
                salary += currentProduct.getPrice();
            }
        }

        if (subscriptionList != null && !subscriptionList.isEmpty()) {
            for (Subscription currentSubscription : subscriptionList) {
                salary += currentSubscription.getTotalPrice();
            }
        }
    }

    public void setSalesSalary() {
        calculateSalary();
        salary = (salary * benefit) / 100;
    }
}
