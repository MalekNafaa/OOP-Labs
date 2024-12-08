package CashierApplication;

public abstract class Item implements Billable {
    private String itemId;
    private String name;
    private double price;

    Item(String itemId,String name,double price){

        this.itemId=itemId;
        this.name=name;
        this.price=price;

    }

    void setItemId(String itemId){this.itemId=itemId;}
    void setName(String name){this.name=name;}
    void setPrice(double price){this.price=price;}

    String getItemId(){return itemId;}
    String getName(){return name;}
    double getPrice(){return price;}

    @Override
    public double applyDiscount(double discountRate){
        return price-(discountRate/100);
    }
    @Override
    public String getDescription(){
        return "ID:"+itemId+",Name:"+name+",Price:"+price;
    }


}
