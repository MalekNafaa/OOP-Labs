package week7.ECommerceDiscountEngine;

public class Product {
    String name;
    int quantity;
    double price;

    public Product(String name,double price,int quantity){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
    }
    public void setName(String name)    {this.name=name;}
    public void setQuantity(int quantity)   { this.quantity=quantity; }
    public void setPrice(double price){ this.price=price; }

    public String getName(){return name;}
    public int getQuantity(){return quantity;}
    public double getPrice(){return price;}

}