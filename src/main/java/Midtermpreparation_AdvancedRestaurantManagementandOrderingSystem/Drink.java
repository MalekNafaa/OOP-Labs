package Midtermpreparation_AdvancedRestaurantManagementandOrderingSystem;

public class Drink extends MenuItem{
    private double volume;

    Drink(String code,String name,double price,double volume){
        super(code,name,price);
        this.volume=volume;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + "volume: "+volume;
    }
    void setVolume(double volume){this.volume=volume;}
    double getVolume(){return volume;}


}
