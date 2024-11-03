package week5.model;

public abstract class Vehicle
{
    private String modelName;
    private int mileage;
    private int health;

    public Vehicle(String modelName, int mileage, int health)
    {
        this.modelName = modelName;
        if(mileage < 0) mileage = 0;
        this.mileage = mileage;
        if(health < 0 || health > 100) health = 100;
        this.health = health;
    }
    public Vehicle(String modelName)
    {
        this(modelName, 0, 100);
    }

    public String getModelName()
    {
        return modelName;
    }

    public int getMileage()
    {
        return mileage;
    }

    protected void setMileage(int mileage)
    {
        this.mileage = mileage;
    }
    protected void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }
    public abstract int expectedLifespan();
    public abstract String service();


    //Added
    public abstract int getLifespanReduction();

    public boolean needsMaintenance()
    {
        return health<70;
    }

    public int calculateRemainingLifeSpan()
    {
        return Math.max(0, (expectedLifespan() - mileage) * (health / 100) - getLifespanReduction());
        //return (expectedLifespan() - mileage) * (health / 100);
    }

    public void simulateYear()
    {
        health -= (mileage / expectedLifespan() * 10);
    }

    public void performMaintenance(Vehicle vehicle)
    {

        if(vehicle instanceof Car)
        {
            Car thisCar = (Car) vehicle;
            System.out.println(thisCar.repair());
            thisCar.drive(7000);
        }
        else if(vehicle instanceof Truck)
        {
            Truck thisTruck = (Truck) vehicle;
            System.out.println(thisTruck.repair());
            thisTruck.haul(6000);
        }
        else if(vehicle instanceof Motorcycle)
        {
            Motorcycle thisMotorcycle = (Motorcycle) vehicle;
            thisMotorcycle.race(505);
        }
    }

    // Motorbike 50000, expectedLifespan = 5000;

}
