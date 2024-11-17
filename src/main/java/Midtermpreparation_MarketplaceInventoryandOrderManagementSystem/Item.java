package Midtermpreparation_MarketplaceInventoryandOrderManagementSystem;

public abstract class Item implements Sellable{
    private String barCode;
    private String name;
    private double price;

    public Item(String barCode, String name, double price) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }


    void setBarCode(String barCode) {this.barCode=barCode;}
    void setName(String name){this.name=name;}
    void setPrice(double price){this.price=price;}

    String getBarCode(){return barCode;}
    String getName(){return name;}
    Double getPrice(){return price;}


    @Override
    public double calculateDiscount(double discountRate) {
        return price-(discountRate/100);
    }

    @Override
    public String getDescription() {
        return "Item Description : " + name +" "+barCode+ " "+price;
    }

}
