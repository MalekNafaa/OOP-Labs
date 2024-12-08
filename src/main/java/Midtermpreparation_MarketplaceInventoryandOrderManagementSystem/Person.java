package Midtermpreparation_MarketplaceInventoryandOrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<Order<? extends Item>> orders;

    Person(String name,int age){
    this.name=name;
    this.age=age;
    this.orders=new ArrayList<Order<? extends Item>>();
    }
    void setName(String name){this.name=name;}
    void setAge(int age){this.age=age;}
    void setOrders(List<Order<? extends Item>> orders){this.orders=orders;}

    String getName(){return name;}
    int getAge(){return age;}
    List<Order<? extends Item>> getOrders(){return orders;}

    void addOrder(Order<? extends Item> order){
        orders.add(order);
    }

}
