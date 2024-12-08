package CashierApplication;

import java.util.List;
import java.util.Map;

public class RetailStore {
    String Storename;
    List<Customer> customers;
    Map<String,Item> inventory;

    void addCustomer(Customer customer) {
        customers.add(customer);
    }
    void addItem(Item item) {
        inventory.put(item.getName(), item);
    }
    Customer getCustomer(String customerId) {
        for(Customer customer : customers) {
            if(customerId.equals(customer.getCustomerId())) {
                return customer;
            }
        }
        return null;
    }
    void displayInventory() {
        for(Customer customer : customers) {
            System.out.println(customer);
            for(Item item : inventory.values()) {
                System.out.println(item.getName());
            }
            System.out.println("-----");
        }
    }
    double calculateTotalRevenue() {
        double total=0;
        for(Customer customer : customers) {
            for(Item item : inventory.values()) {
                total+=item.getPrice();
            }
        }
        return total;
    }
    void setStorename(String storename) {this.Storename = storename;}
    String getStorename() {return Storename;}
    List<Customer> getCustomers() {return customers;}
    Map<String, Item> getInventory() {return inventory;}


}
