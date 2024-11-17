package Midtermpreparation_CarRentalManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String Name;
    private String phoneNumber;
    private List<RentalTransaction<? extends Vehicle>> rentalHistory;

    Customer(String cumtomerId,String Name,String phoneNumber)
    {
        this.customerId = cumtomerId;
        this.Name = Name;
        this.phoneNumber = phoneNumber;
        this.rentalHistory = new ArrayList<RentalTransaction<? extends Vehicle>>();
    }
    void setCustomerId(String customerId){this.customerId = customerId;}
    void setName(String Name){this.Name = Name;}
    void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
    void setRentalHistory(List<RentalTransaction<? extends Vehicle>> rentalHistory){this.rentalHistory = rentalHistory;}


    String getCustomerId(){return customerId;}
    String getName(){return Name;}
    String getPhoneNumber(){return phoneNumber;}
    List<RentalTransaction<? extends Vehicle>> getRentalHistory(){return rentalHistory;}

    public void addRentalTransaction(RentalTransaction<? extends Vehicle> transaction) {
        rentalHistory.add(transaction);
    }

}
