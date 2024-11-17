package Midtermpreparation_AdvancedRestaurantManagementandOrderingSystem;

public abstract class MenuItem implements Billable{
    private String code;
    private String name;
    private double price;

    MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public double applyDiscount(double discountRate) {
        return price * (discountRate/100);
    }
    @Override
    public String getDescription(){
        return "Hi this MenuItem have code: " + code + " and name: " + name + " and price: " + price;
    }

    void getCode(String code){this.code=code;}
    void getName(String name){this.name=name;}
    void getPrice(double price){this.price=price;}

    String getCode(){return code;}
    String getName(){return name;}
    double getPrice(){return price;}



}
