package Midtermpreparation_CarRentalManagementSystem;

import java.util.Date;
import java.util.Map;

public class RunMain {
    public static void main(String[] args) {

        RentalCompany rentalCompany = new RentalCompany("Best Rentals");

        Car car1 = new Car("C001", "Toyota Camry", 50.0, CarType.SEDAN, "Gasoline");
        Car car2 = new Car("C002", "Ford Explorer", 70.0, CarType.SUV, "Diesel");
        Motorcycle motorcycle1 = new Motorcycle("M001", "Yamaha MT-07", 30.0, 689);
        Motorcycle motorcycle2 = new Motorcycle("M002", "Kawasaki Ninja 400", 40.0, 399);

        rentalCompany.addVehicle(car1);
        rentalCompany.addVehicle(car2);
        rentalCompany.addVehicle(motorcycle1);
        rentalCompany.addVehicle(motorcycle2);

        RentalTransaction<Car> carRentalTransaction = new RentalTransaction<>("R001", new Date(), 101);
        carRentalTransaction.addCarToRentedVehicle(car1, 3);

        RentalTransaction<Motorcycle> motorcycleRentalTransaction = new RentalTransaction<>("R002", new Date(), 101);
        motorcycleRentalTransaction.addCarToRentedVehicle(motorcycle1, 2);

        Customer customer = new Customer("C101", "John Doe", "123-456-7890");
        customer.addRentalTransaction(carRentalTransaction);
        customer.addRentalTransaction(motorcycleRentalTransaction);

        rentalCompany.addCustomer(customer);

        System.out.println("Rental History for Customer: " + customer.getName());
        for (RentalTransaction<? extends Vehicle> transaction : customer.getRentalHistory()) {
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Rental Date: " + transaction.getRentalDate());
            for (Map.Entry<? extends Vehicle, Integer> entry : transaction.getRentedVehicles().entrySet()) {
                Vehicle vehicle = entry.getKey();
                int days = entry.getValue();
                System.out.println(vehicle.getDescription() + ", Rental Days: " + days);
            }
            System.out.println("Total Amount: " + transaction.calculateTotalAmount());
            System.out.println();
        }

        // Display the total revenue for the company
        double totalRevenue = rentalCompany.calculateTotalRevenue();
        System.out.println("Total Revenue for " + rentalCompany.getCompanyName() + ": $" + totalRevenue);

    }

}
