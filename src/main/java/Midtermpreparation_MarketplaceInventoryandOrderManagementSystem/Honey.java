package Midtermpreparation_MarketplaceInventoryandOrderManagementSystem;

public class Honey extends Item implements Sellable{
    private HoneyType honeyType;

    Honey(String barCode, String name, double price,HoneyType honeyType) {
        super(barCode, name, price);
        this.honeyType=honeyType;

    }
    void setHoneyType(HoneyType honeyType){this.honeyType=honeyType;}
    HoneyType getHoneyType(){return honeyType;}

    @Override
    public String getDescription() {
        return super.getDescription()+" "+honeyType;
    }

}
