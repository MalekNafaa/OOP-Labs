package Midtermpreparation_CarRentalManagementSystem;

import java.util.Date;
import java.util.HashMap;

public class RentalTransaction<T extends Vehicle & Rentable> {
    private String transactionId;
    private Date rentalDate;
    private HashMap<T,Integer> rentedVehicles;
    private int customerId;

    RentalTransaction(String transactionId,Date rentalDate,int customerId) {
        this.transactionId = transactionId;
        this.rentalDate = rentalDate;
        this.customerId = customerId;
        this.rentedVehicles = new HashMap<>();
    }

    void addCarToRentedVehicle(T vehicle,int days) {
        rentedVehicles.put(vehicle,days);
    }

    double calculateTotalAmount(){
        double total = 0;
        for(T vehicle : rentedVehicles.keySet()){
            total += rentedVehicles.get(vehicle);
        }
        return total;
    }
    void setTransactionId(String transactionId) {this.transactionId = transactionId;}
    void setRentalDate(Date retnalDate) {this.rentalDate = rentalDate;}
    void setCustomerId(int customerId) {this.customerId = customerId;}

    String getTransactionId() {return transactionId;}
    Date getRentalDate() {return rentalDate;}
    int getCustomerId() {return customerId;}
    HashMap<T,Integer> getRentedVehicles() {return rentedVehicles;}


}
