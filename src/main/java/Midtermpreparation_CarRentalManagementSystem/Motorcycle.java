package Midtermpreparation_CarRentalManagementSystem;

public class Motorcycle extends Vehicle {
    private double engineCapacity;
    Motorcycle(String vehicleId,String name,double rentalRate, double engineCapacity) {
        super(vehicleId,name,rentalRate);
        this.engineCapacity = engineCapacity;
    }
    void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
    double getEngineCapacity(){ return engineCapacity;}

    @Override
    public String getDescription(){
        return super.getDescription()+" CC: "+engineCapacity;
    }


}
