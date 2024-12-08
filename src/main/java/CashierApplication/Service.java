package CashierApplication;

public class Service extends Item {
    private double serviceDuration;

    Service(String itemId,String name,int price,double serviceDuration)
    {
        super(itemId,name,price);
        this.serviceDuration=serviceDuration;
    }

    void setServiceDuration(double serviceDuration){this.serviceDuration=serviceDuration;}
    double getServiceDuration(){return serviceDuration;}

    @Override
    public String getDescription(){
        return super.getDescription()+" service Duration: "+serviceDuration;
    }

}
