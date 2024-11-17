package week5.model;

import Midtermpreparation_CarRentalManagementSystem.CarType;
import week5.interfaces.Repairable;

public class Car extends Vehicle implements Repairable
{

    private int lifespanReduction;

    public Car(String modelName)
    {
        super(modelName);
        lifespanReduction = 0;
    }
    public Car(String modelName,int mileage,int health)
    {
        super(modelName,mileage,health);
        lifespanReduction = 0;
    }




    @Override
    public String repair() {
        return " Engine tuned and oil changed for " + getModelName();
    }

    @Override
    public int expectedLifespan()
    {
        return 150000;
    }

    @Override
    public int getLifespanReduction()
    {
        return lifespanReduction;
    }

    @Override
    public String service()
    {
        String startingString = getModelName() + " (Health: " + getHealth() + " | Mileage: " + getMileage() + "): ";
        String serviceProcedure = startingString;
        if(getMileage() > 10000)
            serviceProcedure += "Change Oil\n";
        if(getHealth() < 80 && getHealth() > 50)
            serviceProcedure += "Regular Repair Check\n";
        else if(getHealth() < 50)
            serviceProcedure += "Repair Engine\n";
        return serviceProcedure.equalsIgnoreCase(startingString) ? serviceProcedure + "No service needed" : serviceProcedure;
    }

    public void drive(int miles)
    {
        if(miles < 0) return;
        setMileage(getMileage()+miles);
        setHealth(getHealth() - 1);

        // If health drops below 30, reduce expectedLifespan by 10k
        if(getHealth() < 30) lifespanReduction += 10000;
        //if(getHealth() < 30) remainingLifespan = Math.max(0, remainingLifespan - 10000);
    }
}
