package Midtermpreparation_CarRentalManagementSystem;

import java.util.Date;
import java.util.HashMap;

public class Vehicle implements Rentable {
    private String vehicleId;
    private String name;
    double rentalRate;
    HashMap<Date,Integer> kilometerRecord;

    @Override
    public double applyDiscount(double discountRate){
        return rentalRate - (discountRate/100);
    }
    @Override
    public String getDescription()
    {
        return "ID"+vehicleId+ "name: "+name +" rentalRate: "+rentalRate;
    }
    Vehicle(String vehicleId,String name,double rentalRate)
    {
        this.vehicleId=vehicleId;
        this.name=name;
        this.rentalRate=rentalRate;
        this.kilometerRecord=new HashMap<>();
    }

    void setVechileId(String vechileId){this.vehicleId=vechileId;}
    void setName(String name){this.name=name;}
    void setRentalRate(double rentalRate){this.rentalRate=rentalRate;}

    String getVechileId(){return vehicleId;}
    String getName(){return name;}
    double getRentalRate(){return rentalRate;}

    void addKilometers(Date rentaldate,int kilometer){
        kilometerRecord.put(rentaldate,kilometer);
    }
    int getTotalKilometers(){
        int total=0;
        for(Integer kilometers : kilometerRecord.values())
        {
            total+= kilometers;
        }
        return total;
    }


}
