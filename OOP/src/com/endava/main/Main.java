package com.endava.main;

import com.endava.brokers.Product;
import com.endava.brokers.Subscription;
import com.endava.products.Salesman;
import com.endava.products.TeamLeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbrumusescu on 8/16/2015.
 */
public class Main {
    public static void main(String[] args) {
        //Products:
        Product phone = new Product();
        phone.setName("Phone");
        phone.setPrice(150);
        System.out.println(phone.getName() + " " + phone.getPrice());

        Product router = new Product();
        router.setName("Router");
        router.setPrice(200.5);
        System.out.println(router.getName() + " " + router.getPrice());

        //Subscription:
        Subscription phoneSubscription = new Subscription();
        phoneSubscription.setName("Phone Subscription");
        phoneSubscription.setMonths(24);
        phoneSubscription.setPrice(50);
        System.out.println(phoneSubscription.getName() + " " + phoneSubscription.getTotalPrice());

        Subscription internetSubscription = new Subscription();
        internetSubscription.setName("Internet Subscription");
        internetSubscription.setMonths(24);
        internetSubscription.setPrice(80);
        System.out.println(internetSubscription.getName() + " " + internetSubscription.getTotalPrice());

        Salesman Robert = new Salesman();
        Robert.setName("Robert");
        Robert.setBenefit(25);
        List<Product> RobertProducts = new ArrayList<>();
        RobertProducts.add(phone);
        RobertProducts.add(phone);
        RobertProducts.add(router);
        Robert.setProductList(RobertProducts);
        List<Subscription> RobertSubscription = new ArrayList<>();
        RobertSubscription.add(internetSubscription);
        Robert.setSubscriptionList(RobertSubscription);
        System.out.println("Salesman " + Robert.getName() + " sold " + Robert.getSalary());

        Salesman Delia = new Salesman();
        Delia.setName("Delia");
        Delia.setBenefit(20);
        List<Product> DeliaProducts = new ArrayList<>();
        DeliaProducts.add(phone);
        DeliaProducts.add(router);
        DeliaProducts.add(router);
        Delia.setProductList(DeliaProducts);
        List<Subscription> DeliaSubscription = new ArrayList<>();
        DeliaSubscription.add(internetSubscription);
        DeliaSubscription.add(phoneSubscription);
        Delia.setSubscriptionList(DeliaSubscription);
        System.out.println("Salesman " + Delia.getName() + " sold " + Delia.getSalary());

        Salesman Mike = new Salesman();
        Mike.setName("Mike");
        Mike.setBenefit(20);
        List<Product> MikeProducts = new ArrayList<>();
        MikeProducts.add(router);
        MikeProducts.add(router);
        MikeProducts.add(router);
        Mike.setProductList(MikeProducts);
        List<Subscription> MikeSubscription = new ArrayList<>();
        MikeSubscription.add(internetSubscription);
        internetSubscription.setMonths(48);
        MikeSubscription.add(internetSubscription);
        MikeSubscription.add(phoneSubscription);
        Mike.setSubscriptionList(MikeSubscription);
        System.out.println("Salesman " + Mike.getName() + " sold " + Mike.getSalary());

        TeamLeader teamLeader = new TeamLeader();
        teamLeader.setName("Alex");
        teamLeader.setBenefit(15);
        List<Product> teamLeaderProducts = teamLeader.getProductList();
        teamLeaderProducts.add(phone);
        teamLeader.setProductList(teamLeaderProducts);
        List<Subscription> teamLeaderSubscriptionList = teamLeader.getSubscriptionList();
        teamLeaderSubscriptionList.add(internetSubscription);
        List<Salesman> AlexSalesmanList = new ArrayList<>();
        AlexSalesmanList.add(Robert);
        AlexSalesmanList.add(Mike);
        AlexSalesmanList.add(Delia);
        teamLeader.setSalesmanList(AlexSalesmanList);
        System.out.println("Team Leader " + teamLeader.getName() + " sold " + teamLeader.getSalary());
    }
}
