package Midtermpreparation_AdvancedRestaurantManagementandOrderingSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String customerId;
    String customerName;
    String phoneNumbe;
    List<TableReservation<? extends MenuItem>> reservationList;

    Customer(String customerId,String customerName,String phoneNumber)
    {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumbe = phoneNumber;
        this.reservationList = new ArrayList<TableReservation<? extends MenuItem>>();
    }

    void addReservation(TableReservation<? extends MenuItem> reservation){
        reservationList.add(reservation);
    }
    void setCustomerId(String customerId){
        this.customerId = customerId;
    }
    void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    void setPhoneNumber(String phoneNumber){
        this.phoneNumbe = phoneNumber;
    }

    String getCustomerId(){
        return customerId;
    }
    String getCustomerName(){
        return customerName;
    }
    String getPhoneNumber(){
        return phoneNumbe;
    }
    List<TableReservation<? extends MenuItem>> getReservationList(){return reservationList;}
}
