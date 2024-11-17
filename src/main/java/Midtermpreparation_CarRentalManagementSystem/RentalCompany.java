package Midtermpreparation_CarRentalManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalCompany {

    String companyName;
    List<Customer> customers;
    Map<String ,Vehicle> vehicles;

    public RentalCompany(String companyName) {
        this.companyName = companyName;
        this.customers = new ArrayList<>();
        this.vehicles = new HashMap<>();
    }

    void addCustomer(Customer customer){
        customers.add(customer);
    }
    void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getVechileId(),vehicle);
    }
    Customer getCustomer(String cutomerId){
        for(Customer customer : customers){
            if(customer.getCustomerId().equals(cutomerId))
            {
                return customer;
            }
        }
        return null;
    }
    void displayInventory(){
        for(Vehicle vehicle : vehicles.values()){
            System.out.println(vehicle);
            System.out.println(vehicle.getDescription());
        }

    }

    double calculateTotalRevenue(){
        double totalRevenue = 0;
        for (Customer customer : customers) {
            for (RentalTransaction<? extends Vehicle> transaction : customer.getRentalHistory()) {
                totalRevenue += transaction.calculateTotalAmount();
            }
        }
        return totalRevenue;
    }
    void setCompanyName(String companyName) {this.companyName = companyName;}
    void setCustomers(List<Customer> customers) {this.customers = customers;}
    void setVehicles(Map<String ,Vehicle> vehicles) {this.vehicles = vehicles;}

    String getCompanyName() {return companyName;}
    List<Customer> getCustomers() {return customers;}
    Map<String ,Vehicle> getVehicles() {return vehicles;}


}
