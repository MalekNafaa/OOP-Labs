package week5;

import week5.model.Car;
import week5.model.Motorcycle;
import week5.model.Truck;
import week5.model.Vehicle;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Vehicle car = new Car("Alfa Romeo");
        Vehicle truck = new Truck("MAN");
        Vehicle motorbike = new Motorcycle("Suzuki");

        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(motorbike);

        car.performMaintenance(motorbike);


        for(Vehicle vehicle : vehicles)
        {
            vehicle.service();
            vehicle.simulateYear();

            if(vehicle instanceof Car)
            {
                Car thisCar = (Car) vehicle;
                thisCar.drive(12500);
            }
            else if(vehicle instanceof Truck)
            {
                Truck thisTruck = (Truck) vehicle;
                thisTruck.haul(6000);
            }
            else if(vehicle instanceof Motorcycle)
            {
                Motorcycle thisMotorcycle = (Motorcycle) vehicle;
                thisMotorcycle.race(5000);
            }

        }

    }

}