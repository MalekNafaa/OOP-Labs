package Midtermpreparation_MarketplaceInventoryandOrderManagementSystem;

public class Milk extends Item implements Sellable {

    private double fat;


    public Milk(String barCode, String name, double price,double fat) {
        super(barCode, name, price);
        this.fat=fat;
    }

    void setFat(Double fat){this.fat=fat;}
    double getFat(){return fat;}

    @Override
    public String getDescription() {
        return super.getDescription()+" "+fat ;
    }


}
