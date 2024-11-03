package week5.model;

public class Motorcycle extends Vehicle{

    private int lifespanReduction;

    public Motorcycle(String modelName)
    {
        super(modelName);
        lifespanReduction = 0;
    }
    public Motorcycle(String modelName,int mileage,int health)
    {
        super(modelName,mileage,health);
        lifespanReduction = 0;
    }
    @Override
    public int expectedLifespan() {
        return 50000;
    }

    @Override
    public int getLifespanReduction() {
        return lifespanReduction;
    }

    @Override
    public String service()
    {
        String startingString = getModelName() + " (Health: " + getHealth() + " | Mileage: " + getMileage() + "): ";
        String serviceProcedure = startingString;
        if(getMileage() > 5000)
            serviceProcedure += "Lubricate the chain\n";
        if(getHealth() < 80 && getHealth() > 50)
            serviceProcedure += "Tune the engine\n";
        else if(getHealth() < 50)
            serviceProcedure += "Repair Engine\n";
        return serviceProcedure.equalsIgnoreCase(startingString) ? serviceProcedure + "No service needed" : serviceProcedure;
    }

    public void race(int miles)
    {
        if(miles < 0) return;
        setHealth(getHealth()-5);
        if(getHealth()<40) lifespanReduction += 5000;



    }



}
