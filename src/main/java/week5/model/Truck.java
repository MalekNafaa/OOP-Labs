package week5.model;

import week5.interfaces.Repairable;

public class Truck extends Vehicle implements Repairable {

    private int lifespanReduction;

    public Truck(String modelName)
    {
        super(modelName);
        lifespanReduction = 0;
    }
    public Truck(String modelName,int mileage,int health)
    {
        super(modelName,mileage,health);
        lifespanReduction = 0;
    }


    @Override
    public String repair() {
        return " Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public int expectedLifespan()
    {
        return 300000;
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
        if(getMileage() > 20000)
            serviceProcedure += "Change Oil\n";
        if(getHealth() < 80 && getHealth() > 50)
            serviceProcedure += "Regular Repair Check\n";
        else if(getHealth() < 50)
            serviceProcedure += "Repair Engine\n";
        return serviceProcedure.equalsIgnoreCase(startingString) ? serviceProcedure + "No service needed" : serviceProcedure;
    }

    public void haul(int loadWeight)
    {
        if (loadWeight < 0) return;
        setHealth(getHealth() - 2);
        if(loadWeight>5000) setHealth(getHealth() - 3);
        if(getHealth() < 30 ) lifespanReduction += 20000;
    }


}
